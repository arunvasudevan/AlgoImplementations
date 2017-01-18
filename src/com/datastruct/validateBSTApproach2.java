package com.datastruct;

// Validate if a given binary tree is a BST 
// All left nodes are less than equal to root and all right nodes are greater than root.

public class validateBSTApproach2 {

	boolean isBST(TreeNode root) {
		return checkBST(root, null, null);
	}

	boolean checkBST(TreeNode root, Integer min, Integer max) {
		if (root == null)
			return true;
		
		if ((min!=null && root.data <= min) || (max!=null && root.data>max))
			return false;

		if (!checkBST(root.left, min, root.data)|| !checkBST(root.right, root.data, max))
			return false;
		
		System.out.println("Data:"+root.data+ " Min:"+min+ " Max:"+max);
		return true;
	}
}
