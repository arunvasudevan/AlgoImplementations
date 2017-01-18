package com.datastruct;

import java.util.ArrayList;

public class arraytoBST {
	public TreeNode converttoBST(ArrayList<Integer> arr){
		final int start=0;
		final int end=arr.size()-1;
		
		return buildBST(arr,start,end);
	}
	
	private TreeNode buildBST(ArrayList<Integer> arr, int start, int end){	
		if (end<start)
			return null;
		final int rootIndex=(start+end)/2;
		final TreeNode n=new TreeNode(arr.get(rootIndex));
		
		n.left=buildBST(arr,start,rootIndex-1);
		n.right=buildBST(arr,rootIndex+1,end);
		
		return n;
	}

}
