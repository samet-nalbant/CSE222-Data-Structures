/**
 * Data
 */

public class Data<E>{
    private E data;
    private int freq;
    Data(){
        data = null;
        freq = 0;
    }
    Data(E value){
        data = value;
        freq = 1;
    }
    /**
     * Setter for data class.
     * @param element
     */
    public void setData(E element){
        this.data = element;
        incrementFreq();
    }
    /**
     * Getter for data class.
     * @return
     */
    public E getData(){
        return this.data;   
    }
    /**
     * Increments occurence.
     */
    public void incrementFreq(){
        freq++;
    }
    /**
     * Decrements occurence.
     * @return
     */
    public boolean decrementFreq(){
        if(freq == 0){
            return false;
        }
        freq--;
        return true;
    }
    /**
     * Returns occurence.
     * @return
     */
    public int getFreq(){
        return freq;
    }
}