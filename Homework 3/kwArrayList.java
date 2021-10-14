
/**
 * kwArrayList
 */
public class kwArrayList<E> implements List<E>{ 
    private E[] data;
    private int size;
    private int capacity;
    /**
     *No argument constructor for kwArrayList.
     */
    @SuppressWarnings("unchecked")
    public kwArrayList(){
        size =0;
        capacity = 10;
        data = (E[])new Object[capacity];
    }
    /**
     * Constructer for the kwArrayList with initial capacity
     * @param capacity
     */
    @SuppressWarnings("unchecked")
    public kwArrayList(int capacity){
        size =0;
        this.capacity = capacity;
        data = (E[])new Object[capacity];
    }
    /**
     * Returns the item at positon index.If index is not valid throws ArrayIndexOutOfBoundsException.
     * @param index
     * @return object
     */
    @Override
    public E get(int index){
        if(index < 0 || index >= size){
            throw new ArrayIndexOutOfBoundsException(index);
        }
        return data[index];
    }
    /**
     * Replaces the element at the specified position in this list with the specified element.If index is not valid throws ArrayIndexOutOfBoundsException.
     * @param index
     * @param anEntry
     * @return
     */
    public E set(int index, E anEntry){
        if(index<0 || index >= size){
            throw new ArrayIndexOutOfBoundsException(index);
        }
        E old = data[index];
        data[index] = anEntry;
        return old;
    }
    /**
     * Returns the number of elements in this list.
     * @return integer
     */
    @Override
    public int size(){return this.size;}
    /**
     * Appends the specified element to the end of this list.
     */
    
    public boolean add(E anEntry){
        if(size >= capacity){
            reallocate();
        }
        data[size] = anEntry;
        size ++;
        return true;
    }
    /**
     * Inserts the specified element at the specified position in this list. If index is not valid throws ArrayIndexOutOfBoundsException.
     * @param index
     * @param anEntry
     */
    @Override
    public void add(int index, E anEntry){
        if(index<0 || index >= size){
            throw new ArrayIndexOutOfBoundsException(index);
        }
        if(size >= capacity){
            reallocate();
        }
        for(int i=index;i<size-1;i++){ // shifting
            data[i] = data[i+1];
        }
        data[index] = anEntry;
        size++;
    }
    /**
     * Returns the index of the first occurrence of the specified element in this list, or -1 if this list does not contain the element.
     * @param target
     * @return
     */
    @Override
    public int indexOf(Object obj){
        for(int i=0;i<size();i++){
            if(obj.equals(data[i])){
                return i;
            }
        }
        return -1;
    }
    /**
     * Removes the element at the specified position in this list.If index is not valid throws ArrayIndexOutOfBoundsException.
     * @param index
     * @return
     */
    E remove(int index){
        if(index < 0 || index >= size()){
            throw new ArrayIndexOutOfBoundsException("Array Index Error!");
        }
        E old = data[index];
        for(int i=index+1;i<size;i++){
            data[i-1] = data[i];
        }
        size--;
        return old;
    }
    @SuppressWarnings("unchecked")
    private void reallocate(){
        E[] temp = (E[])new Object[capacity*2];
        for(int i=0;i<size;i++){
            temp[i] = data[i];
        }
        capacity *= 2;
        data = (E[])new Object[capacity];
        for(int i=0;i<size;i++){
            data[i] = temp[i];
        }
    }
    @SuppressWarnings("unchecked")
    @Override
    public boolean equals(Object o){
        if(o == null)
            return false;
        if(!(o instanceof kwArrayList))
            return false;
        if(size() != ((kwArrayList<E>)o).size())
        for(int i=0;i<size();i++)
            if(data[i] != ((kwArrayList<E>)o).data[i])
                return false;
        return true;
    }
}