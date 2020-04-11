package com.leetcode;

import org.junit.Test;

public class DepthOfaBinaryTreeTest {

    public TreeNode buildTree() {
        TreeNode node = new TreeNode(1);
        TreeNode leftNode = new TreeNode(2);
        TreeNode leftMostNode = new TreeNode(4);
        TreeNode rightNode = new TreeNode(3);
        TreeNode rightOfLeftNode = new TreeNode(5);

        node.left = leftNode;
        node.right = rightNode;
        leftNode.right = rightOfLeftNode;
        leftNode.left = leftMostNode;

        return node;
    }

    @Test
    public void depthOftheBinaryTree() {
        DepthOfaBinaryTree depthOfaBinaryTree = new DepthOfaBinaryTree();

        System.out.println("Depth of the Binary Tree: " + depthOfaBinaryTree.treeDepth(buildTree()));
    }
}
