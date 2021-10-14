import java.util.LinkedList;

public class HashTableChain<K, V> implements KWHashMap<K, V> {

	
	private LinkedList<Entry2<K, V>>[] table;
	private int numKeys;
	private static final int CAPACITY = 101;
	private static final int LOAD_THRESHOLD = 3;
	private static class Entry2<K,V> {
		private final K key;
		
		private V value;
		
		/**
		 * Constructs an Entry with the given values
		 * @param key
		 * @param value
		 */
		public Entry2(K key, V value) {
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
}
	@SuppressWarnings("unchecked")
	public HashTableChain() {
		table = new LinkedList[CAPACITY];
	}
	
	@Override
	/**
	 * Returns the value associated with the specified key. Returns null if the key is not
present.
	 */
	public V get(Object key) {
		int index = key.hashCode() % table.length;
		if (index < 0) {
			index += table.length;
		}
		if (table[index] == null) {
			return null; 	
		}
		for (Entry2<K, V> nextItem : table[index]) {
			if (nextItem.getKey().equals(key)) {
				return nextItem.getValue();
			}
		}
		return null;
	}
	
	@Override
	/**
	 * Returns true if this table contains no key‐value mappings.
	 */
	public boolean isEmpty() {
		if(size() == 0) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	/**
	 * Associates the specified value with the specified key. Returns the previous value
associated with the specified key, or null if there was no mapping for the key.
	 */
	public V put(K key, V value) {
		int index = key.hashCode() % table.length;
		if (index < 0)
			index += table.length;
		if (table[index] == null) {
			table[index] = new LinkedList<>();
		}
		for (Entry2<K, V> nextItem : table[index]) {
			if (nextItem.getKey().equals(key)) {
				V oldVal = nextItem.getValue();
				nextItem.setValue(value);
				return oldVal;
			}
		}
		table[index].addFirst(new Entry2<>(key, value));
		numKeys++;
		if (numKeys > (LOAD_THRESHOLD * table.length)) {
			rehash();
		}
		return null;
	}

	@Override
	/**
	 * Removes the mapping for this key from this table if it is present (optional
operation). Returns the previous value associated with the specified key, or null if
there was no mapping
	 */
	public V remove(Object key) {
		int index = key.hashCode() % table.length;
		V temp = null;
		if (index < 0) {
			index += table.length;		
		}

		if(table[index] == null) {
			return null;
		}
		else {
			for(int i=0;i<table[index].size();i++) {
				if(key.equals(table[index].get(i).getKey())) {
					temp = (V) table[index].get(i).getValue();
					table[index].remove(i);
					numKeys--;
					break;
				}
			}
			if(table[index].size() == 0) {
				table[index] = null;
			}
			return temp;
		}
	}

	@Override
	/**
	 * Returns the size of the table
	 */
	public int size() {
		return numKeys;
	}
	@SuppressWarnings("unchecked")
	private void rehash() {
		LinkedList<Entry2<K, V>>[] oldTable = table;
		table = new LinkedList[2 * oldTable.length + 1];
		numKeys = 0;
		for (int i = 0; i < oldTable.length; i++) {
			if ((oldTable[i] != null)) {
				for(int j = 0;j<oldTable[i].size();j++) {
					put(oldTable[i].get(j).getKey(),oldTable[i].get(j).getValue());
				}
			}
		}
	}
}
