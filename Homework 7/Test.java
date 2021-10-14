import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;

public class Test {

	public static void main(String[] args) {
		part1();
		part2();
		part3();
	}
	
	public static void part2() {
		System.out.println("--- Test for part2 ---");
		BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<>();
		AVLTree<Integer> avlTree = new AVLTree<>();
		binarySearchTree.add(120);
		binarySearchTree.add(47);
		binarySearchTree.add(40);
		binarySearchTree.add(25);
		binarySearchTree.add(36);
		avlTree.add(120);
		avlTree.add(47);
		avlTree.add(40);
		avlTree.add(25);
		avlTree.add(36);
		checkTree(binarySearchTree);
		checkTree(avlTree);
	}
	
	
	public static void part1() {
		System.out.println("--- Tests for part1 ---");
		NavigableSetAVL<Integer> data2 =  new NavigableSetAVL<>();
		NavigableSetSkipList<Integer> data1 = new NavigableSetSkipList<>();
		NavigableSetAVL<Integer> temp=  new NavigableSetAVL<>();
		Iterator<Integer> iter;
		System.out.println("Integers inserting to skip list");
		for(int i=0;i<10;i++) {
			data1.insert(i+1);
		}
		
		System.out.println("Existing value is trying to deleting");
		System.out.println(data1.delete(1));
		
		System.out.println("Non existing value is trying to deleting");
		System.out.println(data1.delete(1));
		
		System.out.println("Descending iterator is created and all values are iterating");
		iter = data1.descendingIterator();
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
		
		
		System.out.println("Iterator trying to access non existing value");
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
		try {
			  iter.next();
			}
			catch(Exception e) {
			 	System.out.println("Exception is catched!");
			}

		System.out.println("---------\n");
		System.out.println("Integers inserting to avl tree");
		for(int i=10;i<20;i++) {
			data2.insert(i+1);
		}
		System.out.println("Iterator is created and all values are iterating");
		iter = data2.iterator();
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
		
		System.out.println("Iterator trying to access non existing value");
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
		try {
			  iter.next();
			}
			catch(Exception e) {
			 	System.out.println("Exception is catched!");
			}
		
		System.out.println("Head set function calling and the values will shown according to value 16 and inclusive");
		temp = (NavigableSetAVL<Integer>) data2.headSet(16, true);
		iter = temp.iterator();
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
		
		
		System.out.println("tail set function calling and the values will shown according to value 18 and inclusive");
		temp = (NavigableSetAVL<Integer>) data2.tailSet(18, true);
		iter = temp.iterator();
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
		
		
		
	}
	
	public static void part3() {
		HashSet<Integer> numbers;
		BinarySearchTree<Integer> searchTree;
		RedBlackTree<Integer> redBlackTree;
		TwoThreeTree<Integer> twoThreeTree;
		SkipList<Integer> skipList;
		BTree<Integer> bTree;
		long start,end,total=0;
		System.out.println("\n\n---Tests for binary search tree---");
		for(int i=0;i<10;i++) {
			searchTree = new BinarySearchTree<>();
			numbers = createNumbers(10000);
			for(int j : numbers) {
				searchTree.add(j);
			}
			numbers = createNumbers(100);
			start = System.nanoTime();
			for(int j : numbers) {
				searchTree.add(j);
			}
			end = System.nanoTime();
			total += end-start;
		}
		System.out.print("Avarage time passed to add 100 values to binary search tree which has 10000 values for 10 times: ");
		System.out.print(total/10+ " nano seconds\n");
		total =0;
		for(int i=0;i<10;i++) {
			searchTree = new BinarySearchTree<>();
			numbers = createNumbers(20000);
			for(int j : numbers) {
				searchTree.add(j);
			}
			numbers = createNumbers(100);
			start = System.nanoTime();
			for(int j : numbers) {
				searchTree.add(j);
			}
			end = System.nanoTime();
			total += end-start;
		}
		System.out.print("Avarage time passed to add 100 values to binary search tree which has 20000 values for 10 times: ");
		System.out.print(total/10+ " nano seconds\n");
		total =0;
		for(int i=0;i<10;i++) {
			searchTree = new BinarySearchTree<>();
			numbers = createNumbers(40000);
			for(int j : numbers) {
				searchTree.add(j);
			}
			numbers = createNumbers(100);
			start = System.nanoTime();
			for(int j : numbers) {
				searchTree.add(j);
			}
			end = System.nanoTime();
			total += end-start;
		}
		System.out.print("Avarage time passed to add 100 values to binary search tree which has 40000 values for 10 times: ");
		System.out.print(total/10+ " nano seconds\n");
		total =0;
		for(int i=0;i<10;i++) {
			searchTree = new BinarySearchTree<>();
			numbers = createNumbers(80000);
			for(int j : numbers) {
				searchTree.add(j);
			}
			numbers = createNumbers(100);
			start = System.nanoTime();
			for(int j : numbers) {
				searchTree.add(j);
			}
			end = System.nanoTime();
			total += end-start;
		}
		System.out.print("Avarage time passed to add 100 values to binary search tree which has 80000 values for 10 times: ");
		System.out.print(total/10+ " nano seconds\n\n\n");	

		
		System.out.println("---Tests for red black tree---");
		total =0;
		for(int i=0;i<10;i++) {
			redBlackTree = new RedBlackTree<>();
			numbers = createNumbers(10000);
			for(int j : numbers) {
				redBlackTree.add(j);
			}
			numbers = createNumbers(100);
			start = System.nanoTime();
			for(int j : numbers) {
				redBlackTree.add(j);
			}
			end = System.nanoTime();
			total += end-start;
		}
		System.out.print("Avarage time passed to add 100 values to red black tree which has 10000 values for 10 times: ");
		System.out.print(total/10+ " nano seconds\n");
		total =0;
		for(int i=0;i<10;i++) {
			redBlackTree = new RedBlackTree<>();
			numbers = createNumbers(20000);
			for(int j : numbers) {
				redBlackTree.add(j);
			}
			numbers = createNumbers(100);
			start = System.nanoTime();
			for(int j : numbers) {
				redBlackTree.add(j);
			}
			end = System.nanoTime();
			total += end-start;
		}
		System.out.print("Avarage time passed to add 100 values to red black tree which has 20000 values for 10 times: ");
		System.out.print(total/10+ " nano seconds\n");
		total =0;
		for(int i=0;i<10;i++) {
			redBlackTree = new RedBlackTree<>();
			numbers = createNumbers(40000);
			for(int j : numbers) {
				redBlackTree.add(j);
			}
			numbers = createNumbers(100);
			start = System.nanoTime();
			for(int j : numbers) {
				redBlackTree.add(j);
			}
			end = System.nanoTime();
			total += end-start;
		}
		System.out.print("Avarage time passed to add 100 values to red black tree which has 40000 values for 10 times: ");
		System.out.print(total/10+ " nano seconds\n");
		total =0;
		for(int i=0;i<10;i++) {
			redBlackTree = new RedBlackTree<>();
			numbers = createNumbers(80000);
			for(int j : numbers) {
				redBlackTree.add(j);
			}
			numbers = createNumbers(100);
			start = System.nanoTime();
			for(int j : numbers) {
				redBlackTree.add(j);
			}
			end = System.nanoTime();
			total += end-start;
		}
		System.out.print("Avarage time passed to add 100 values to red black tree which has 80000 values for 10 times: ");
		System.out.print(total/10+ " nano seconds\n\n\n");
		
		System.out.println("---Tests for 2-3 tree---");
		total =0;
		for(int i=0;i<10;i++) {
			twoThreeTree = new TwoThreeTree<>();
			numbers = createNumbers(10000);
			for(int j : numbers) {
				twoThreeTree.add(j);
			}
			numbers = createNumbers(100);
			start = System.nanoTime();
			for(int j : numbers) {
				twoThreeTree.add(j);
			}
			end = System.nanoTime();
			total += end-start;
		}
		System.out.print("Avarage time passed to add 100 values to 2-3 tree tree which has 10000 values for 10 times: ");
		System.out.print(total/10+ " nano seconds\n");
		total =0;
		for(int i=0;i<10;i++) {
			twoThreeTree = new TwoThreeTree<>();
			numbers = createNumbers(20000);
			for(int j : numbers) {
				twoThreeTree.add(j);
			}
			numbers = createNumbers(100);
			start = System.nanoTime();
			for(int j : numbers) {
				twoThreeTree.add(j);
			}
			end = System.nanoTime();
			total += end-start;
		}
		System.out.print("Avarage time passed to add 100 values to 2-3 tree tree which has 20000 values for 10 times: ");
		System.out.print(total/10+ " nano seconds\n");
		total =0;
		for(int i=0;i<10;i++) {
			twoThreeTree = new TwoThreeTree<>();
			numbers = createNumbers(40000);
			for(int j : numbers) {
				twoThreeTree.add(j);
			}
			numbers = createNumbers(100);
			start = System.nanoTime();
			for(int j : numbers) {
				twoThreeTree.add(j);
			}
			end = System.nanoTime();
			total += end-start;
		}
		System.out.print("Avarage time passed to add 100 values to 2-3 tree tree which has 40000 values for 10 times: ");
		System.out.print(total/10+ " nano seconds\n");
		total =0;
		for(int i=0;i<10;i++) {
			twoThreeTree = new TwoThreeTree<>();
			numbers = createNumbers(80000);
			for(int j : numbers) {
				twoThreeTree.add(j);
			}
			numbers = createNumbers(100);
			start = System.nanoTime();
			for(int j : numbers) {
				twoThreeTree.add(j);
			}
			end = System.nanoTime();
			total += end-start;
		}
		System.out.print("Avarage time passed to add 100 values to 2-3 tree tree which has 80000 values for 10 times: ");
		System.out.print(total/10+ " nano seconds\n\n\n");
		
		System.out.println("---Tests for skip list---");
		total =0;
		for(int i=0;i<10;i++) {
			skipList = new SkipList<>();
			numbers = createNumbers(10000);
			for(int j : numbers) {
				skipList.add(j);
			}
			numbers = createNumbers(100);
			start = System.nanoTime();
			for(int j : numbers) {
				skipList.add(j);
			}
			end = System.nanoTime();
			total += end-start;
		}
		System.out.print("Avarage time passed to add 100 values skip list which has 10000 values for 10 times: ");
		System.out.print(total/10+ " nano seconds\n");
		total =0;
		for(int i=0;i<10;i++) {
			skipList = new SkipList<>();
			numbers = createNumbers(20000);
			for(int j : numbers) {
				skipList.add(j);
			}
			numbers = createNumbers(100);
			start = System.nanoTime();
			for(int j : numbers) {
				skipList.add(j);
			}
			end = System.nanoTime();
			total += end-start;
		}
		System.out.print("Avarage time passed to add 100 values skip list which has 20000 values for 10 times: ");
		System.out.print(total/10+ " nano seconds\n");
		total =0;
		for(int i=0;i<10;i++) {
			skipList = new SkipList<>();
			numbers = createNumbers(40000);
			for(int j : numbers) {
				skipList.add(j);
			}
			numbers = createNumbers(100);
			start = System.nanoTime();
			for(int j : numbers) {
				skipList.add(j);
			}
			end = System.nanoTime();
			total += end-start;
		}
		System.out.print("Avarage time passed to add 100 values skip list which has 40000 values for 10 times: ");
		System.out.print(total/10+ " nano seconds\n");
		total =0;
		for(int i=0;i<10;i++) {
			skipList = new SkipList<>();
			numbers = createNumbers(80000);
			for(int j : numbers) {
				skipList.add(j);
			}
			numbers = createNumbers(100);
			start = System.nanoTime();
			for(int j : numbers) {
				skipList.add(j);
			}
			end = System.nanoTime();
			total += end-start;
		}
		System.out.print("Avarage time passed to add 100 values skip list which has 80000 values for 10 times: ");
		System.out.print(total/10+ " nano seconds\n\n\n");
		
		
		System.out.println("---Tests for btree list---");
		total =0;
		for(int i=0;i<10;i++) {
			bTree = new BTree<>(5);
			numbers = createNumbers(10000);
			for(int j : numbers) {
				bTree.add(j);
			}
			numbers = createNumbers(100);
			start = System.nanoTime();
			for(int j : numbers) {
				bTree.add(j);
			}
			end = System.nanoTime();
			total += end-start;
		}
		System.out.print("Avarage time passed to add 100 values b tree  which has 10000 values for 10 times: ");
		System.out.print(total/10+ " nano seconds\n");
		
		total =0;
		for(int i=0;i<10;i++) {
			bTree = new BTree<>(5);
			numbers = createNumbers(20000);
			for(int j : numbers) {
				bTree.add(j);
			}
			numbers = createNumbers(100);
			start = System.nanoTime();
			for(int j : numbers) {
				bTree.add(j);
			}
			end = System.nanoTime();
			total += end-start;
		}
		System.out.print("Avarage time passed to add 100 values b tree which has 20000 values for 10 times: ");
		System.out.print(total/10+ " nano seconds\n");
		total =0;
		for(int i=0;i<10;i++) {
			bTree = new BTree<>(5);
			numbers = createNumbers(40000);
			for(int j : numbers) {
				bTree.add(j);
			}
			numbers = createNumbers(100);
			start = System.nanoTime();
			for(int j : numbers) {
				bTree.add(j);
			}
			end = System.nanoTime();
			total += end-start;
		}
		System.out.print("Avarage time passed to add 100 values b tree which has 40000 values for 10 times: ");
		System.out.print(total/10+ " nano seconds\n");
		total =0;
		for(int i=0;i<10;i++) {
			bTree = new BTree<>(5);
			numbers = createNumbers(80000);
			for(int j : numbers) {
				bTree.add(j);
			}
			numbers = createNumbers(100);
			start = System.nanoTime();
			for(int j : numbers) {
				bTree.add(j);
			}
			end = System.nanoTime();
			total += end-start;
		}
		System.out.print("Avarage time passed to add 100 values b tree which has 80000 values for 10 times: ");
		System.out.print(total/10+ " nano seconds\n\n\n");
	}
	private static HashSet<Integer> createNumbers(int num){
		int i=0;
		HashSet<Integer> temp = new HashSet<>();
		Random rand = new Random();
		while(i<num) {
			i = temp.size();
			temp.add(rand.nextInt());
		}
		return temp;
	}
	
	
	public static <E extends Comparable<E>> void checkTree(BinarySearchTree<E> tree) {
		System.out.println("Tree is AVL " + isAVL(tree));
	}
	
	private static <E> boolean isAVL(BinaryTree<E> tree) {
		if(tree == null) {
			return true;
		}
		if(findHeight(tree.getLeftSubtree()) - findHeight(tree.getRightSubtree()) <= 1 && isAVL(tree.getLeftSubtree()) && isAVL(tree.getRightSubtree())) {
			return true;
		}
		return false;
	}
	private static <E>  int findHeight(BinaryTree<E> tree) {
        if (tree == null) {
            return 0;
        }
        return 1 + Math.max(findHeight(tree.getLeftSubtree()),findHeight(tree.getRightSubtree()));
    }
	
	
	

}
