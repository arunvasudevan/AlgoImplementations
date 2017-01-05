package src.com.datastruct;

public class TestArraytoBST {

	public static void main(String[] args) {
		final arraytoBST a=new arraytoBST();
		final int[] arr={0,1,2,3,4,5};
		
		final TreeNode n=a.converttoBST(arr);
		
		final TestArraytoBST t=new TestArraytoBST();
		t.depthFirstSearch(n);
	}

	public void depthFirstSearch(TreeNode n){
		if(n==null)
			return;
		
		depthFirstSearch(n.left);
		System.out.println(n.data);
		depthFirstSearch(n.right);
	}
}
