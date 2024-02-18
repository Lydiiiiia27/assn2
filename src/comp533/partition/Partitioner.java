package comp533.partition;


import gradingTools.comp533s19.assignment0.AMapReduceTracer;

public class Partitioner<V> extends AMapReduceTracer implements Partitioned<String, V> {

    @Override
    public int getPartition(String key, V value, int numberOfPartitions) {
        if (!Character.isLetter(key.charAt(0))) {
            return 0;
        }

        char lowerCaseFirstChar = Character.toLowerCase(key.charAt(0));
        int offset = lowerCaseFirstChar - 'a';
        int s = (int) Math.ceil((double) ('z' - 'a' +1)/numberOfPartitions);
        int partition = (int) Math.floor((double) (offset + 1)/s);

        tracePartitionAssigned(key, value, partition, numberOfPartitions);
        return partition;
    }

    @Override
    public String toString(){
        return PARTITIONER;
    }

}