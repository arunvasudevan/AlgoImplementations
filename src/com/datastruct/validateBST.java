package com.datastruct;

public class validateBST {
	Integer max = null;

	boolean isBST(TreeNode root) {
		if (root == null)
			return false;

		final validateBST v = new validateBST();
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
