package com.datastruct;

public class TreeNodeModified {
	
	int data;
	TreeNodeModified left,right;
	boolean visited;
	int depth;
	
	
	public TreeNodeModified(){
		visited=false;
	}
	
	public TreeNodeModified(int data){
		this.data=data;
		left=right=null;
	}

}
