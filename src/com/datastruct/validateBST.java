package com.datastruct;

// Problem Statement: Check if a binary Tree is a BST

public class validateBST {
	int max=Integer.MIN_VALUE;
	
	boolean isBST(TreeNode root){
		return checkBST(root) != Integer.MIN_VALUE;
	}
	
	int checkBST(TreeNode root){
		if(root==null)
			return -1;
		
		if(checkBST(root.left) == Integer.MIN_VALUE)
			return Integer.MIN_VALUE;
		System.out.println("Node Value:"+root.data);
		if(max>root.data)
			return Integer.MIN_VALUE;
		
		max=root.data;
		
		if(checkBST(root.right) == Integer.MIN_VALUE)
			return Integer.MIN_VALUE;
		
		return 0;
	}
}
