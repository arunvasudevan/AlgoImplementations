package com.ctci.chapter4;

import com.datastruct.BSTNode;

// Write an algorithms to find the next node (i.e. in-order successor) of a given node in a 
// BST. You may assume that each node has a link to its parent.

public class successorNode {

	BSTNode findSuccessor(BSTNode n) {
		if (n == null)
			return n;

		BSTNode nextNode = null;
		if (n.right != null)
			nextNode = findInorderNext(n.right);

		if (nextNode == null) {
			nextNode = n;
			while (nextNode.parent != null && nextNode.parent.left != nextNode) {
				nextNode = nextNode.parent;
			}
			nextNode = nextNode.parent;
		}
		return nextNode;
	}

	// Recursively find the left most node of a given node

	private BSTNode findInorderNext(BSTNode n) {

		while (n.left != null) {
			n = n.left;
		}
		return n;
	}
}
