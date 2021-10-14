/**
 * GenericArray
 */
public class GenericArray<E> {

    private E[] array;
    private int used=0;
    private int capacity=0;
    /**
     * Default constructor for GenericArray.
     */
    public GenericArray(){
        setCapacity(1);
    }
    /**
     * Constructor for GenericArray.
     * @param capacity of array.
     */
    public GenericArray(int capacity){
        setUsed(0);
        setCapacity(capacity);
    }
    /**
     * Getter function for size.
     * @return size of array.
     */
    public int getSize(){return used;}
    /**
     * Controls the spesific object whether is found or not.
     * @param o object
     * @return -1 if the object null or object isn't found.Otherwise it returns index of the object.
     */
    public int containsElement(Object o){
        if(o == null){
            return -1;
        }
        for(int i=0;i<getSize();i++){
            if(array[i].equals(o)){
                return i;
            }
        }
        return -1;
    }
    /**
     * Give an access of spesific index of array.
     * @param index
     * @return Element of the array
     * @throws ArrayIndexOutOfBoundsException
     */
    public E at(int index)throws ArrayIndexOutOfBoundsException{
        if(index < 0 || index >= getSize()){
            throw new ArrayIndexOutOfBoundsException("Array Index Error!");
        }
        return array[index];
    }
    /**
     * Add element 
     * @param element
     * @return false if element is null or already exist.Otherwise it returns true.
     */
    public boolean addElement(E element){
        if(element == null || containsElement(element) >= 0){
            return false;
        }
        if(getSize() == getCapacity()){
            setCapacity(getCapacity()*2);
        }
        array[getSize()] = element;
        setUsed(getSize()+1);

        return true;
    }
    /**
     * Remove element from array.
     * @param element
     * @return false if element is null or couldn't found.Otherwise it returns true.
     * @throws Exception
     */
    public boolean removeElement(E element)throws Exception{
        int index = containsElement(element);
        if(element == null || index == -1){
            throw new Exception("Element couldn't Found");
        }
        for(int i=0 ; i < getSize();i++){
            if(index == i){
                this.array[i] = at(getSize()-1);
                break;
            }
        }
        setUsed(getSize()-1);
        return true;
    }
    /**
     * Getter function for capacity.
     * @return capacity of array.
     */
    public int getCapacity() { return capacity; }

    /**
     * Setter function for capacity of array.
     * @param capacity of array.
     */
    private void setCapacity(int capacity){
        if(capacity < 0){capacity = 1;}
        @SuppressWarnings("unchecked")
        E[] temp = (E[])new Object[capacity];

        for(int i=0 ; i < temp.length && i < getSize() ; i++)
            temp[i] = at(i);

        if(temp.length > getSize()){
            setUsed(getSize());
        }
        else{
            setUsed(temp.length-1);
        }
        array = temp;
        this.capacity = capacity;
    }

    /**
     * Setter function for used size of array.
     * @param used number of element in array
     */
    private void setUsed(int used) { this.used = used; }
    @SuppressWarnings("unchecked")
    @Override
    public boolean equals(Object o){
        if(o == null)
            return false;
        if(!(o instanceof GenericArray))
            return false;
        if(getSize() != ((GenericArray<E>)o).getSize())
        for(int i=0;i<getSize();i++)
            if(array[i] != ((GenericArray<E>)o).array[i])
                return false;
        return true;
    }

}