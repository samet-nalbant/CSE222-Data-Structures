
import java.util.NoSuchElementException;
import java.util.ArrayList;
/**
 * MaxHeap2
 */
public class MaxHeap2<E>{
    private ArrayList<Data<E>> data;
    private int size;
    private int maxSize;
    /**
     * Constructor for maxheap2.
     * @param maxSize
     */
    public MaxHeap2(int maxSize){
        this.maxSize = maxSize;
        this.size =0;
        data = new ArrayList<>();
    }
    /**
     * Returns the root of heap.
     * @return
     */
    public Data<E> getRoot(){
        return data.get(0);
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
    /**
     * Swaps two value of array.
     * @param first
     * @param second
     */
    private void swap(int first, int second){
        Data<E> temp = data.get(first);
        data.set(first, data.get(second));
        data.set(second,temp);
    }
    @SuppressWarnings("unchecked") 
    /**
     * Insert element to heap.
     * @param element
     * @return true if the opeartion is successful. Otherwise return false.
     */
    public boolean insert(E element){
        int position,index;
        index = searchElement(element);
        if(index == -1){
            data.add(new Data<E>(element));
            size++;
            position = size-1;
            while(((Comparable<E>)data.get(position).getData()).compareTo((E) data.get(getParent(position)).getData()) > 0){
                swap(position,getParent(position));
                position = getParent(position);
            }
        }
        else{
            data.get(index).incrementFreq();
        }
        return true;
    }
    /**
     * Removes data from heap and return it.
     * @return Data
     */
    public Data<E> removeData(){
    	size--;
    	return data.remove(size);
    }
    /**
     * Finds specific value in data.
     * @param element
     * @return Returns index of element.Otherwise return -1.
     */
    public int searchElement(E element){
        for(int i=0;i<size;i++){
            if(data.get(i).getData().equals(element) == true){
                return i; 
            }
        }
        return -1;
    }
    /**
     * Finds the occurence of specific item in heap.
     * @param element
     * @return
     */
    public int searchFreq(E element){
        int index = searchElement(element);
        if(index == -1){
            return -1;
        }
        return data.get(index).getFreq();
    }
    /**
     * Removes the root of the heap.
     * @return removed item.
     */
    @SuppressWarnings("unchecked") 
    public E remove(){
        int maxChild;
        E temp = (E)data.get(0).getData();
        data.set(0, data.get(size-1));
        size--;
        int position =0;
        while(true){
            if(getLeftChild(position) > size){ //
                break;
            }
            maxChild = getLeftChild(position);
            if(getRightChild(position) < size && ((Comparable<E>)data.get(getRightChild(position)).getData()).compareTo((E) data.get(getLeftChild(position)).getData()) > 0){
                maxChild = getRightChild(position);
            }
            if(((Comparable<E>)data.get(position).getData()).compareTo((E) data.get(maxChild).getData()) < 0){
                swap(position, maxChild);
                position = maxChild;
            }
            else{
                break;
            }
        }
        return temp;
    }
    public void print(){
        for(int i=0;i<size;i++){
            System.out.println(data.get(i).getData()+","+data.get(i).getFreq());
        }
    }
    public int getSize(){return size;}
    /**
     * Removes specific item from the heap.
     * @param item
     * @return
     */
    @SuppressWarnings("unchecked")
    public int removeItem(E item){
        int index = searchElement(item);
        int maxChild;
        if(index == -1){
            return -1;
        }
        else{
            if(data.get(index).getFreq() > 1){
                data.get(index).decrementFreq();
                return data.get(index).getFreq();
            }
            else{
                swap(index, size-1);
                size--;
            }
        }
        return 0;
    }
    /**
     * Finds the most occured item's number.
     * @return occurence.
     */
    public int findLargestFreq(){
        int max = data.get(0).getFreq();
        for(int i=1;i<getSize();i++){
            if(data.get(i).getFreq() > max){
                max = data.get(i).getFreq();
            }
        }
        return max;
    }
}