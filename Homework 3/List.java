/**
 * list
 */


public interface List<E> {
    public void add(int index, E anEntry);
    public E get(int index);
    public int size();
    public int indexOf(Object obj);
}

