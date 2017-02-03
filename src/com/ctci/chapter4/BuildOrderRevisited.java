package com.ctci.chapter4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

import com.datastruct.*;

public class BuildOrderRevisited {
	Graph g;
	public Stack<String> findBuildOrder(String[] projects,
			String[][] dependencies) {
		Stack<String> stack = new Stack<String>();
		g = new Graph();
		buildGraph(projects, dependencies, g);
		System.out.print("Print Graph:");
		printGraph(g);
		addBuildOrderToStack(stack);
		return stack;
	}

	private void addBuildOrderToStack(Stack<String> stack) {
		ArrayList<GraphNode> projects = g.getVertices();

		for (GraphNode project : projects) {
			project.setVisited("NEW");
		}
		
		for (GraphNode project : projects) {
			if(project.getVisited().equalsIgnoreCase("NEW")){
				addDependenciesToStack(project, stack);
			}
		}
	}

	public void addDependenciesToStack(GraphNode project, Stack<String> stack){
		project.setVisited("VISITING");
		for(Adjacency adj: project.getAdjacency()) {
			if(adj.getAdjacent().getVisited().equalsIgnoreCase("NEW")) {
				addDependenciesToStack(adj.getAdjacent(), stack);
			}
		}
		stack.add(project.getsData());
		project.setVisited("VISITED");
	}
	
	private void printGraph(Graph g) {
		ArrayList<GraphNode> vertices = g.getVertices();

		for (GraphNode vertex : vertices) {
			vertex.setVisited("NEW");
		}

		for (GraphNode vertex : vertices) {
			if (vertex.getVisited().equalsIgnoreCase("NEW")) {
				graphVisit(vertex);
			}
		}
	}

	/**
	 * @param vertex
	 */
	private void graphVisit(GraphNode vertex) {
		vertex.setVisited("VISITING");
		LinkedList<Adjacency> adjacentList = vertex.getAdjacency();
		for (Adjacency adj : adjacentList) {
			if (adj.getAdjacent().getVisited().equalsIgnoreCase("NEW")) {
				graphVisit(adj.getAdjacent());
			}
		}
		vertex.setVisited("VISITED");
		System.out.print(vertex.getsData() + ",");
	}

	/**
	 * @param projects
	 * @param dependencies
	 */
	private void buildGraph(String[] projects, String[][] dependencies, Graph g) {
		addProjectsToGraph(projects, g);
		System.out.println();
		addDependenciesToGraph(dependencies, g);
	}

	private void addDependenciesToGraph(String[][] dependencies, Graph g) {
		for (String[] dependent : dependencies) {
			String startProject = dependent[0];
			String endProject = dependent[1];
			g.addEdges(startProject, endProject);
		}
	}

	private void addProjectsToGraph(String[] projects, Graph g) {
		for (String project : projects) {
			g.addVertices(project);
		}
	}

}
