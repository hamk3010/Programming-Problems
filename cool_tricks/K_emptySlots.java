package cool_tricks;


import java.util.TreeSet;

public class K_emptySlots {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1,5,6,8,4,7,9,2};
		int k = 4;
		System.out.println(kEmptySlots(arr, k));

	}

	
	
	public static int kEmptySlots(int[] flowers, int k){
		TreeSet<Integer> treeSet = new TreeSet<>();
		
		for(int i = 0; i<flowers.length; i++){
			
			int current = flowers[i];
			//find the value strictly greater than current yet
			Integer next = treeSet.higher(current);
			if (next != null && next - current == k + 1) {
				return i + 1;
			}
			//find the value strictly less than current yet
			Integer pre = treeSet.lower(current);
			if (pre != null && current - pre == k + 1) {
				return i + 1;
			}
			//if the value is not found than just add the current to the treeSet
			treeSet.add(current);
	}
		//if no  such value is  found than return -1;
		return -1;
		
	}
	
	
	
	
}
//
//class MinQueue<E extends Comparable<E>> extends ArrayDeque<E>{
//	
//	Deque<E> mins;
//	 public MinQueue() {
//		 mins = new ArrayDeque<E>();
//	 }
//	 
//	 @Override
//	 public void addLast(E x){
//		 super.addLast(x);
//		 while(mins.peekLast() != null && x.compareTo(mins.peekLast() ) < 0){
//			 //returns the tail of the deque;
//			 mins.pollLast();
//		 }
//		 mins.addLast(x);
//	 }
//	 
//	 @Override
//	 public E pollFirst(){
//		 E x = super.pollFirst();
//		 if(x== mins.peekFirst() )
//			 mins.pollFirst();
//		 return x;
//	 }
//	 
//	 public E min(){
//		 return mins.peekFirst();
//	 }
//	
//	
//	
//	
	
//}
