/**
 * SearchTree
 */
public interface SearchTree<E>{
    public int add(E element);
    public int find(E element);
    public int remove(E element);
    public int find_mode();
}