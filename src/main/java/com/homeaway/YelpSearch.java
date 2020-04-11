package com.homeaway;

import java.util.LinkedList;
import java.util.Queue;

import com.datastruct.YelpTreeNode;

/*
 * Problem Statement - Yelp Search Functionality
 * 		Given a one dimensional location and type find the nearest location for the same type.
 * 		If not found return null. 
 */


public class YelpSearch {
	YelpTreeNode root;
	public YelpSearch(YelpTreeNode root){
		this.root = root;
	}
	
	YelpTreeNode findNearestLocbyType(int loc, String type){
		int shortestDist = Integer.MAX_VALUE;
		YelpTreeNode result = null; 
		
		if(root == null){
			return result;
		}
		
		final Queue<YelpTreeNode> q = new LinkedList<YelpTreeNode>();		
		q.add(root);
		
		while(!q.isEmpty()) {
			final YelpTreeNode currentNode = q.remove();
			final int dist = Math.abs(currentNode.loc - loc); 
			
			if(dist != 0 && dist < shortestDist && currentNode.type.equalsIgnoreCase(type)) {
				shortestDist = dist;
				result = currentNode;
			}
			if(currentNode.left != null) {
				q.add(currentNode.left);
			}
			if(currentNode.right != null) {
				q.add(currentNode.right);
			}
		}
			
		return result;
	}
}
