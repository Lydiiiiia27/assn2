package comp533.mapper;

import java.util.List;

import comp533.mapping.KeyValueInterface;

public abstract interface MapperInterface<K, V> {
    List<KeyValueInterface<K, V>> map(List<String> aStrings);
    
/*     static MapperInterface<K, V> getInstance(){
    	
    }*/
}
