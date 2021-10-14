import java.util.Iterator;

public interface NavigableSet<E> {
	Iterator<E> iterator();
	Iterator<E> descendingIterator();
	boolean delete(E item);
	boolean insert(E item);
	NavigableSet<E> headSet(E toElement,boolean inclusive);
	NavigableSet<E> tailSet(E fromElement,boolean inclusive);
}
