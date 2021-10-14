import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class NavigableSetSkipList<E extends Comparable < E >> implements NavigableSet<E> {

	private SkipList<E> data;
	/**
	 * Constructor for NavigableSetSkipList().
	 */
	public NavigableSetSkipList() {
		data = new SkipList<>();
	}
	@Override
	public Iterator<E> iterator() {
		System.out.println("Unsupported Operation!");
		return null;
	}
	private class Iter<E extends Comparable < E >> implements Iterator<E>{
		private ArrayList<E> localData;
		int index;
		public Iter() {
			localData = new ArrayList<>();
			fillData();
			Collections.sort(localData);
			index = localData.size();
		}
		@Override
		public boolean hasNext() {
			if(index > 0) {
				return true;
			}
			return false;
		}
		@Override
		public E next() {
			if(!hasNext()) {
				throw new NoSuchElementException();
			}
			return localData.get(--index);
		}  
		
		private void fillData() {
			@SuppressWarnings("unchecked")
			Iterator<E> iter = (Iterator<E>) data.iterator();
			while(iter.hasNext()) {
				localData.add(iter.next());
			}
		}
	  }
	/**
	 * Returns an iterator over the elements in this set, in descending order.
	 */
	@Override
	public Iterator<E> descendingIterator() {
		return new Iter<E>();
	}

	@Override
	/**
	 * Deletes element in skip list if the element is not exist it returns false.
	 */
	public boolean delete(E item) {
		if(data.remove(item)== null) {
			return false;
		}
		else {
			return true;
		}
	}

	@Override
	/**
	 * Insert element to skip list.
	 */
	public boolean insert(E item) {
		data.add(item);
		return true;
	}

	@Override
	public NavigableSet<E> headSet(E toElement, boolean inclusive) {
		System.out.println("Unsupported Operation!");
		return null;
	}

	@Override
	public NavigableSet<E> tailSet(E fromElement, boolean inclusive) {
		System.out.println("Unsupported Operation!");
		return null;
	}
}
