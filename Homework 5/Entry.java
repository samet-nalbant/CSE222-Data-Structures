

public class Entry<K extends Comparable<K>,V> implements Comparable<Entry<K,V>>{

	
	private final K key;
	
	private V value;
	
	/**
	 * Constructs an Entry with the given values
	 * @param key
	 * @param value
	 */
	public Entry(K key, V value) {
		this.key = key;
		this.value = value;
	}
	/**
	 * Retrieves the key
	 * @return
	 */
	public K getKey() {
		return key;
	}
	/**
	 * Retrieves the value
	 * @return
	 */
	public V getValue() {
		return value;
	}
	/**
	 * Sets the value
	 * @param val
	 * @return old value.
	 */
	public V setValue(V val) {
		V temp = value;
		value = val;
		return temp;
	}
	@Override
	public int compareTo(Entry<K,V> o) {
		return this.key.compareTo(o.getKey());
		
	}
	
	
}




