package comp533.partition;

public class PartitionerFactory {

    private static Partitioned<String, Integer> partitioner = new Partitioner<>();


    public static Partitioned<String, Integer> getPartitioner(){
        return  partitioner;
    }
    public static void setPartitioner(Partitioned<String, Integer> newPartitioner){
        partitioner = newPartitioner;
    }


    public static Partitioned<String, Integer> getSingleton(){
        if(partitioner == null){
            partitioner = new Partitioner<>();
        }
        return partitioner;
    }
}
