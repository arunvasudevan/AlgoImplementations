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
			nextNode = findSuccessor(root, findSuccessor.data);
		}
		return nextNode;
	}

	private TreeNode findSuccessor(TreeNode root, Integer min) {
		if (root.data > min) {
			nextNode = root;
			findSuccessor(root.left, min);
		} else if (root.data < min) {
			nextNode = findSuccessor(root.right, min);
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
