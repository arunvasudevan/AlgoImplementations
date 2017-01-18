package com.ctci.chapter4;

import com.datastruct.TreeNode;

// Problem Statement: Check if a tree is balanced.
// For the purposes of the problem a Balanced tree is one in which the 
// the heights of the two subtrees of any node never differ by more than one. 

public class checkBalancedTree {
	
	public boolean checkBalanced(TreeNode root){
		if(root==null)
			return false;
		return treeHeight(root) != Integer.MIN_VALUE;
	}
	
	int treeHeight(TreeNode root){
		if(root==null)
			return 0;
		
		int result=0,left=0,right=0;
		
		left=treeHeight(root.left);
		if(left==Integer.MIN_VALUE) return Integer.MIN_VALUE;
		
		right=treeHeight(root.right);
		if(right == Integer.MIN_VALUE) return Integer.MIN_VALUE;
		
		result=Math.abs(left-right);
		
		if(result>1)
			return Integer.MIN_VALUE;
		else
			result=Math.max(left, right)+1;
		
		return result;
	}
}
