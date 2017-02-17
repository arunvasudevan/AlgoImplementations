package com.ctci.chapter4;

import java.util.ArrayList;

import com.datastruct.*;

import java.util.*;

/*
 * Problem Statement - 4.9
 * A binary search tree was created by traversing through an array from left to right and inserting each element.
 * Given a binary search tree with distinct elements, print all possible arrays that could have led to this tree.
 * 
 */

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
			ArrayList<Integer> arrayByDepth = findArraybyDepth(q);
			
			if(arrayByDepth.size() == 0) {
				break;
			}
			
			ArrayList<ArrayList<Integer>> possibleArrays = generateCombinations(arrayByDepth);
			
			ArrayList<ArrayList<Integer>> copyResult = result;			
			result = new ArrayList<ArrayList<Integer>>();
			
			for(ArrayList<Integer> resultArray: copyResult) {
				for(ArrayList<Integer> possibleArrayList: possibleArrays) {
					ArrayList<Integer> interimResult = new ArrayList<Integer>();
					interimResult.addAll(resultArray);
					interimResult.addAll(possibleArrayList);
					result.add(interimResult);
				}
			}
		}

		return result;
	}
	
	private ArrayList<ArrayList<Integer>> generateCombinations(ArrayList<Integer> arrayByDepth){
		ArrayList<ArrayList<Integer>> possibleArrays = new ArrayList<ArrayList<Integer>>();
		possibleArrays.add(arrayByDepth);
		
		ArrayList<Integer> combinationArray = new ArrayList<Integer>();
		for(int i=arrayByDepth.size()-1; i>=0; i--) {
			combinationArray.add(arrayByDepth.get(i));
		}
		
		possibleArrays.add(combinationArray);
		return possibleArrays;
	}

	private ArrayList<Integer> findArraybyDepth(
			Queue<TreeNode> q) {
		ArrayList<Integer> depthArray = new ArrayList<Integer>();
		Queue<TreeNode> childQ = new LinkedList<TreeNode>();
		
		while(!q.isEmpty()) {
			TreeNode node = q.remove();
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
