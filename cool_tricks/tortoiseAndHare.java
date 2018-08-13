package cool_tricks;

public class tortoiseAndHare {
	public static boolean hasCycle(LinkedNode n){
		LinkedNode slow = n;
		LinkedNode fast = n;

		while(fast != null){
			slow = slow.getNext(slow);
			fast = fast.getNext(fast.getNext(fast));
			if(slow == fast)
				return true;
		}
		return false;		
	}
	
	public static void main(String[] args){
		LinkedNode n = new LinkedNode(0);
		LinkedNode temp = n;
		for(int i = 1; i<15; i++){
			n.next = new LinkedNode(i);
			n = n.getNext(n);
		}
		n.setNext(temp); // we are creating a cycle here;
		
		System.out.println("First test has a cycle? " + hasCycle(temp)); //this should be true if our algorithm works
		
		LinkedNode m = new LinkedNode(5);
		temp = m;
		for(int i = 6; i<15; i++){
			m.setNext(new LinkedNode(i));
			m = m.getNext(m);
		}
		System.out.println("First test has a cycle? " + hasCycle(temp)); //this should be False if our algorithm works
		
	}
}
class LinkedNode{
	
	int data = 0;
	LinkedNode next = null;
	public LinkedNode(int n){
		this.data = n;
	}
	
	public LinkedNode getNext(LinkedNode n){
		if(n!=null)
			return n.next;
		return null;
	}
	
	public void setNext(LinkedNode n){
		this.next = n;
	}
	
}
