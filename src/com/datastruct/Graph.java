package com.datastruct;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Graph {
	
	ArrayList<GraphNode> vertices;
	
	public Graph(){
		vertices=new ArrayList<GraphNode>();
	}
	
	void addVertices(GraphNode g){
		vertices.add(g);
	}

	ArrayList<GraphNode> getVertices(){
		return vertices;
	}
	
	boolean routebetweenTwoNodes(GraphNode a, GraphNode b){
		if(a==b)
			return true;
		
		Queue<GraphNode> q=new LinkedList<GraphNode>();
		q.add(a);
		
		while(!q.isEmpty()){
			GraphNode temp=q.remove();
			List<adjacency> l=temp.adjacencyList;
			
			for(adjacency adj:l){
				if(adj.adjacent.visited==false){
					adj.adjacent.visited=true;
					q.add(adj.adjacent);
				}
				if(adj.adjacent==b)
					return true;
			}
		}
		return false;
	}
}
