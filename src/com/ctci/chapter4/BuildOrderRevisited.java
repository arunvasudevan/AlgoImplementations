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
		//System.out.print("Print Graph:");
		//printGraph(g);
		return addBuildOrderToStack(stack);
	}

	private Stack<String> addBuildOrderToStack(Stack<String> stack) {
		ArrayList<GraphNode> projects = g.getVertices();

		for (GraphNode project : projects) {
			project.setVisited("NEW");
		}
		
		for (GraphNode project : projects) {
			if(project.getVisited().equalsIgnoreCase("NEW")){
				if(!addDependenciesToStack(project, stack)) {
					return null;
				}
			}
		}
		return stack;
	}

	public boolean addDependenciesToStack(GraphNode project, Stack<String> stack){
		if(project.getVisited().equalsIgnoreCase("VISITING")) {
			return false;
		}
		project.setVisited("VISITING");
		for(Adjacency adj: project.getAdjacency()) {
			if(!addDependenciesToStack(adj.getAdjacent(), stack)) {
				return false;
			}
		}
		//if(project.getVisited().equalsIgnoreCase(""));
		stack.add(project.getsData());
		project.setVisited("VISITED");
		return true;
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
			//System.out.println("Add Dependency for Project:"+startProject+" as Project:"+endProject);
			g.addEdges(startProject, endProject);
		}
	}

	private void addProjectsToGraph(String[] projects, Graph g) {
		for (String project : projects) {
			g.addVertices(project);
		}
	}

}
