package comp533;

import comp533.mapping.KeyValuePair;
import comp533.mvc.TokenCounterModel;
import gradingTools.comp533s19.assignment0.AMapReduceTracer;

import java.util.LinkedList;
import java.util.concurrent.BlockingQueue;

public class Slave extends AMapReduceTracer implements SlaveRunnable  {
    private int slaveNumber;
    private TokenCounterModel model;
    private Barrier barrier;
    private Joiner joiner;
    private BlockingQueue<KeyValuePair> keyValuePairQueue;
    private LinkedList<KeyValuePair> reductionQueue;

    public Slave(int slaveNumber, TokenCounterModel model, Barrier barrier, Joiner joiner, BlockingQueue<KeyValuePair> keyValuePairQueue, LinkedList<KeyValuePair> reductionQueue) {
        this.slaveNumber = slaveNumber;
        this.model = model;
        this.barrier = barrier;
        this.joiner = joiner;
        this.keyValuePairQueue = keyValuePairQueue;
        this.reductionQueue = reductionQueue;
    }

    @Override
    public void run() {
        try {
            barrier.barrier();
            KeyValuePair<String, Integer> pair;
            while (true){
                pair = keyValuePairQueue.take();
                if (pair.getKey() == null&& pair.getValue() == null) {break;};

                synchronized (reductionQueue){
                    reductionQueue.add(pair);
                }

            }
        }catch(InterruptedException e){
            Thread.currentThread().interrupt();
        }finally {
            joiner.finished();
            synchronized (this){
                slaveNotifyMethod();
            }
        }
    }

    @Override
    public synchronized void slaveNotifyMethod() {
        traceNotify();
        this.notify();
    }



    @Override
    public String toString() {
        return AMapReduceTracer.SLAVE;
    }
}
