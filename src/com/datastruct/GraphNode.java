package com.datastruct;

import java.util.LinkedList;
import java.util.List;

public class GraphNode {
	int data;
	String sData;
	boolean visited;
	String sVisited;
	
	
	List<Adjacency> adjacencyList;
	
	public String getVisited() {
		return sVisited;
	}

	public void setVisited(String sVisited) {
		this.sVisited = sVisited;
	}


	public String getsData() {
		return sData;
	}

	public void setsData(String sData) {
		this.sData = sData;
	}

	public GraphNode(int data, boolean visited) {
		this.data = data;
		this.visited = visited;
	}

	public GraphNode(int data) {
		this.data = data;
		this.visited = false;
		adjacencyList = new LinkedList<Adjacency>();
	}

	public GraphNode(String sData) {
		this.sData = sData;
		this.visited = false;
		adjacencyList = new LinkedList<Adjacency>();
	}

	public void addAdjacentEdge(int cost, GraphNode n) {
		Adjacency adj = new Adjacency(cost, n);
		adjacencyList.add(adj);
	}

	public void addAdjacentEdge(GraphNode n) {
		Adjacency adj = new Adjacency(n);
		adjacencyList.add(adj);
	}
	
	public LinkedList<Adjacency> getAdjacency() {
		return (LinkedList<Adjacency>) adjacencyList;
	}
}
