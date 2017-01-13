package com.datastruct;

import java.util.LinkedList;
import java.util.List;


public class GraphNode {
    int data;
    boolean visited;
	List<adjacency> adjacencyList;
	
	public GraphNode(int data, boolean visited){
		this.data=data;
		this.visited=visited;
	}
	
	public GraphNode(int data){
		this.data=data;
		this.visited=false;
		adjacencyList=new LinkedList<adjacency>();
	}
	
	public void addAdjacentEdge(int cost,GraphNode n){
		adjacency adj=new adjacency(cost,n);
		adjacencyList.add(adj);
	}
}
