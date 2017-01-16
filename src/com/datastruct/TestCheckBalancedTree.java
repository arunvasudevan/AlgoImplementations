package com.datastruct;


// Test checkBalancedTree class
public class TestCheckBalancedTree {

	public static void main(String[] args) {
		TreeNode n1=new TreeNode(5);
		TreeNode n2=new TreeNode(4);
		TreeNode root=new TreeNode(3);
		TreeNode n4=new TreeNode(1);
		TreeNode n5=new TreeNode(1);
		TreeNode n6=new TreeNode(0);

		n5.left=n6;
		n5.right=n4;
		
		n2.right=n1;
		
		root.right=n2;
		root.left=n5;
		
		checkBalancedTree c=new checkBalancedTree();
		
		System.out.println("Is the Binary Tree Balanced?"+c.checkBalanced(root));
		
		validateBST v=new validateBST();
		System.out.println("Is it a BST? "+v.isBST(root));
	}

}
