package com.ctci.chapter4;

import com.datastruct.TreeNode;

/* Problem Statement:
 * Find a Common Ancestor for 2 given nodes in a Binary Tree
 */

public class CommonAncestor {
	public TreeNode findCommonAncestor(TreeNode nodeA, TreeNode nodeB) {
		final int nodeADepth = findDepth(nodeA);
		final int nodeBDepth = findDepth(nodeB);

		System.out.println("Node A Depth:" + nodeADepth);
		System.out.println("Node B Depth:" + nodeBDepth);

		if (nodeADepth == 0 || nodeBDepth == 0) {
			return null;
		}
		
		TreeNode higherNode = (nodeADepth > nodeBDepth)? nodeA : nodeB;
		final TreeNode lowerNode = (nodeADepth > nodeBDepth) ? nodeB : nodeA;
		
		higherNode = goUpBy(higherNode, Math.abs(nodeADepth - nodeBDepth));
		
		return findCommonParent(higherNode, lowerNode);
	}

	TreeNode findCommonParent(TreeNode nodeA, TreeNode nodeB) {		
		while(nodeA != nodeB) {
			nodeA = nodeA.parent;
			nodeB = nodeB.parent;
		}
		return nodeA;
	}
	
	TreeNode goUpBy(TreeNode node, int depthUp) {
		while(depthUp > 0) {
			depthUp--;
			node = node.parent;
		}
		return node;
	}
	
	int findDepth(TreeNode findNodeDepth) {
		int depth = 0;
		while(findNodeDepth != null) {
			findNodeDepth = findNodeDepth.parent;
			++depth;
		}
		return depth;
	}
}
