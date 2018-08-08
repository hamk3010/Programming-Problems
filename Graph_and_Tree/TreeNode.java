
public class TreeNode {
	
	public int val = 0;
	TreeNode left = null;
	TreeNode right = null;
	
	TreeNode(int val){
		this.val = val;
	}
	public TreeNode getLeft(){
		return this.left;
	}
	public TreeNode getRight(){
		return this.right;
	}
	public void setLeft(TreeNode left){
		this.left = left;
	}
	public void setRight(TreeNode right){
		this.right = right;
	}
	
	
	

}
