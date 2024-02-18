package comp533.mvc;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

//key-value
import comp533.Barrier;
import comp533.Joiner;
import comp533.Slave;
import comp533.factory.MapperFactory;
import comp533.mapper.MapperInterface;
import comp533.mapping.KeyValueInterface;
import comp533.mapping.KeyValuePair;
import comp533.reducer.ReducerInterface;
import gradingTools.comp533s19.assignment0.AMapReduceTracer;
//import gradingTools.comp533s19.assignment0.testcases.factories.ReducerFactory;

public class TokenCounterModel extends AMapReduceTracer {
    private String inputString;
    private Map<String, Integer> result;
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private int numThreads = 0;
    private List<Thread> threads = new ArrayList<>();


    /*
    public String getInputString() {
        return inputString;
    }
*/
    private final BlockingQueue<KeyValuePair> keyValuePairQueue = new ArrayBlockingQueue<>(BUFFER_SIZE);
    private final List<LinkedList<KeyValuePair>> reductionQueueList = new ArrayList<>();

    private Joiner joiner;

    private Barrier barrier;



    public void setInputString(final String inputString) {

        //initialize or clear relevant data structures
        final String oldInput = this.inputString;
        this.inputString = inputString;
        this.result = countTokens(inputString);
        /* using firePropertyChange
        changeSupport.firePropertyChange("InputString", oldInput, inputString);
        changeSupport.firePropertyChange("Result", null, result);
         */
        tracePropertyChange(new PropertyChangeEvent(this, "InputString", oldInput, inputString));
        tracePropertyChange(new PropertyChangeEvent(this, "Results", null, result));
    }


    /*
    public void setInputString(final String inputString){
        this.inputString = inputString;
        //result.clear();
        for (LinkedList<KeyValuePair> queue : this.reductionQueueList){
            queue.clear();
        }
        keyValuePairQueue.clear();

        //tokenize input string and map tokens to KeyValue, adding them to KeyValuePairQueue
        String [] tokens = inputString.split(" ");
        for (String token : tokens){
            KeyValuePair keyValuePair = new KeyValuePair<>(token, 1);
            traceEnqueueRequest(keyValuePair);

            try{
                this.keyValuePairQueue.put(keyValuePair);
            }catch (InterruptedException e){
                Thread.currentThread().interrupt();
                return;
            }
            traceEnqueue(this.keyValuePairQueue);
        }

        //add end-of-input markers to KeyValuePairQueue for each slave
        for (int i=0; i< this.numThreads; i++){
            try{
                this.keyValuePairQueue.put(new KeyValuePair<>(null, null));
            }catch (InterruptedException e){
                Thread.currentThread().interrupt();
                return;
            }
        }

        //wait for all slave threads to finish their work using the joiner
        this.joiner.join();

        //merge results from all reduction queues into the final result map
        mergeReductionQueues();

        //announce the change in the result property
        tracePropertyChange(new PropertyChangeEvent(this,"Result", null, this.result));
    }


*/
    private synchronized void mergeReductionQueues(){
        for (LinkedList<KeyValuePair> reductionQueue : this.reductionQueueList){
            for (KeyValuePair pair : reductionQueue){
                this.result.merge((String) pair.getKey(), (Integer) pair.getValue(), Integer:: sum);
            }
        }
        traceAddedToMap(result, reductionQueueList);
    }

    public Map<String, Integer> getResult() {
        return result;
    }

    /*mvc countToken
    private Map<String, Integer> countTokens(String input) {
        HashMap<String, Integer> tokenCounts = new HashMap<>();
        String[] tokens = input.split(" ");
        for (String token : tokens) {
            tokenCounts.put(token, tokenCounts.getOrDefault(token, 0) + 1);
        }
        return tokenCounts;
    }
*/
    
    /* key value countToken*/
    private Map<String, Integer> countTokens(final String input) {
        final MapperInterface<String, Integer> mapper = MapperFactory.getMapper();
        final List<String> tokens = Arrays.asList(input.split(" "));
        final List<KeyValueInterface<String, Integer>> mappedTokens = mapper.map(tokens);

        final ReducerInterface<String, Integer> reducer = comp533.factory.TokenReduceFactory.getReducer();
        // Tracing the mapping operation
        traceMap(input, mappedTokens);

        // Aggregate the mapped tokens
        final Map<String, Integer> tokenCounts = reducer.reduce(mappedTokens);
        
        
/*        for (KeyValueInterface<String, Integer> b : mappedTokens) {
            final String key = b.getKey();
            tokenCounts.put(key, tokenCounts.getOrDefault(key, 0) + b.getValue());
        }*/

        // Tracing the reducing operation
        traceReduce(mappedTokens, tokenCounts);

        return tokenCounts;
    }

    public void setNumThreads(final int numThreads){
        int oldNumThreads = this.numThreads;
        this.numThreads = numThreads;


        this.joiner = Joiner.getJoiner(numThreads) ;
        this.barrier = Barrier.getBarrier(numThreads);


        this.reductionQueueList.clear();
        for (int i=0; i<numThreads; i++){
            this.reductionQueueList.add(new LinkedList<>());
        }


        tracePropertyChange(new PropertyChangeEvent(this,"NumThreads", oldNumThreads, this.numThreads));
        createThreads();
    }


    private void createThreads(){
        List<Thread> oldThreads = new ArrayList<>(threads);
        threads.forEach(Thread::interrupt);
        threads.clear();

        for (int i=0; i<numThreads; i++){
            Slave slave = new Slave(i, this, barrier, joiner,keyValuePairQueue, reductionQueueList.get(i));
            Thread thread = new Thread(slave, "Slave" + i);
            threads.add(thread);
            thread.start();
        }
        tracePropertyChange(new PropertyChangeEvent(this, "Threads", oldThreads,new ArrayList<>(threads)));
    }


    public void addPropertyChangeListener(final PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    @Override
    public String toString() {
        return gradingTools.comp533s19.assignment0.AMapReduceTracer.MODEL;
    }

    public List<Thread> getThreads(){
        return Collections.unmodifiableList(threads);
    }
}
