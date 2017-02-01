package com.ctci.chapter4;

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
		
		
	}

	/**
	 * @param projects
	 * @param dependencies
	 */
	private void buildGraph(String[] projects, String[][] dependencies, Graph g) {
		addProjectsToGraph(projects, g);
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
