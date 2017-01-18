package com.ctci.chapter4;

import com.datastruct.TreeNode;

//Problem Statement: Check if a tree is balanced.
//For the purposes of the problem a Balanced tree is one in which the 
//the heights of the two subtrees of any node never differ by more than one. 

// Test checkBalancedTree class
public class TestCheckBalancedTree {

	public static void main(String[] args) {
		final TreeNode n1=new TreeNode(5);
		final TreeNode n2=new TreeNode(4);
		final TreeNode root=new TreeNode(3);
		final TreeNode n4=new TreeNode(1);
		final TreeNode n5=new TreeNode(1);
		final TreeNode n6=new TreeNode(0);

		n5.left=n6;
		n5.right=n4;
		
		n2.right=n1;
		
		root.right=n2;
		root.left=n5;
		
		final checkBalancedTree c=new checkBalancedTree();
		
		System.out.println("Is the Binary Tree Balanced?"+c.checkBalanced(root));
		
		final validateBST v=new validateBST();
		System.out.println("Is it a BST? "+v.isBST(root));
		final validateBSTApproach2 v2=new validateBSTApproach2();
		System.out.println("Is it a BST? "+v2.isBST(root));
		
	}

}
