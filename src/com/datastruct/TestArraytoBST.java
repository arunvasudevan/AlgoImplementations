package com.datastruct;

// Test Class for arraytoBST

public class TestArraytoBST {

	public static void main(String[] args) {
		final arraytoBST a=new arraytoBST();
		final int[] arr={1,6,10,19};
		
		final TreeNode n=a.converttoBST(arr);
		System.out.println("Sorted Array Inserted to a Tree....");
		final TestArraytoBST t=new TestArraytoBST();
		System.out.println("Printing the Tree:");
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
