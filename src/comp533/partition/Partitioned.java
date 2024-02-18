package comp533.partition;

public interface Partitioned<K,V> {
    int getPartition(K key, V value, int numberOfPartitions);
}
