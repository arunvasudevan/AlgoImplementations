package com.datastruct;

public class Adjacency {
	int cost;
	GraphNode adjacent;
	
	public GraphNode getAdjacent() {
		return adjacent;
	}

	public void setAdjacent(GraphNode adjacent) {
		this.adjacent = adjacent;
	}

	public Adjacency(int cost,GraphNode adjacent){
		this.cost=cost;
		this.adjacent=adjacent;
	}
	
	public Adjacency(GraphNode adjacent){
		this.adjacent=adjacent;
	}
}
