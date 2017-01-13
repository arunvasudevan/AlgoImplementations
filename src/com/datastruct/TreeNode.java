package com.datastruct;

public class TreeNode {
	
	int data;
	TreeNode left,right;
	boolean visited;
	int depth;
	
	
	public TreeNode(){
		visited=false;
	}
	
	public TreeNode(int data){
		this.data=data;
		left=right=null;
	}

}
