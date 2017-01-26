package com.datastruct;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class GraphTester {

	public static void main(String[] args) {
		
		GraphNode n1=new GraphNode(10);
		GraphNode n2=new GraphNode(9);
		
		GraphNode n3=new GraphNode(8);
		
		GraphNode n4=new GraphNode(7);
		
		GraphNode n5=new GraphNode(6);
		
		n1.addAdjacentEdge(2, n2);
		n2.addAdjacentEdge(3, n3);
		n3.addAdjacentEdge(4, n4);
		n4.addAdjacentEdge(2, n5);
		n2.addAdjacentEdge(4, n4);

		Graph g=new Graph();
		g.addVertices(n1);
		g.addVertices(n2);
		g.addVertices(n3);
		g.addVertices(n4);
		g.addVertices(n5);
		
		GraphTester gTest=new GraphTester();
		
		gTest.graphPrint(g);
		
		for(GraphNode grNode:g.getVertices())
			grNode.visited=false;
		

		System.out.println("Nodes: n1 and n4 are connected? "+g.routebetweenTwoNodes(n1, n4));
		GraphNode n6=new GraphNode(23);
		System.out.println("Nodes: n1 and n6 are connected? "+g.routebetweenTwoNodes(n1, n6));
	}

	void graphPrint(Graph gr) {
		System.out.println("Inside Print Graph");
		if (gr == null)
			return;

		List<GraphNode> graphList = gr.getVertices();

		for (GraphNode g : graphList) {
			g.visited = false;
		}

		GraphNode firstNode = graphList.get(0);
		System.out.println("First Node:"+firstNode.data);
		breadthFirstTraversal(firstNode);
		
		
	}

	void breadthFirstTraversal(GraphNode node) {

		Queue<GraphNode> q = new LinkedList<GraphNode>();
		q.add(node);
		while (!q.isEmpty()) {
			GraphNode temp=q.remove();
			for (Adjacency a : temp.adjacencyList) {
				if (a.adjacent.visited == false){
					a.adjacent.visited=true;
					q.add(a.adjacent);
				}
				System.out.println("Node:"+temp.data+" connected to:"+a.adjacent.data+" with cost:"+a.cost);
			}
		}
		
	}
}
