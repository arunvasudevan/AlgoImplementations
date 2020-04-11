package com.ctci.chapter4;

import org.junit.Assert;
import org.junit.Test;

import com.datastruct.BinaryTree;
import com.datastruct.TreeNode;

public class BinaryTreeTest {

    @Test
	public void testNodeInBinaryTree() {
		final BinaryTree bTree = new BinaryTree();

		final TreeNode root = new TreeNode(5);
		final TreeNode n2 = new TreeNode(3);
		final TreeNode n1 = new TreeNode(4);
		final TreeNode n4 = new TreeNode(1);
		final TreeNode n3 = new TreeNode(2);

		bTree.insert(root);
		bTree.insert(n1);
		bTree.insert(n2);
		bTree.insert(n3);
		bTree.insert(n4);

		System.out.print("Print Binary Tree: ");
		bTree.printBinaryTree();
		System.out.println();
		System.out.println();
		System.out.println("Node n1 available in the Binary Tree? "+bTree.find(n1));
        Assert.assertTrue(bTree.find(n1));
	}

}
