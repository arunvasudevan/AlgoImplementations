package com.datastruct;

public class TreeNode {
	
	int data;
	TreeNode left,right;
	boolean visited;
	public TreeNode(){
		visited=false;
	}
	
	public TreeNode(int data){
		this.data=data;
		left=right=null;
	}

}
