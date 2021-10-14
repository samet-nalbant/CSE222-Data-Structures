import java.util.ListIterator;
import java.util.NoSuchElementException;

/**
 * kwLinkedList
 */
public class kwLinkedList<E> implements List<E>{

    private Node<E> tail = null;
    private Node<E> head = null;
    private int size;
    /**
     * Constructor for linked lists
     */
    public kwLinkedList(){
        size =0;
        tail = null;
        head = null;
    }
    /**
     * Insters object obj into the list at position index.
     * @param index
     * @param obj
     */
    @Override
    public void add(int index, E obj){
        listiterator(index).add(obj);
    }
    /**
     * Returns the item at positon index.
     * @param index
     * @return
     */
    @Override
    public E get(int index){
        return listiterator(index).next();
    }
    /**
     * Inserts object obj as the first element of the list.
     * @param item
     */
    public void addFirst(E item){
        add(0,item);
    }
    /**
     * Adds object obj to end of the list.
     * @param item
     */
    public void addLast(E item){
        add(size,item);
    }
    /**
     * Gets the first element in the list.Throws an NoSuchElementException if the list is empty.
     */
    public E getFirst(){return head.data;}
    /**
     * Gets the last element in the list.Throws an NoSuchElementException if the list is empty.
     */
    public E getLast(){return tail.data;}
    private class KWListIter implements ListIterator<E>{
        private Node <E> nextItem;
        private Node <E> lastItemReturned;
        private int index = 0;
        private KWListIter(int i){
            if(i < 0 || i > size){
                throw new IndexOutOfBoundsException("Invalid index "+i);
            }
            lastItemReturned = null;
            if(i == size){
                index = size;
                nextItem = null;
            }
            else{
                nextItem = head;
                for(index = 0; index < i; index++){
                    nextItem = nextItem.next;
                }
            }
        }
        private KWListIter(E obj,int flag){
            lastItemReturned = null;
            nextItem = head;
            boolean flag2 = false;
            for(index = 0; index < size; index++){
                if(nextItem.data.equals(obj)){
                    flag2 = true;
                    break;
                }
                nextItem = nextItem.next;
            }
            if(flag2 == false){
                throw new UnsupportedOperationException();
            }
        }        
        @Override
        public boolean hasNext() {
            return nextItem != null;
        }

        @Override
        public E next() {
            if(!hasNext()){
                throw new NoSuchElementException();
            }
            lastItemReturned = nextItem;
            nextItem = nextItem.next;
            index++;
            return lastItemReturned.data;
        }

        @Override
        public boolean hasPrevious() {
            return (nextItem == null && size!=0) || nextItem.prev != null;
        }

        @Override
        public E previous() {
            if(!hasPrevious()){
                throw new NoSuchElementException();
            }
            if(nextItem == null){
                nextItem = tail;
            }
            else{
                nextItem = nextItem.prev;
            }
            lastItemReturned = nextItem;
            index--;
            return lastItemReturned.data;
        }

        @Override
        public int nextIndex() {
            return index;
        }

        @Override
        public int previousIndex() {
            return index - 1;
        }

        @Override
        public void remove() {
            if(nextItem == null){
                tail = nextItem.prev;
            }
            else if(nextItem == head){
                head = head.next;
            }
            else{
                nextItem = nextItem.prev;
                nextItem.prev = nextItem.prev;
                nextItem.next = nextItem.next.next;
            }
            size--;
            index--;
            lastItemReturned = null;
        }

        @Override
        public void set(E e) {
            nextItem.data = e;
        }

        @Override
        public void add(E e) {
            if(head == null){
                head = new Node<E>(e);
                tail = head;
            }
            else if(nextItem == head){
                Node<E> newNode = new Node<E>(e);
                newNode.next = nextItem;
                nextItem.prev = newNode;
                head = newNode;
            }
            else if(nextItem == null){
                Node<E> newNode = new Node<E>(e);
                tail.next = newNode;
                newNode.prev = tail;
                tail = newNode;
            }
            else{
                Node<E> newNode = new Node<E>(e);
                newNode.prev = nextItem.prev;
                nextItem.prev.next = newNode;
                newNode.next = nextItem;
                nextItem.prev = newNode;
            }
            size++;
            index++;
            lastItemReturned = null;
        }
       
    }
    public KWListIter listiterator(int index){
        return new KWListIter(index);
    }    
    private KWListIter listiterator(E obj,int flag){
        return new KWListIter(obj,flag);
    }    

    /**
     * Returns the number of objects contained in list.
     */
    @Override
    public int size(){return size;}

    /**
     * Removes the first occurence of object obj from the list.
     * @param obj
     * @return true if the list contained object obj,otherwise returns false.
     */
    public boolean remove(E obj){
        KWListIter temp;
        try {
            temp = listiterator(obj,0);
        } catch (Exception e) {
            return false;
        }
        temp.remove();
        return true;
    }
    @Override
    public int indexOf(Object obj){
        KWListIter temp = listiterator(0);
        int i=0;
        while(temp.hasNext()){
            if(temp.next().equals(obj)){
                return i;
            }
            i++;
        }
        return -1;
    }
    private static class Node<E> {

        private E data;
        private Node<E> next;
        private Node<E> prev;
        private Node(E dataItem){
            this.data = dataItem;
            next = null;

        }
        Node(E dataItem,Node<E> next){
            this.data = dataItem;
            this.next = next;
        }
    }
    
}