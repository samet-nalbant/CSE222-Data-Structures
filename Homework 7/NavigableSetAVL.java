import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Stack;

public class NavigableSetAVL<E extends Comparable < E >> implements NavigableSet<E> {

	private AVLTree<E> data;
	/**
	 * Constructor for NavigableSetAVL
	 */
	public NavigableSetAVL() {
		data = new AVLTree<>();
	}
	private class Iter<E extends Comparable < E >> implements Iterator<E>{
		private Stack<E> localData = new Stack<>();
		
		@SuppressWarnings("unchecked")
		public Iter() {
			localData = new Stack<>();
			traverseTree((BinaryTree<E>) data);
		}
		@Override
		public boolean hasNext() {
			return !localData.isEmpty();
		}
		@Override
		public E next() {
			if(!hasNext()) {
				throw new NoSuchElementException();
			}
			return localData.pop();
		}  
		private void traverseTree(BinaryTree<E> binaryTree) {
			if(binaryTree == null){
				return;
			}
			localData.add(binaryTree.getData());
			traverseTree(binaryTree.getLeftSubtree());
			traverseTree(binaryTree.getRightSubtree());
		}
	  }
	@Override
	/**
	 * Returns an iterator over the elements in this set, in ascending order.
	 */
	public Iterator<E> iterator() {
		return new Iter<E>();
	}
	
	/**
	 * Insert an element to tree. If the operation is done correctly It returns true, otherwise It returns false.
	 */
	@Override
	public boolean insert(E item) {
		return data.add(item);
	}
	@Override
	/**
	 * Returns a view of the portion of this set whose elements are strictly less than toElement.
	 */
	public NavigableSet<E> headSet(E toElement, boolean inclusive) {
		NavigableSetAVL<E> temp = new NavigableSetAVL<>();
		temp = (NavigableSetAVL<E>) traverseTree(temp,data,toElement,inclusive,true);
		return temp;
	}
	/**
	 * Returns a view of the portion of this set whose elements are greater than (or equal to, if inclusive is true) fromElement.
	 */
	@Override
	public NavigableSet<E> tailSet(E fromElement, boolean inclusive) {
		NavigableSetAVL<E> temp = new NavigableSetAVL<>();
		temp = (NavigableSetAVL<E>) traverseTree(temp,data,fromElement,inclusive,false);
		return temp;
	}
	
	private NavigableSet<E> traverseTree(NavigableSet<E> data,BinaryTree<E> localRoot,E element, boolean inclusive,boolean control) {
		if(localRoot == null) {
			return null;
		}
		if(control && inclusive) {
			if(localRoot.getData().compareTo(element) <= 0) {
				data.insert(localRoot.getData());
			}
		}
		else if(control && !inclusive) {
			if(localRoot.getData().compareTo(element) < 0) {
				data.insert(localRoot.getData());
			}
		}
		else if(!control && inclusive) {
			if(localRoot.getData().compareTo(element) >= 0) {
				data.insert(localRoot.getData());
			}
		}
		else if(!control && !inclusive) {
			if(localRoot.getData().compareTo(element) > 0) {
				data.insert(localRoot.getData());
			}
		}
		traverseTree(data,localRoot.getLeftSubtree(),element,inclusive,control);
		traverseTree(data,localRoot.getRightSubtree(),element,inclusive,control);
		return data;
	}
	@Override
	public Iterator<E> descendingIterator() {
		System.out.println("Unsupported Operation!");
		return null;
	}
	@Override
	public boolean delete(E item) {
		System.out.println("Unsupported Operation!");
		return false;
	}

}



