package com.datastruct;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Graph {

	ArrayList<GraphNode> vertices;
	HashMap<String, GraphNode> verticesMap;

	public Graph() {
		vertices = new ArrayList<GraphNode>();
		verticesMap = new HashMap<String, GraphNode>();
	}

	void addVertices(GraphNode g) {
		vertices.add(g);
	}
	
	public void addVertices(String data) {
		GraphNode grNode = new GraphNode(data);
		vertices.add(grNode);
		verticesMap.put(data, grNode);
	}

	public ArrayList<GraphNode> getVertices() {
		return vertices;
	}

	public void addEdges(String startProject, String endProject) {
		GraphNode startProjectVertex = verticesMap.get(startProject);
		GraphNode endProjectVertex = verticesMap.get(endProject);
		
		startProjectVertex.addAdjacentEdge(endProjectVertex);
		
	}
	public boolean routebetweenTwoNodes(GraphNode a, GraphNode b) {
		if (a == b)
			return true;

		Queue<GraphNode> q = new LinkedList<GraphNode>();
		q.add(a);

		while (!q.isEmpty()) {
			GraphNode temp = q.remove();
			List<Adjacency> l = temp.adjacencyList;

			for (Adjacency adj : l) {
				if (adj.adjacent.visited == false) {
					adj.adjacent.visited = true;
					q.add(adj.adjacent);
				}
				if (adj.adjacent == b)
					return true;
			}
		}
		return false;
	}
}
