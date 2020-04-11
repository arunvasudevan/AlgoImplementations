package com.ctci.chapter4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

import com.datastruct.Adjacency;
import com.datastruct.Graph;
import com.datastruct.GraphNode;

/*
 * Given a list of projects and a list of dependencies. 
 * ALl of a projects dependencies must be built before the project is.
 * Find a build order that will allow the projects to be built.
 * Input: 
 * Projects: a, b, c, d, e, f
 * Dependencies: (d,a), (b,f), (d,b), (a,f), (c,d)
 * 
 * Output:  f, e, a, b, d, c
 */

public class BuildOrderRevisited {
	Graph g;
	public Stack<String> findBuildOrder(String[] projects,
			String[][] dependencies) {
		final Stack<String> stack = new Stack<String>();
		g = new Graph();
		buildGraph(projects, dependencies, g);
		//System.out.print("Print Graph:");
		//printGraph(g);
		return addBuildOrderToStack(stack);
	}

	private Stack<String> addBuildOrderToStack(Stack<String> stack) {
		final ArrayList<GraphNode> projects = g.getVertices();

		for (final GraphNode project : projects) {
			project.setVisited("NEW");
		}
		
		for (final GraphNode project : projects) {
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
		
		if(project.getVisited().equalsIgnoreCase("NEW")) {
			project.setVisited("VISITING");
			for(final Adjacency adj: project.getAdjacency()) {
				if(!addDependenciesToStack(adj.getAdjacent(), stack)) {
					return false;
				}
			}
			stack.add(project.getsData());
			project.setVisited("VISITED");
		}
		return true;
	}
	
	private void printGraph(Graph g) {
		final ArrayList<GraphNode> vertices = g.getVertices();

		for (final GraphNode vertex : vertices) {
			vertex.setVisited("NEW");
		}

		for (final GraphNode vertex : vertices) {
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
		final LinkedList<Adjacency> adjacentList = vertex.getAdjacency();
		for (final Adjacency adj : adjacentList) {
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
		for (final String[] dependent : dependencies) {
			final String startProject = dependent[0];
			final String endProject = dependent[1];
			g.addEdges(startProject, endProject);
		}
	}

	private void addProjectsToGraph(String[] projects, Graph g) {
		for (final String project : projects) {
			g.addVertices(project);
		}
	}

}
