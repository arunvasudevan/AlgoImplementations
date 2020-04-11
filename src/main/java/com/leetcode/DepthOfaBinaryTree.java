package com.leetcode;

public class DepthOfaBinaryTree {
    int depth = 0;

    public int treeDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        ++depth;
        Math.max(treeDepth(node.left), treeDepth(node.right));
        return depth;
    }
}


