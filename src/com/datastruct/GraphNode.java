package src.com.datastruct;

import java.util.LinkedList;

public class GraphNode {
	int name;
	int cost;
	boolean visitedFlag;
	LinkedList<GraphNode> adjacencyList;
	
	GraphNode(int name,int cost){
		this.name=name;
		this.cost=cost;
		this.visitedFlag=false;
		this.adjacencyList=new LinkedList<GraphNode>();
	}
	
	void addAdjacent(GraphNode adjacentNode){
		adjacencyList.add(adjacentNode);
	}

	void setVisitedFlag(boolean visitedFlag){
		this.visitedFlag=visitedFlag;
	}
	
	boolean getVisitedFlag(){
		return visitedFlag;
	}
}
