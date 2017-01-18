package com.datastruct;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

// Problem Statement: Given a Binary Tree return a linked list for each depth. For Ex: A Tree with a depth of D should return D linkedLists

public class listsByDepth {
	ArrayList<LinkedList<TreeNode>> result;

	ArrayList<LinkedList<TreeNode>> BFS(TreeNode n) {
		result = new ArrayList<LinkedList<TreeNode>>();
		final Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(n);
		int level=1;
		while (!q.isEmpty()) {
			final LinkedList<TreeNode> t = new LinkedList<TreeNode>();
			TreeNode u = null;
			while (!q.isEmpty()) {
				u = q.remove();
				t.add(u);
			}
			System.out.print("Level "+level+": ");
			for (int i = 0; i < t.size(); i++) {
				final TreeNode temp = t.get(i);
				System.out.print(temp.data+" ");
				
				if (temp.left != null)
					q.add(temp.left);
				if (temp.right != null)
					q.add(temp.right);
			}
			result.add(t);
			++level;
			System.out.println();
		}
		return result;
	}
}
