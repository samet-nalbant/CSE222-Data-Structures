import java.util.HashMap;
import java.util.NoSuchElementException;

public class MyHashMap<K,V> extends HashMap<K, V> {
	private static final long serialVersionUID = 1L;
	
	
	@SuppressWarnings("hiding")
	private class MapIterator<K> implements Iterator<K>{
		int index =0;
		int iteratedValues = 0;
		K nextValue;
		K prevValue;
		@SuppressWarnings("unchecked")
		@Override
		public K next() {
			if(index >= size()) {
				throw new NoSuchElementException();
			}
			int j =0;
			for (Object i : keySet()){
				nextValue = (K)i;
				if(j == index) {
					break;
				}
				j++;
			}
			index = (index+1)%size();
			iteratedValues ++;
			return nextValue;
		}

		@SuppressWarnings("unchecked")
		@Override
		public K prev() {
			if(index <=0) {
				throw new NoSuchElementException();
			}
			int j =0;
			for (Object i : keySet()){
				prevValue = (K)i;
				if(j == index-1) {
					break;
				}
				j++;
			}
			index--;
			return prevValue;
		}

		@Override
		public boolean hasNext() {
			if(iteratedValues != size()) {
				return true;
			}
			return false;
		}
		@Override
		public boolean hasPrev(){
			if(index > 0) {
				return true;
			}
			return false;
		}
		MapIterator (K key){
			index =0;
			nextValue = null;
			prevValue = null;
			for (Object i : keySet()){
				if(key.equals(i)) {
					break;
				}
				index++;
			}
			if(index == size()) {
				index =0;
			}
		}

	}
	
	/**
	 * Return Iterator from given key value.If key is not in the hash map it starts from begining.
	 * @param key
	 * @return
	 */
	public Iterator<K> iterator(K key) {
		return new MapIterator<K>(key);
	}
	
}