package comp533.mapping;

public class KeyValuePair<K, V> implements KeyValueInterface<K, V> {
    private final K key;
    private V value;

    public KeyValuePair(final K keyParam,final V valueParam) {
        this.key = keyParam;
        this.value = valueParam;
    }

    @Override
    public  K getKey() {
        return key;
    }

    @Override
    public  V getValue() {
        return value;
    }

    @Override
    public void setValue(final V valueParam2) {
        this.value = valueParam2;
    }

    @Override
    public String toString() {
        return "(" + key + "," + value + ")";
    }

	
}
