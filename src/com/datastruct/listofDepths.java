package com.datastruct;


import java.util.LinkedList;
import java.util.Queue;

// Problem Statement: Given a Binary Tree return a linked list for each depth. For Ex: A Tree with a depth of D should return D linkedLists

public class listofDepths {
	LinkedList<TreeNodeModified>[] depthList;

	LinkedList<TreeNodeModified>[] BFS(TreeNodeModified n) {
		final int d = maxDepth(n);
		System.out.println("Total Depth:" + d);
		depthList = new LinkedList[d];
		for (int i = 0; i < d; i++) {
			depthList[i] = new LinkedList();
		}
		n.depth = 0;
		final Queue<TreeNodeModified> q = new LinkedList<TreeNodeModified>();
		q.add(n);
		TreeNodeModified u;
		while (!q.isEmpty()) {
			u = q.remove();
			if (u.left != null) {
				u.left.depth = u.depth + 1;
				q.add(u.left);
			}
			if (u.right != null) {
				u.right.depth = u.depth + 1;
				q.add(u.right);
			}
			final LinkedList<TreeNodeModified> t = depthList[u.depth];
			t.add(u);
		}
		return depthList;
	}

	int maxDepth(TreeNodeModified n) {
		if (n == null)
			return 0;

		int right = 0, left = 0;
		if (n.left != null)
			left = maxDepth(n.left);
		if (n.right != null)
			right = maxDepth(n.right);

		return Math.max(left, right) + 1;
	}

}
