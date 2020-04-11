package com.leetcode;

public class DepthOfaBinaryTreeTest {
    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        TreeNode leftNode = new TreeNode(2);
        TreeNode leftMostNode = new TreeNode(4);
        TreeNode rightNode = new TreeNode(3);
        TreeNode rightOfLeftNode = new TreeNode(5);

        node.left = leftNode;
        node.right = rightNode;
        leftNode.right = rightOfLeftNode;
        leftNode.left = leftMostNode;

        DepthOfaBinaryTree depthOfaBinaryTree = new DepthOfaBinaryTree();
        System.out.println("Depth of the Binary Tree: "+depthOfaBinaryTree.treeDepth(node));
    }
}
