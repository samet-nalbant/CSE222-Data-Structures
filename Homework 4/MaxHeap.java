
import java.util.NoSuchElementException;

/**
 * MaxHeap
 */
public class MaxHeap<E>{
    private E[] data;
    private int size;
    private int maxSize;
    private E root;
    @SuppressWarnings("unchecked") 
    /**
     * Constructor for MaxHeap
     */
    public MaxHeap(int maxSize){
        this.maxSize = maxSize;
        this.size =0;
        data = (E[])new Object[maxSize+1];

    }
    private int getParent(int position){
        return (position-1)/2;
    }
    private int getLeftChild(int position){
        return 2*position+1;
    }
    private int getRightChild(int position){
        return 2*position+2;
    }
    private void swap(int first, int second){
        E temp = data[first];
        data[first] = data[second];
        data[second] = temp;
    }
    @SuppressWarnings("unchecked") 
    /**
     * Insert element to heap.
     * @param element
     * @return true if the opeartion is successful. Otherwise return false.
     */
    public boolean insert(E element){
        int position;
        if(size >= maxSize){
            return false;
        }
        if(searchElement(element) == true){
            return false;
        }
        data[size] = element;
        size++;
        position = size-1;
        while(((Comparable<E>)data[position]).compareTo(data[getParent(position)]) > 0){
            swap(position,getParent(position));
            position = getParent(position);
        }

        return true;
    }
    /**
     * Finds specific value in data.
     * @param element
     * @return Returns true if it is found.Otherwise return false.
     */
    public boolean searchElement(E element){
        for(int i=0;i<size;i++){
            if(element == data[i]){
                return true;
            }
        }
        return false;
    }
    @SuppressWarnings("unchecked") 
    /**
     * Removes data from heap and return it.
     * @return Data
     */     
    public E remove(){
        int maxChild;
        E temp = data[0];
        data[0] = data[size-1];
        size--;
        int position =0;
        while(true){
            if(getLeftChild(position) > size){ //
                break;
            }
            maxChild = getLeftChild(position);
            if(getRightChild(position) < size && ((Comparable<E>)data[getRightChild(position)]).compareTo(data[getLeftChild(position)]) > 0){
                maxChild = getRightChild(position);
            }
            if(((Comparable<E>)data[position]).compareTo(data[maxChild]) < 0){
                swap(position, maxChild);
                position = maxChild;
            }
            else{
                break;
            }
            
        }
        return temp;
    }
    /**
     * Merges one heap to another.
     */
    public void merge(MaxHeap<E> other){
        maxSize =other.getSize()+maxSize;
        Iter temp = other.iterator(0);
        while(temp.hasNext()){
            this.insert(temp.next());
        }
    }
    /**
     * Prints elements in heap.
     */
    public void print(){
        for(int i=0;i<size;i++){
            System.out.println(data[i]);
        }
    }
    /**
     * Returns size of the heap.
     */
    public int getSize(){return size;}
    private class Iter{
        private E nextItem;
        private E lastItemReturned;
        private int index = 0;
        private Iter(int i){
            if(i < 0 || i > size){
                throw new IndexOutOfBoundsException("Invalid index "+i);
            }            
            lastItemReturned = null;
            if(i == size){
                index = size;
                nextItem = null;
            }
            else{
                nextItem = data[index];
            }
        }
        public boolean hasNext(){
            return index < size;
        }
        public E next(){
            if(!hasNext()){
                throw new NoSuchElementException();
            }
            lastItemReturned = nextItem;
            nextItem = data[index++];
            return lastItemReturned;
        }
        public void set(E item){

        }
    }
    /**
     * Returns Iterator.
     */
    public Iter iterator(int index){
        return new Iter(index);
    } 
    @SuppressWarnings("unchecked")
    /**
     * Removes largest i.th element from heap.
     */
    public E removeLargest(int value){
        if(value <= 0 || value > size){
            throw new NoSuchElementException();
        }
        sortArray();
        swap(size-1,value-1);
        E temp = data[size-1];
        size--;
        MaxHeap<E> temp2 = new MaxHeap<>(size);
        for(int i=0;i<size;i++){
            temp2.insert(data[i]);
        }
        this.data = temp2.data;
        return temp;
    }
    @SuppressWarnings("unchecked")
    private void sortArray(){
        for(int i=0;i<size;i++){
            for(int j=i+1;j<size;j++){
                if(((Comparable<E>)data[i]).compareTo(data[j]) <0){
                    swap(i,j);
                }
            }
        }
    }
}