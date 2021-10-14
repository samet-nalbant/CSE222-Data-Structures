
public class Test {

	public static void main(String [] args) {
		test1();
		test2();
	}
	
	public static void test1() {
		System.out.println("------Part 1 Test Started!------");
		System.out.println("Hash map which contains progrraming languages as a key and their developing dates as a value is creating!");
		MyHashMap<String, Integer> languages = new MyHashMap<String, Integer>();
		languages.put("C", 1972);
		languages.put("C++", 1983);
		languages.put("JAVA", 1995);
		languages.put("PYTHON", 1990);
		languages.put("RUBY", 1995);
		languages.put("KOTLIN", 2011);
		System.out.println("-----Keys-----");
		for (String i : languages.keySet()){
			System.out.println(i);
		}
		System.out.println("---------------");
		System.out.println("Iterator is creating from C++!");
		Iterator<String> temp = languages.iterator("C++");
		System.out.println("Next values of C++ are printing using Iterator's methods.");
		while(temp.hasNext()) {
			System.out.println(temp.next());
		}
		temp = languages.iterator("C++");
		System.out.println("---------------");
		System.out.println("Prev values are printing using Iterator's methods.");
		while(temp.hasPrev()) {
			System.out.println(temp.prev());
		}
		System.out.println("---------------");
		System.out.println("Iterator is creating from not existed key.");
		temp = languages.iterator("C#");
		System.out.println("Next values of Iterator are printing using Iterator's methods.");
		while(temp.hasNext()) {
			System.out.println(temp.next());
		}
		System.out.println("---------------");
	}
	public static void test2() {
		System.out.println("------Part 2 Test Started!------");
		HashTableChain<Integer, Integer> data1 = new HashTableChain<Integer, Integer>();
		HashTableChainTreeSet<Integer, Integer> data2 = new HashTableChainTreeSet<Integer, Integer>();
		CoalescedHashMap<Integer, Integer> data3 = new CoalescedHashMap<Integer, Integer>();
		long start;
		long end;
		System.out.println("---------Small Data--------");
		start = System.nanoTime();
		for(int i=0;i<10;i++) {
			data1.put(i,i);
		}
		end =System.nanoTime();
		System.out.println("Put time for HashTableChain with different values: "+ (end-start));
		start = System.nanoTime();
		for(int i=0;i<10;i++) {
			data2.put(i,i);
		}
		end =System.nanoTime();
		System.out.println("Put time for HashTableChainTreeSet with different values: "+ (end-start));
		start = System.nanoTime();
		for(int i=0;i<10;i++) {
			data3.put(i,i);
		}
		end =System.nanoTime();
		System.out.println("Put time for CoalescedHashMap with different values: "+ (end-start));
		System.out.println("---------------------");
		start = System.nanoTime();
		for(int i=0;i<10;i++) {
			data1.put(2,2);
		}
		end =System.nanoTime();
		System.out.println("Put time for HashTableChain with same values: "+ (end-start));
		start = System.nanoTime();
		for(int i=0;i<10;i++) {
			data2.put(2,2);
		}
		end =System.nanoTime();
		System.out.println("Put time for HashTableChainTreeSet with same values: "+ (end-start));
		for(int i=0;i<10;i++) {
			data3.put(2,2);
		}
		end =System.nanoTime();
		System.out.println("Put time for CoalescedHashMap with same values: "+ (end-start));
		System.out.println("---------------------");
		start = System.nanoTime();
		for(int i=0;i<10;i++) {
			data1.get(i);
		}
		end = System.nanoTime();
		System.out.println("Get time for HashTableChain with different values: "+(end-start));
		start = System.nanoTime();
		for(int i=0;i<10;i++) {
			data2.get(i);
		}
		end = System.nanoTime();
		System.out.println("Get time for HashTableChainTreeSet with different values: "+(end-start));
		start = System.nanoTime();
		for(int i=0;i<10;i++) {
			data3.get(i);
		}
		end = System.nanoTime();
		System.out.println("Get time for CoalescedHashMap with different values: "+(end-start));
		System.out.println("---------------------");
		start = System.nanoTime();
		for(int i=0;i<10;i++) {
			data1.get(99);
		}
		end = System.nanoTime();
		System.out.println("Get time for HashTableChain with non existing values: "+(end-start));		
		start = System.nanoTime();
		for(int i=0;i<10;i++) {
			data2.get(99);
		}
		end = System.nanoTime();
		System.out.println("Get time for HashTableChainTreeSet with non existing values: "+(end-start));	
		start = System.nanoTime();
		for(int i=0;i<10;i++) {
			data3.get(99);
		}
		end = System.nanoTime();
		System.out.println("Get time for CoalescedHashMap with non existing values: "+(end-start));	
		System.out.println("---------------------");
		start = System.nanoTime();
		for(int i=0;i<10;i++) {
			data1.remove(i);
		}
		end = System.nanoTime();
		System.out.println("Remove time for HashTableChain with existing values: "+(end-start));	
		start = System.nanoTime();
		for(int i=0;i<10;i++) {
			data2.remove(i);
		}
		end = System.nanoTime();
		System.out.println("Remove time for HashTableChainTreeSet with existing values: "+(end-start));	
		start = System.nanoTime();
		for(int i=0;i<10;i++) {
			data3.remove(i);
		}
		end = System.nanoTime();
		System.out.println("Remove time for CoalescedHashMap with existing values: "+(end-start));	
		System.out.println("---------------------");
		start = System.nanoTime();
		for(int i=0;i<10;i++) {
			data1.remove(555);
		}
		end = System.nanoTime();
		System.out.println("Remove time for HashTableChain with non existing values: "+(end-start));	
		start = System.nanoTime();
		for(int i=0;i<10;i++) {
			data2.remove(555);
		}
		end = System.nanoTime();
		System.out.println("Remove time for HashTableChainTreeSet with non existing values: "+(end-start));	
		start = System.nanoTime();
		for(int i=0;i<10;i++) {
			data3.remove(555);
		}
		end = System.nanoTime();
		System.out.println("Remove time for CoalescedHashMap with non existing values: "+(end-start));	
		System.out.println("------------------------------------------");
		System.out.println("\n\n");
		System.out.println("---------Medium Data-------");
		start = System.nanoTime();
		for(int i=0;i<100;i++) {
			data1.put(i,i);
		}
		end =System.nanoTime();
		System.out.println("Put time for HashTableChain with different values: "+ (end-start));
		start = System.nanoTime();
		for(int i=0;i<100;i++) {
			data2.put(i,i);
		}
		end =System.nanoTime();
		System.out.println("Put time for HashTableChainTreeSet with different values: "+ (end-start));
		start = System.nanoTime();
		for(int i=0;i<100;i++) {
			data3.put(i,i);
		}
		end =System.nanoTime();
		System.out.println("Put time for CoalescedHashMap with different values: "+ (end-start));
		start = System.nanoTime();
		for(int i=0;i<100;i++) {
			data1.put(2,2);
		}
		System.out.println("---------------------");
		end =System.nanoTime();
		System.out.println("Put time for HashTableChain with same values: "+ (end-start));
		start = System.nanoTime();
		for(int i=0;i<100;i++) {
			data2.put(2,2);
		}
		end =System.nanoTime();
		System.out.println("Put time for HashTableChainTreeSet with same values: "+ (end-start));
		for(int i=0;i<100;i++) {
			data3.put(2,2);
		}
		end =System.nanoTime();
		System.out.println("Put time for CoalescedHashMap with same values: "+ (end-start));
		System.out.println("---------------------");
		start = System.nanoTime();
		for(int i=0;i<100;i++) {
			data1.get(i);
		}
		end = System.nanoTime();
		System.out.println("Get time for HashTableChain with different values: "+(end-start));
		start = System.nanoTime();
		for(int i=0;i<100;i++) {
			data2.get(i);
		}
		end = System.nanoTime();
		System.out.println("Get time for HashTableChainTreeSet with different values: "+(end-start));
		start = System.nanoTime();
		for(int i=0;i<100;i++) {
			data3.get(i);
		}
		end = System.nanoTime();
		System.out.println("Get time for CoalescedHashMap with different values: "+(end-start));
		System.out.println("---------------------");
		start = System.nanoTime();
		for(int i=0;i<100;i++) {
			data1.get(99);
		}
		end = System.nanoTime();
		System.out.println("Get time for HashTableChain with non existing values: "+(end-start));		
		start = System.nanoTime();
		for(int i=0;i<100;i++) {
			data2.get(99);
		}
		end = System.nanoTime();
		System.out.println("Get time for HashTableChainTreeSet with non existing values: "+(end-start));	
		start = System.nanoTime();
		for(int i=0;i<100;i++) {
			data3.get(99);
		}
		end = System.nanoTime();
		System.out.println("Get time for CoalescedHashMap with non existing values: "+(end-start));	
		System.out.println("---------------------");
		start = System.nanoTime();
		for(int i=0;i<100;i++) {
			data1.remove(i);
		}
		end = System.nanoTime();
		System.out.println("Remove time for HashTableChain with existing values: "+(end-start));	
		start = System.nanoTime();
		for(int i=0;i<100;i++) {
			data2.remove(i);
		}
		end = System.nanoTime();
		System.out.println("Remove time for HashTableChainTreeSet with existing values: "+(end-start));	
		start = System.nanoTime();
		for(int i=0;i<100;i++) {
			data3.remove(i);
		}
		end = System.nanoTime();
		System.out.println("Remove time for CoalescedHashMap with existing values: "+(end-start));	
		System.out.println("---------------------");
		start = System.nanoTime();
		for(int i=0;i<100;i++) {
			data1.remove(555);
		}
		end = System.nanoTime();
		System.out.println("Remove time for HashTableChain with non existing values: "+(end-start));	
		start = System.nanoTime();
		for(int i=0;i<100;i++) {
			data2.remove(555);
		}
		end = System.nanoTime();
		System.out.println("Remove time for HashTableChainTreeSet with non existing values: "+(end-start));	
		start = System.nanoTime();
		for(int i=0;i<100;i++) {
			data3.remove(555);
		}
		end = System.nanoTime();
		System.out.println("Remove time for CoalescedHashMap with non existing values: "+(end-start));	
		System.out.println("\n\n\n");
		System.out.println("---------Large Data--------");
		start = System.nanoTime();
		for(int i=0;i<1000;i++) {
			data1.put(i,i);
		}
		end =System.nanoTime();
		System.out.println("Put time for HashTableChain with different values: "+ (end-start));
		start = System.nanoTime();
		for(int i=0;i<1000;i++) {
			data2.put(i,i);
		}
		end =System.nanoTime();
		System.out.println("Put time for HashTableChainTreeSet with different values: "+ (end-start));
		start = System.nanoTime();
		for(int i=0;i<1000;i++) {
			data3.put(i,i);
		}
		end =System.nanoTime();
		System.out.println("Put time for CoalescedHashMap with different values: "+ (end-start));
		start = System.nanoTime();
		for(int i=0;i<1000;i++) {
			data1.put(2,2);
		}
		System.out.println("---------------------");
		end =System.nanoTime();
		System.out.println("Put time for HashTableChain with same values: "+ (end-start));
		start = System.nanoTime();
		for(int i=0;i<1000;i++) {
			data2.put(2,2);
		}
		end =System.nanoTime();
		System.out.println("Put time for HashTableChainTreeSet with same values: "+ (end-start));
		for(int i=0;i<1000;i++) {
			data3.put(2,2);
		}
		end =System.nanoTime();
		System.out.println("Put time for CoalescedHashMap with same values: "+ (end-start));
		System.out.println("---------------------");
		start = System.nanoTime();
		for(int i=0;i<1000;i++) {
			data1.get(i);
		}
		end = System.nanoTime();
		System.out.println("Get time for HashTableChain with different values: "+(end-start));
		start = System.nanoTime();
		for(int i=0;i<1000;i++) {
			data2.get(i);
		}
		end = System.nanoTime();
		System.out.println("Get time for HashTableChainTreeSet with different values: "+(end-start));
		start = System.nanoTime();
		for(int i=0;i<1000;i++) {
			data3.get(i);
		}
		end = System.nanoTime();
		System.out.println("Get time for CoalescedHashMap with different values: "+(end-start));
		System.out.println("---------------------");
		start = System.nanoTime();
		for(int i=0;i<1000;i++) {
			data1.get(99);
		}
		end = System.nanoTime();
		System.out.println("Get time for HashTableChain with non existing values: "+(end-start));		
		start = System.nanoTime();
		for(int i=0;i<1000;i++) {
			data2.get(99);
		}
		end = System.nanoTime();
		System.out.println("Get time for HashTableChainTreeSet with non existing values: "+(end-start));	
		start = System.nanoTime();
		for(int i=0;i<1000;i++) {
			data3.get(99);
		}
		end = System.nanoTime();
		System.out.println("Get time for CoalescedHashMap with non existing values: "+(end-start));	
		System.out.println("---------------------");
		start = System.nanoTime();
		for(int i=0;i<1000;i++) {
			data1.remove(i);
		}
		end = System.nanoTime();
		System.out.println("Remove time for HashTableChain with existing values: "+(end-start));	
		start = System.nanoTime();
		for(int i=0;i<1000;i++) {
			data2.remove(i);
		}
		end = System.nanoTime();
		System.out.println("Remove time for HashTableChainTreeSet with existing values: "+(end-start));	
		start = System.nanoTime();
		for(int i=0;i<1000;i++) {
			data3.remove(i);
		}
		end = System.nanoTime();
		System.out.println("Remove time for CoalescedHashMap with existing values: "+(end-start));	
		System.out.println("---------------------");
		start = System.nanoTime();
		for(int i=0;i<1000;i++) {
			data1.remove(555);
		}
		end = System.nanoTime();
		System.out.println("Remove time for HashTableChain with non existing values: "+(end-start));	
		start = System.nanoTime();
		for(int i=0;i<1000;i++) {
			data2.remove(555);
		}
		end = System.nanoTime();
		System.out.println("Remove time for HashTableChainTreeSet with non existing values: "+(end-start));	
		start = System.nanoTime();
		for(int i=0;i<1000;i++) {
			data3.remove(555);
		}
		end = System.nanoTime();
		System.out.println("Remove time for CoalescedHashMap with non existing values: "+(end-start));	
		System.out.println("---------------------");
	}

}
