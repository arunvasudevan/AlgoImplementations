package com.ctci.chapter4;

import com.datastruct.BSTNode;

// Write an algorithms to find the next node (i.e. in-order successor) of a given node in a 
// BST. You may assume that each node has a link to its parent.
// CtCI - Chapter 4 Problem 6

public class SuccessorNode {

	BSTNode findSuccessor(BSTNode n) {
		if (n == null)
			return n;

		if(n.right!=null)
			return findInorderNext(n.right);

		BSTNode nextNode = n.parent;
		while (nextNode != null && nextNode.right == n) {
			n=nextNode;
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
