package com.ctci.chapter4;

import java.util.ArrayList;
import com.datastruct.*;
import java.util.*;

public class BSTSequence {
	public ArrayList<ArrayList<Integer>> findBSTSequence(TreeNode root) {
		if (root == null) {
			return null;
		}
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(root);

		ArrayList<Integer> a = new ArrayList<Integer>();
		a.add(root.data);

		result.add(a);

		while (!q.isEmpty()) {
			ArrayList<ArrayList<Integer>> possibleArray = findPossibleArraysbyDepth(q);
			
		}

		return result;
	}

	private ArrayList<ArrayList<Integer>> findPossibleArraysbyDepth(
			Queue<TreeNode> q) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		
		
		return result;
	}

}
