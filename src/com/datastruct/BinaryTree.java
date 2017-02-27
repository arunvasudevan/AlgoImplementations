package com.datastruct;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
	int size;
	TreeNode root;

	public void insert(TreeNode node) {
		if (root == null) {
			root = node;
			return;
		}
		final Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(root);

		while (!q.isEmpty()) {
			final TreeNode newNode = q.remove();

			if (newNode.left == null) {
				newNode.left = node;
				++size;
				break;
			}
			if (newNode.right == null) {
				newNode.right = node;
				++size;
				break;
			}
			q.add(newNode.left);
			q.add(newNode.right);
		}
	}

	public void printBinaryTree() {

		final Queue<TreeNode> printQueue = new LinkedList<TreeNode>();
		printQueue.add(root);

		while (!printQueue.isEmpty()) {
			final TreeNode n = printQueue.remove();
			System.out.print(n.data + ",");
			if (n.left != null) {
				printQueue.add(n.left);
			}
			if (n.right != null) {
				printQueue.add(n.right);
			}
		}
	}
	
	public boolean find(TreeNode findNode){
		
		final Queue<TreeNode> findQueue = new LinkedList<TreeNode>();
		findQueue.add(root);
		
		while (!findQueue.isEmpty()){
			final TreeNode node = findQueue.remove();
			if (node == findNode) {
				return true;
			}
			if(node.left != null) {
				findQueue.add(node.left);
			}
			if(node.right != null) {
				findQueue.add(node.right);
			}
		}
		return false;
	}
}
