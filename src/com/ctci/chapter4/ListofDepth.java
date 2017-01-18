package com.ctci.chapter4;

import java.util.ArrayList;
import java.util.LinkedList;

import com.datastruct.TreeNode;

//Problem Statement: Given a Binary Tree return a linked list for each depth. 
//For Ex: A Tree with a depth of D should return D linkedLists

public class ListofDepth {

	int level = 0;
	ArrayList<LinkedList<TreeNode>> result = new ArrayList<LinkedList<TreeNode>>();

	public ArrayList<LinkedList<TreeNode>> listofTreeDepth(TreeNode root,
			int level) {

		if (root == null)
			return null;
		LinkedList<TreeNode> temp = null;

		if (result.size() == level) {
			temp = new LinkedList<>();
			result.add(temp);
		} else {
			temp = result.get(level);
		}

		temp.add(root);
		listofTreeDepth(root.left, ++level);
		listofTreeDepth(root.right, level);
		return result;
	}
}
