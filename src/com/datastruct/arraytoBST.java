package src.com.datastruct;

public class arraytoBST {
	public TreeNode converttoBST(int[] arr){
		final int start=0;
		final int end=arr.length;
		
		return buildBST(arr,start,end);
	}
	
	private TreeNode buildBST(int[] arr, int start, int end){	
		System.out.println("Start:"+start+", End:"+end);
		if (start==end)
			return null;
		final int rootIndex=(start+end)/2;
		final TreeNode n=new TreeNode(arr[rootIndex]);
		
		n.left=buildBST(arr,start,rootIndex);
		n.right=buildBST(arr,rootIndex+1,end);
		
		return n;
	}

}
