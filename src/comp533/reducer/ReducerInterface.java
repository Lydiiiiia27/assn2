package comp533.reducer;

import java.util.List;
import java.util.Map;

import comp533.mapping.KeyValueInterface;

public interface ReducerInterface<K, V> {
    Map<K, V> reduce(List<KeyValueInterface<K, V>> keyValues);
}
