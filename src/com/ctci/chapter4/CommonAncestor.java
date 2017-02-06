package com.ctci.chapter4;

import com.datastruct.*;
import java.util.HashMap;
import java.util.Queue;
import java.util.LinkedList;

public class CommonAncestor {
	public TreeNode findCommonAncestor(TreeNode root, TreeNode nodeA, TreeNode nodeB) {
		Integer nodeADepth = findDepth(root, nodeA);
		Integer nodeBDepth = findDepth(root, nodeB);
		
		System.out.println("Node A Depth:"+nodeADepth);
		System.out.println("Node B Depth:"+nodeBDepth);
		
		if(nodeADepth == null || nodeBDepth== null) {
			return null;
		}
		return root;
	}
	
	Integer findDepth(TreeNode root, TreeNode findNodeDepth){
		int depth = 0;
		if(root.data == findNodeDepth.data) {
			return depth;
		}
		Queue<HashMap<TreeNode, Integer>> q = new LinkedList<HashMap<TreeNode, Integer>>();
		HashMap<TreeNode, Integer> rootMap = new HashMap<TreeNode, Integer>();
		rootMap.put(root, depth);
		q.add(rootMap);
		while(!q.isEmpty()){
			System.out.println("Inside Queue");
			HashMap<TreeNode, Integer> iterativeMap = q.remove();
			for(TreeNode iterativeNode : iterativeMap.keySet()) {
				Integer nodeDepth = iterativeMap.get(iterativeNode);
				if(iterativeNode.data == findNodeDepth.data) {
					return nodeDepth;
				}
				++nodeDepth;
				if(iterativeNode.left != null) {
					HashMap<TreeNode, Integer> leftMap = new HashMap<TreeNode, Integer>();
					leftMap.put(iterativeNode.left, nodeDepth);
					q.add(leftMap);
				}
				if(iterativeNode.right != null) {
					HashMap<TreeNode, Integer> rightMap = new HashMap<TreeNode, Integer>();
					rightMap.put(iterativeNode.left, nodeDepth);
					q.add(rightMap);
				}
			}
		}
		return null;
	}

}
