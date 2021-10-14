

public class CoalescedHashMap<K,V> implements KWHashMap<K,V> {
	private Entry<K,V>[] table;
	private static final int START_CAPACITY = 10;
	private double LOAD_THRESHOLD = 0.75;
	private int numKeys ;
	private int numDeletes;
	private final Entry<K, V> DELETED = new Entry<>(null, null);
	private int collision = 0;
	private int collisionIndex;
	private static class Entry<K,V> {
		private K key;
		private int next;
		private V value;
		
		/**
		 * Constructs an Entry with the given values
		 * @param key
		 * @param value
		 */
		public Entry(K key, V value) {
			this.key = key;
			this.value = value;
			next = -1;
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
		public int getNext() {
			return next;
		}
		public void setNext(int next) {
			this.next = next;
		}
}
	@Override
	/**
	 * Returns the value associated with the specified key. Returns null if the key is not
present.
	 */
	public V get(Object key) {
		int index = find(key);
		if (table[index] != null)
			return table[index].getValue();
		else
			return null;
	}
	@SuppressWarnings("unchecked")
	public CoalescedHashMap() {
		table = new Entry[START_CAPACITY];
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
		int index = find(key);
		if(collision == 1) {
			table[collisionIndex].setNext(index);
			collision =0;
		}
		if (table[index] == null) {
			table[index] = new Entry<>(key, value);
			numKeys++;
			double loadFactor = (double) (numKeys + numDeletes) / table.length;
			if (loadFactor > LOAD_THRESHOLD)
				rehash();
			return null;
		}
		V oldVal = table[index].getValue();
		table[index].setValue(value);
		return oldVal;
	}

	@Override
	/**
	 * Removes the mapping for this key from this table if it is present (optional
operation). Returns the previous value associated with the specified key, or null if
there was no mapping
	 */
	public V remove(Object key) {
		int index = find(key);
		V temp = null;
		if(table[index] == null) {
			return null;
		}
		if(index == -1) {
			return null;
		}
		else {
			int oldIndex = 0;
			while(table[index].next != -1) {
				if(table[table[index].next].next == -1) {
					oldIndex = index;
				}
				table[index].key = table[table[index].next].getKey();
				table[index].value = table[table[index].next].getValue();
				index = table[index].getNext();
			}
			if(oldIndex != -1) {
				table[oldIndex].setNext(-1);
			}
			table[index] = DELETED;
			numKeys--;
			numDeletes++;
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
		Entry<K, V>[] oldTable = table;
		table = new Entry[2 * oldTable.length + 1];
		numKeys = 0;
		numDeletes = 0;
		for (int i = 0; i < oldTable.length; i++) {
			if ((oldTable[i] != null) && (oldTable[i] != DELETED)) {
				put(oldTable[i].getKey(), oldTable[i].getValue());
			}
		}
	}
	private int find(Object key) {
		int index = key.hashCode() % table.length;
		int quadratic = 1;
		if (index < 0)
			index += table.length; 
		while ((table[index] != null) && (!key.equals(table[index].getKey()))) {
			collision = 1;
			if(table[index].next == -1) {
				collisionIndex = index;
			}
			index += quadratic;
			quadratic += 2;
			if (index >= table.length)
				index = 0;
		}
		return index;
	}

}
