package com.datastruct;

import java.util.List;


public class GraphNode {
	private int data;
	private boolean visited;
	List<GraphNode> child;
	
	public GraphNode(){
		
	}
	public GraphNode(int data, boolean visited){
		this.data=data;
		this.visited=visited;
	}
	
	public GraphNode(int data){
		this.data=data;
		this.visited=false;
	}
	
	public void addChild(GraphNode n){
		child.add(n);
	}
	
	public void setVisitedFlag(boolean flag){
		visited=flag;
	}
	
	public boolean getVisitedFlag(){
		return visited;
	}
}
