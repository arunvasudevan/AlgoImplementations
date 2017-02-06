package com.ctci.chapter4;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

import com.datastruct.TreeNode;

public class CommonAncestor {
	public TreeNode findCommonAncestor(TreeNode root, TreeNode nodeA, TreeNode nodeB) {
		final Integer nodeADepth = findDepth(root, nodeA);
		final Integer nodeBDepth = findDepth(root, nodeB);

		System.out.println("Node A Depth:" + nodeADepth);
		System.out.println("Node B Depth:" + nodeBDepth);

		if (nodeADepth == null || nodeBDepth == null) {
			return null;
		}
		return root;
	}

	Integer findDepth(TreeNode root, TreeNode findNodeDepth) {
		final int depth = 0;
		if (root.data == findNodeDepth.data) {
			return depth;
		}
		final Queue<HashMap<TreeNode, Integer>> q = new LinkedList<HashMap<TreeNode, Integer>>();
		HashMap<TreeNode, Integer> nodeMap = new HashMap<TreeNode, Integer>();
		nodeMap.put(root, depth);
		q.add(nodeMap);
		while (!q.isEmpty()) {
			final HashMap<TreeNode, Integer> iterativeMap = q.remove();
			for (final TreeNode iterativeNode : iterativeMap.keySet()) {
				Integer nodeDepth = iterativeMap.get(iterativeNode);
				if (iterativeNode.data == findNodeDepth.data) {
					return nodeDepth;
				}
				++nodeDepth;
				if (iterativeNode.left != null) {
					nodeMap = new HashMap<TreeNode, Integer>();
					nodeMap.put(iterativeNode.left, nodeDepth);
					q.add(nodeMap);
				}
				if (iterativeNode.right != null) {
					nodeMap = new HashMap<TreeNode, Integer>();
					nodeMap.put(iterativeNode.right, nodeDepth);
					q.add(nodeMap);
				}
			}
		}
		return null;
	}

}
