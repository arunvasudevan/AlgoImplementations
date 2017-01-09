package com.datastruct;

import java.util.LinkedList;
import java.util.Queue;

// Problem Statement: Check if a tree is balanced.
// For the purposes of the problem a Balanced tree is one in which the 
// the heights of the two subtrees of any node never differ by more than one. 

public class checkBalancedTree {
	
	boolean checkBalanced(TreeNode root){
		if(root==null)
			return false;
		int counter=0;
		
		Queue<TreeNode> q=new LinkedList<TreeNode>();
		q.add(root);
		TreeNode u;
		while(!q.isEmpty()){
			u=q.remove();
			
			if(u.left!=null)
				q.add(u.left);
			
			if(u.right!=null)
				q.add(u.right);
			
			if((u.left!=null && u.right==null) || (u.right!=null && u.left==null))
				++counter;
			
			System.out.println("Node:"+u.data+ " Counter: "+counter);
			
			if(counter>1)
				return false;
		}
		return true;
	}
}