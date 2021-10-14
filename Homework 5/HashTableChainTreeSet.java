
import java.util.TreeSet;
public class HashTableChainTreeSet<K extends Comparable<K> , V>  implements KWHashMap<K, V> {

	private TreeSet<Entry<K, V>>[] table;
	private int numKeys;
	private static final int CAPACITY = 101;
	private static final int LOAD_THRESHOLD = 3;	
	
	@SuppressWarnings("unchecked")
	public HashTableChainTreeSet() {
		table = new TreeSet[CAPACITY];
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
		for (Entry<K, V> nextItem : table[index]) {
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
			table[index] = new TreeSet<>();
		}
		for (Entry<K, V> nextItem : table[index]) {
			if (nextItem.getKey().equals(key)) {
				V oldVal = nextItem.getValue();
				nextItem.setValue(value);
				return oldVal;
			}
		}
		table[index].add(new Entry<>(key, value));
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
		if (index < 0)
			index += table.length;	
		if(table[index] == null) {
			return null;
		}
		else {
			for (Entry<K, V> nextItem : table[index]) {
				if(nextItem.getKey().equals(key)) {
					temp = nextItem.getValue();
					Entry<K,V> temp2 = new Entry<>(nextItem.getKey(), temp);
					table[index].remove(temp2);
					numKeys--;
					if(table[index].size() == 0) {
						table[index] = null;
					}
					break;
				}

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
		TreeSet<Entry<K, V>>[] oldTable = table;
		table = new TreeSet[2 * oldTable.length + 1];
		numKeys = 0;
		for(int i=0;i<oldTable.length;i++) {
			if ((oldTable[i] != null)) {
				for (Entry<K, V> nextItem : oldTable[i]) {
					put(nextItem.getKey(),nextItem.getValue());
				}		
			}
		
		}
	}

	
}
