import java.util.ArrayList;
import java.util.Random;
 /**
  * Test
  */
public class Test {
    public static void main(String[] args) {
        part1();
        part2();
    }
    public static void part1(){
        System.out.println("Part 1 Test Started!");
        MaxHeap<Integer> temp = new MaxHeap<>(7);
        System.out.println("Heap Created Which Has max size 7");
        System.out.println("Numbers added to Heap.1 to 7");
        for(int i=0;i<7;i++){
            temp.insert(i+1);
        }
        System.out.println("-------Heap------");
        temp.print();
        System.out.println("--------------");
        System.out.println("Search function with 2");
        System.out.println(temp.searchElement(2));
        System.out.println("Search function with 0");
        System.out.println(temp.searchElement(0));
        System.out.println("Removing Largest 2th value");
        temp.removeLargest(2);
        System.out.println("-------Heap------");
        temp.print();
        System.out.println("--------------");
    }
    public static void part2(){
    	BSTHeapTree<Integer> temp = new BSTHeapTree<>();
    	int  [] data = new int[3000];
        System.out.println("Part 2 Test Started!");
        System.out.println("Randomly 3000 number created and added to binary search tree and array.Also array is sorted!");
    	Random r = new Random();
    	for(int i=0;i<3000;i++){
        	int a=r.nextInt(5000);
    		temp.add(a);
    		data[i] = a;
    	}
    	System.out.println("Randomly 100 index is creating.And Their Occurences Will Shown Both Array and Tree");
    	sortArray(data);
    	for(int i=0;i<100;i++) {
    		int a = r.nextInt(3000);
    		System.out.println("Value: "+data[a]+"Value's occurence in tree: "+temp.find(data[a]));
    	}
    	System.out.println("Mode of BSTHeapTree:"+temp.find_mode());
    	System.out.println("Mode of array"+mode(data));
    	System.out.println("Searching not existed values in tree");
    	for(int i=0;i<10;i++) {
    		System.out.println(temp.find(i-20));
    	}
    	for(int i=0;i<100;i++) {
    		int a = r.nextInt(3000);
    		System.out.println("Value: "+data[a]+"Value's removing in tree: "+temp.remove(data[a]));
    	}
    }
    public static void sortArray(int [] data) {
    	int temp;
    	for(int i=0;i<3000;i++) {
    		for(int j=i;j<3000;j++) {
    			if(data[i] > data[j]) {
    				temp = data[i];
    				data[i] = data[j];
    				data[j] = temp;
    			}
    		}
    	}
    }
    public static int mode(int [] array) {
        int mode = array[0];
        int maxCount = 0;
        for (int i = 0; i < 300; i++) {
          int value = array[i];
          int count = 1;
          for (int j = 0; j < 3000; j++) {
              if (array[j] == value) 
                count++;
              if (count > maxCount) {
                  mode = value;
                  maxCount = count;
              }
          }
        }
        return maxCount;
      }
}