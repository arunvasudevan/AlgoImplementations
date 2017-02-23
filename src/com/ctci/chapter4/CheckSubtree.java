package com.ctci.chapter4;

import com.datastruct.*;
import java.util.*;

/*
 * Problem Statement:
 * Check Subtree: T1 and T2 are two very large binary trees, with T1 much bigger than T2. Create an algorithm 
 * to determine if T2 is a subtree of T1.
 * 
 * A tree T2 is a subtree of T1 if there exists a node n in T1 such that the subtree of n is identical to T2.
 * That is, if you cut off the tree at node n, the two trees would be identical.
 */

public class CheckSubtree {
	public boolean subtreeCheck(TreeNode rootT1, TreeNode rootT2) {
		if(rootT2 == null){
			return true;
		}
		if(rootT1 == null) {
			return false;
		}
		Queue<TreeNode> q = new LinkedList<TreeNode>();	
		q.add(rootT1);
		
		while(!q.isEmpty()) {
			TreeNode nodeT1 = q.remove();
			
			if(nodeT1.equals(rootT2) && compareSubtree(nodeT1, rootT2)) {
					return true;
			}
			if(nodeT1.left != null) {
				q.add(nodeT1.left);
			}
			if(nodeT1.right != null) {
				q.add(nodeT1.right);
			}
		}	
		return false;
	}

	boolean compareSubtree(TreeNode nodeT1, TreeNode nodeT2) {
		
		Queue<TreeNode> queueT1 = new LinkedList<TreeNode>();
		Queue<TreeNode> queueT2 = new LinkedList<TreeNode>();
		
		queueT1.add(nodeT1);
		queueT2.add(nodeT2);
		
		while((nodeT1.equals(nodeT2)) && (nodeT1 != null) && (nodeT2 != null)) {		
			if(queueT1.isEmpty() && queueT2.isEmpty()) {
				return true;
			} else if(queueT1.isEmpty() || queueT2.isEmpty()) {
				break;
			}
			
			nodeT1 = queueT1.remove();
			
			if(nodeT1.left !=null) {
				queueT1.add(nodeT1.left);
			}
			
			if(nodeT1.right != null) {
				queueT1.add(nodeT1.right);
			}
			
			nodeT2 = queueT2.remove();
			
			if(nodeT2.left !=null) {
				queueT2.add(nodeT2.left);
			}
			
			if(nodeT2.right != null) {
				queueT2.add(nodeT2.right);
			}		
		}
		return false;
	}
	
}
