
/**
 * hybridList
 */

public class hybridList<E> implements List<E>{
    static final int MAX_NUMBER = 5;
    private kwLinkedList<kwArrayList<E>> data;
    private int size;
    /**
     * Constructer for the hybridList with initial capacity
     *
     */
    public hybridList(){
        data = new kwLinkedList<kwArrayList<E>>();
        size = 0;
    }
    /**Returns the item at positon index.If index is not valid throws ArrayIndexOutOfBoundsException.
    * @param index
    * @return object
    */
    @Override
    public E get(int index){
        return data.get(index/MAX_NUMBER).get(index%MAX_NUMBER);
    }
    /* Replaces the element at the specified position in this list with the specified element.If index is not valid throws ArrayIndexOutOfBoundsException.
    * @param index
    * @param anEntry
    * @return
    */
    public E set(int index, E anEntry){
        if(index < 0 || index >= size){
            throw new ArrayIndexOutOfBoundsException(index);
        }
        E temp = data.get(index/MAX_NUMBER).get(index%MAX_NUMBER);
        data.get(index/MAX_NUMBER).set(index%MAX_NUMBER,anEntry);
        return temp;
    }
    /**
     * Returns the number of elements in this list.
     * @return integer
     */
    @Override
    public int size(){
        return size;
    }
    /**
     * Appends the specified element to the end of this list.
     */
    public void add(E anEntry){
        if(size % MAX_NUMBER == 0){
            data.addLast(new kwArrayList<E>());
        }
        data.get(size/ MAX_NUMBER).add(anEntry);
        size++;
    }
    /**
     * Removes the element at the specified position in this list.If index is not valid throws ArrayIndexOutOfBoundsException.
     * @param index
     * @return
     */
    public E remove(int index){
        if(index < 0 || index >= size){
            throw new ArrayIndexOutOfBoundsException(index);
        }
        for(int i=index;i<size-1;i++){
            if(i%MAX_NUMBER == MAX_NUMBER-1){
                data.get(i/MAX_NUMBER).set((i)%MAX_NUMBER, data.get((i+1)/MAX_NUMBER).get((i+1)%MAX_NUMBER));
            }
            else{
                data.get(i/MAX_NUMBER).set(i%MAX_NUMBER, data.get((i)/MAX_NUMBER).get((i+1)%MAX_NUMBER));
            }
        }
        size--;
        return null;
    }
    /**
     * Returns the index of the first occurrence of the specified element in this list, or -1 if this list does not contain the element.
     * @param target
     * @return
     */
    @Override
    public int indexOf(Object obj){
        for(int i=0;i<size;i++){
            if(data.get(i/ MAX_NUMBER).get(i % MAX_NUMBER).equals(obj)){
                return i;
            }
        }
        return -1;
    }
    /**
     * Inserts the specified element at the specified position in this list. If index is not valid throws ArrayIndexOutOfBoundsException.
     * @param index
     * @param anEntry
     */
    @Override
    public void add(int index, E anEntry){
        if(index < 0 || index >= size){
            throw new ArrayIndexOutOfBoundsException(index);
        }
        if(size % MAX_NUMBER == 0){
            data.addLast(new kwArrayList<E>());
        }
        add(anEntry);
        for(int i=size-2;i >= index;i--){
            if(i%MAX_NUMBER == 4){
                data.get((i+1)/MAX_NUMBER).set(0,data.get((i)/MAX_NUMBER).get((i)%MAX_NUMBER));
            }
            else{
                data.get(i/MAX_NUMBER).set((i+1)%MAX_NUMBER,data.get(i/MAX_NUMBER).get((i)%MAX_NUMBER));
            }
        }
        data.get(index/MAX_NUMBER).set(index%MAX_NUMBER, anEntry);
    }
}
