package com.datastruct;

public class TreeNodeModified {
	
	public int data;
	public TreeNodeModified left;
	public TreeNodeModified right;
	boolean visited;
	public int depth;
	
	
	public TreeNodeModified(){
		visited=false;
	}
	
	public TreeNodeModified(int data){
		this.data=data;
		left=right=null;
	}

}
