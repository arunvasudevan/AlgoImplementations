package com.ctci.chapter4;

import com.datastruct.TreeNode;

public class successorNodewithNoParentLink {
	TreeNode nextNode = null;

	public TreeNode successorNode(TreeNode root, TreeNode findSuccessor) {
		if (root == null || findSuccessor == null) {
			return null;
		}
		if (findSuccessor.right != null) {
			nextNode = treeMinimum(findSuccessor.right, null);
		} else {
			nextNode = findSuccessor(root, findSuccessor.data, null);
		}
		return nextNode;
	}

	private TreeNode findSuccessor(TreeNode root, Integer min, Integer max) {
		if (root.data > min) {
			nextNode = root;
			findSuccessor(root.left, min, root.data);
		} else if (root.data < min) {
			nextNode = findSuccessor(root.right, min, max);
		} else if (root.data == min) {
			return nextNode;
		}
		return nextNode;
	}

	private TreeNode treeMinimum(TreeNode node, TreeNode minNode) {
		if (node != null && node.left != null) {
			minNode = treeMinimum(node.left, minNode);
		}
		if (minNode == null) {
			minNode = node;
		}
		return minNode;
	}
}
