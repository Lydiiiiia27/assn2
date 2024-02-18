package comp533.mapping;

public interface KeyValueInterface<K, V> {
	K getKey();
	V getValue();
	void setValue(V value);
}
