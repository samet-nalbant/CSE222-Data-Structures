/**
 * BSTHeapTree
 */
public class BSTHeapTree<E> implements SearchTree<E>{

    private Node<E> root;
    private int returnFreq =0;
    private int mod = 0;
    BSTHeapTree(){
        root = null;
    }
    
     /**
     * Inserts item where it belongs in the tree. Returns occurence of item if is inserted; return -1 if it can not be done.
     * @param item
     * @return Returns occurrence of item if is inserted
     */
    @Override
    public int add(E item){
        root = add(root,item);
        return returnFreq;
    }
    /**
     * Remove specific item from tree.
     * @param item
     * @return returns the number of occurrences of the item after removal
     */
    @Override
    public int remove(E item){
        delete(root,item);
        return returnFreq;
        
    }
    /**
     * Finds occurence of item.
     * @param item
     * @return occurence of item. If item isn't belong to tree it returns -1.
     */
    @Override
    public int find(E item){
        return findItem(root,item);
    }
    public void print(){
        print(root);
    }
    /**
     * Finds the most occurence of item in tree.
     * @return occurence
     */
    @Override
    public int find_mode(){
        findMode(root);
        return mod;
    }
    private static class Node<E>{
        private MaxHeap2<E> data;
        private Node<E> left;
        private Node<E> right;
        public Node() {
            this.data = new MaxHeap2<E>(6);
            left = null;
            right = null;           
        }
        public int getSize(){
            return data.getSize();
        }
    }
    @SuppressWarnings("unchecked")
    private Node<E> add(Node<E> localRoot, E item) {
        if(localRoot == null) {
            localRoot = new Node<E>();
        }
        if(localRoot.data.searchFreq(item) != -1){
            localRoot.data.insert(item);
            return localRoot;
        }
        if(localRoot.getSize() < 7){
            localRoot.data.insert(item);
        }
        else{
            if(((Comparable<E>)localRoot.data.getRoot().getData()).compareTo(item) < 0){
                localRoot.right = add(localRoot.right,item);
            }
            else if(((Comparable<E>)localRoot.data.getRoot().getData()).compareTo(item) > 0){
                localRoot.left = add(localRoot.left,item);
            }            
        }
        return localRoot;
    }

    @SuppressWarnings("unchecked")
    private int findItem(Node<E> localRoot, E target) {
        if(localRoot == null){
            return -1;
        }
        int freq = localRoot.data.searchFreq(target);
        if(freq != -1){
            return freq;
        }
        int compResult = ((Comparable<E>)target).compareTo(localRoot.data.getRoot().getData());
        if(compResult < 0){
            return findItem(localRoot.left, target);
        }
        else{
            return findItem(localRoot.right, target);
        }
    }
    private void print(Node<E> localRoot){
        if(localRoot == null){
            return;
        }
        localRoot.data.print();
        System.out.println("\n\n\n\n");
        print(localRoot.left);
        print(localRoot.right);
    }
    private void findMode(Node<E> localRoot){
        if(localRoot == null){
            return;
        }
        int temp = localRoot.data.findLargestFreq();
        if(temp > mod) {
        	mod = temp;
        }
        findMode(localRoot.left);
        findMode(localRoot.right);
    }
    @SuppressWarnings("unchecked")
    private void delete(Node<E> localRoot, E item){
        if(localRoot == null){
            returnFreq = -1;
            return;
        }
        int flag = localRoot.data.removeItem(item);
        if(flag != -1) {
        	Node<E> temp = localRoot;
        	localRoot = null;
            returnFreq = flag;
            addAll(temp);
        }
        else{
        	int compResult = ((Comparable<E>)item).compareTo(localRoot.data.getRoot().getData());
            if(compResult < 0){
            	delete(localRoot.left, item);
            }
            else{
                delete(localRoot.right, item);
            }
        }
    }
    private void addAll(Node<E> localRoot) {
    	Data<E> temp;
    	if(localRoot == null) {
    		return;
    	}
    	int size = localRoot.getSize();
    	for(int i=0;i<size;i++) {
    		temp = localRoot.data.removeData();
    		for(int j=0;j<temp.getFreq();j++) {
        		add(temp.getData());
    		}
    	}
    	addAll(localRoot.left);
    	addAll(localRoot.right);
    }
}