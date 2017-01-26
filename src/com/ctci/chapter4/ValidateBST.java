package com.ctci.chapter4;

import com.datastruct.TreeNode;

//Validate if a given binary tree is a BST 
// Approach 2 - All left nodes are less than equal to root and all right nodes are greater than or equal to root.

public class ValidateBST {
	Integer max = null;

	public boolean isBST(TreeNode root) {
		if (root == null)
			return false;

		final ValidateBST v = new ValidateBST();
		return v.checkBST(root);
	}

	boolean checkBST(TreeNode root) {
		if (root == null)
			return true;

		if (!checkBST(root.left))
			return false;

		System.out.println("Data:" + root.data);

		if (max == null || root.data > max)
			max = root.data;
		else
			return false;

		if (!checkBST(root.right))
			return false;

		return true;
	}
}
