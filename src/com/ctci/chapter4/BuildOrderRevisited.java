package com.ctci.chapter4;

import java.util.ArrayList;
import java.util.Stack;

import com.datastruct.*;

public class BuildOrderRevisited {
	
	public Stack<GraphNode> findBuildOrder(String[] projects, String[][] dependencies){
		Stack<GraphNode> stack = new Stack<GraphNode>();
		Graph g = new Graph();
		buildGraph(projects, dependencies, g);
		printGraph(g);
		return stack;
	}

	private void printGraph(Graph g) {
		ArrayList<GraphNode> vertices = g.getVertices();
		
		for(GraphNode vertex: vertices) {
			vertex.setVisited("NEW");
		}
		
		for(GraphNode vertex: vertices) {
			if(vertex.getVisited().equalsIgnoreCase("NEW")) {
				graphVisit(vertex);
			}
		}
	}

	/**
	 * @param vertex
	 */
	private void graphVisit(GraphNode vertex) {
		vertex.setVisited("VISITING");
		ArrayList<Adjacency> adjacentList = vertex.getAdjacency();
		for(Adjacency adj: adjacentList) {
			if(adj.getAdjacent().getVisited().equalsIgnoreCase("NEW")) {	
				graphVisit(adj.getAdjacent());
			}
		}
		vertex.setVisited("VISITED");
		System.out.println(vertex.getsData());
	}

	/**
	 * @param projects
	 * @param dependencies
	 */
	private void buildGraph(String[] projects, String[][] dependencies, Graph g) {
		addProjectsToGraph(projects, g);
		System.out.println();
		System.out.println("Added Projects...");
		addDependenciesToGraph(dependencies, g);
	}

	private void addDependenciesToGraph(String[][] dependencies, Graph g) {
		for (String[] dependent: dependencies) {
			String startProject = dependent[0];
			String endProject = dependent[1];
			g.addEdges(startProject, endProject);
		}		
	}

	private void addProjectsToGraph(String[] projects, Graph g) {
		for (String project: projects) {
			g.addVertices(project);
		}
	}

}
