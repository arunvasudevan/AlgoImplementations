package com.ctci.chapter4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

import com.datastruct.TreeNode;

/*
 * Problem Statement - 4.9
 * A binary search tree was created by traversing through an array from left to right and inserting each element.
 * Given a binary search tree with distinct elements, print all possible arrays that could have led to this tree.
 * 
 */

public class BSTSequence {
	ArrayList<ArrayList<Integer>> permutationArray;

	public ArrayList<ArrayList<Integer>> findBSTSequence(TreeNode root) {
		if (root == null) {
			return null;
		}
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

		final Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(root);

		final ArrayList<Integer> rootArray = new ArrayList<Integer>();
		rootArray.add(root.data);

		result.add(rootArray);

		while (!q.isEmpty()) {
			// Get all the elements by depth
			final ArrayList<Integer> arrayByDepth = findArraybyDepth(q);

			if (arrayByDepth.size() == 0) {
				break;
			}

			permutationArray = new ArrayList<ArrayList<Integer>>();
			// Create all possible permutations for a given array by depth
			arrayPermutations(arrayByDepth, 0);

			final ArrayList<ArrayList<Integer>> copyResult = result;
			result = new ArrayList<ArrayList<Integer>>();
			
			// Create the result by combining array permutations with earlier result
			for (final ArrayList<Integer> resultArray : copyResult) {
				for (final ArrayList<Integer> possibleArrayList : permutationArray) {
					final ArrayList<Integer> interimResult = new ArrayList<Integer>();
					interimResult.addAll(resultArray);
					interimResult.addAll(possibleArrayList);
					result.add(interimResult);
				}
			}
		}
		return result;
	}

	/**
	 * @param arrayByDepth
	 * @param index
	 *            Create all permutations for the Given array
	 */
	private void arrayPermutations(ArrayList<Integer> arrayByDepth, int index) {
		if (index >= arrayByDepth.size() - 1) {
			final ArrayList<Integer> copyPossibleArray = new ArrayList<Integer>();
			for (final Integer a : arrayByDepth) {
				copyPossibleArray.add(a);
			}
			permutationArray.add(copyPossibleArray);
			return;
		}
		for (int i = index; i < arrayByDepth.size(); i++) {
			Collections.swap(arrayByDepth, i, index);
			arrayPermutations(arrayByDepth, index + 1);
			Collections.swap(arrayByDepth, index, i);
		}
	}

	/**
	 * @param q
	 * @return 
	 * 		Create an array of all elements for a given depth
	 */
	private ArrayList<Integer> findArraybyDepth(Queue<TreeNode> q) {
		final ArrayList<Integer> depthArray = new ArrayList<Integer>();
		final Queue<TreeNode> childQ = new LinkedList<TreeNode>();

		while (!q.isEmpty()) {
			final TreeNode node = q.remove();
			if (node.left != null) {
				depthArray.add(node.left.data);
				childQ.add(node.left);
			}
			if (node.right != null) {
				depthArray.add(node.right.data);
				childQ.add(node.right);
			}
		}
		q.addAll(childQ);

		return depthArray;
	}
}
