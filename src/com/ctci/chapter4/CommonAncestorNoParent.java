package com.ctci.chapter4;

import java.util.Stack;

import com.datastruct.TreeNode;

public class CommonAncestorNoParent {

	TreeNode findCommonAncestor(TreeNode root, TreeNode nodeA, TreeNode nodeB) {

		final Stack<TreeNode> nodeAStack = new Stack<TreeNode>();
		final Integer nodeADepth = findDepthDFS(root, nodeA, 0, nodeAStack);
				
		final Stack<TreeNode> nodeBStack = new Stack<TreeNode>();
		final Integer nodeBDepth = findDepthDFS(root, nodeB, 0, nodeBStack);
		
		if (nodeADepth == null || nodeBDepth == null) {
			return null;
		}
		
		Stack<TreeNode> lowerStack = nodeAStack;
		Stack<TreeNode> higherStack = nodeBStack;
		
		if(nodeADepth != nodeBDepth) {
			lowerStack = (nodeADepth > nodeBDepth) ? nodeBStack : nodeAStack;
			higherStack = (nodeADepth > nodeBDepth) ? nodeAStack : nodeBStack;
			higherStack = goUpBy(higherStack, Math.abs(nodeADepth - nodeBDepth));
		}
		return findCommonParent(lowerStack, higherStack);
	}
	
	TreeNode findCommonParent(Stack<TreeNode> stackA, Stack<TreeNode> stackB){
		
		TreeNode stackANode = stackA.pop();
		TreeNode stackBNode = stackB.pop();
		
		while(stackANode.data != stackBNode.data) {
			stackANode = stackA.pop();
			stackBNode = stackB.pop();
		}
		return stackANode;
	}
	
	Stack<TreeNode> goUpBy(Stack<TreeNode> stackNode, int depthUp){
		while(depthUp > 0) {
			--depthUp;
			stackNode.pop();
		}
		return stackNode;
	}

	Integer findDepthDFS(TreeNode root, TreeNode findNodeDepth, int depth, Stack<TreeNode> nodeStack) {
		if (root == null) {
			return null;
		}

		nodeStack.push(root);

		if (root.data == findNodeDepth.data) {
			return depth;
		}

		if (root.left != null) {
			final Integer valLeft = findDepthDFS(root.left, findNodeDepth, ++depth, nodeStack);
			if (valLeft != null) {
				return valLeft;
			}
		}

		if (root.right != null) {
			final Integer valRight = findDepthDFS(root.right, findNodeDepth, depth, nodeStack);
			if (valRight != null) {
				return valRight;
			}
		}
		
		nodeStack.pop();
		--depth;
		return null;
	}
	
	/*Integer findDepthNoParent(TreeNode root, TreeNode findNodeDepth) {
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
	}*/
}
