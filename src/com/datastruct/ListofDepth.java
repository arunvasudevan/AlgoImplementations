package com.datastruct;

import java.util.*;

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
			temp.add(root);
			result.add(temp);
		} else {
			temp = result.get(level);
			temp.add(root);
		}

		temp.add(root);
		listofTreeDepth(root.left, ++level);
		listofTreeDepth(root.right, level);
		return result;
	}
}
