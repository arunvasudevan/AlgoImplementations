package com.ctci.chapter4;

import com.datastruct.TreeNode;

public class CommonAncestor {
	public TreeNode findCommonAncestor(TreeNode root, TreeNode nodeA, TreeNode nodeB) {
		final Integer nodeADepth = findDepth(nodeA);
		final Integer nodeBDepth = findDepth(nodeB);

		System.out.println("Node A Depth:" + nodeADepth);
		System.out.println("Node B Depth:" + nodeBDepth);

		if (nodeADepth == null || nodeBDepth == null) {
			return null;
		}
		
		TreeNode higherNode = (nodeADepth > nodeBDepth)? nodeA : nodeB;
		final TreeNode lowerNode = (nodeADepth > nodeBDepth) ? nodeB : nodeA;
		
		higherNode = goUpBy(higherNode, Math.abs(nodeADepth - nodeBDepth));
		
		return findCommonParent(higherNode, lowerNode);
	}

	TreeNode findCommonParent(TreeNode nodeA, TreeNode nodeB) {		
		while(nodeA.data != nodeB.data) {
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
	
	Integer findDepth(TreeNode findNodeDepth) {
		int depth = 0;
		while(findNodeDepth != null) {
			findNodeDepth = findNodeDepth.parent;
			++depth;
		}
		return depth;
	}
}
