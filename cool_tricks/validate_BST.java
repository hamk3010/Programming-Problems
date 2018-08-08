package cool_tricks;



public class validate_BST {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		myNode root1 = new myNode(20, new myNode(10, null, new myNode(25, null, null) ), new myNode(30, null, null)  );
		myNode root2 = new myNode(4,new myNode(2, new myNode(1, null, null), new myNode(3, null, null) ), new myNode(6, new myNode(5, null, null), new myNode(7, null, null) ) );
		
		System.out.println(checkBST(root1));
		System.out.println(checkBST(root2));
	
	}

	
	// This result runs in O(n) time and O(1) space complexity. 
	static boolean checkBST(myNode n){
		return checkBST(n, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	
	static boolean checkBST(myNode n, Integer min, Integer max){
		
		if(n==null)
			return true;
		
		if((n.val<=min) || (n.val> max) ){
			return false;
		}
		
		if(!checkBST(n.left, min, n.val) || !checkBST(n.right, n.val, max) )
			return false;
		
		return true;
	}

	
}

class myNode {
	
	public int val = 0;
	myNode left = null;
	myNode right = null;
	
	myNode(int val, myNode left, myNode right){
		this.val = val;
		this.left = left;
		this.right = right;
	}
	public myNode getLeft(){
		return this.left;
	}
	public myNode getRight(){
		return this.right;
	}
	public void setLeft(myNode left){
		this.left = left;
	}
	public void setRight(myNode right){
		this.right = right;
	}
	
	
}