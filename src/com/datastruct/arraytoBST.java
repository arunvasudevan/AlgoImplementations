package com.datastruct;

/* Problem Statement:  Given a sorted (increasing order) array with unique elements create a BST with minimal height */

public class arraytoBST {
	public TreeNode converttoBST(int[] arr){
		return buildBST(arr,0,arr.length-1);
	}
	
	private TreeNode buildBST(int[] arr, int start, int end){	
		if(end<start)
			return null;
		final int rootIndex=(start+end)/2;
		final TreeNode n=new TreeNode(arr[rootIndex]);
		
		n.left=buildBST(arr,start,rootIndex-1);
		n.right=buildBST(arr,rootIndex+1,end);
		
		return n;
	}

}
