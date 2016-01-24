package com.datastruct;

import java.util.LinkedList;

/* Breadth First Search Implementation in Java 
 * Input - Adjacency List
 * Output - Shortest Path from the source */

public class BFSImplementation {
	public static void main(String[] args) {
		int[][] adjList = { { 1, 2 }, { 0, 3 }, { 0, 3 }, { 1, 2, 4 }, { 3 } };
		BFSImplementation b = new BFSImplementation();
		b.doBfs(adjList, 1);
	}

	/**
	 * @param adjList
	 * @param source
	 */
	public void doBfs(int[][] adjList, int source) {
		int bfs[] = new int[adjList.length];
		int visited[] = new int[adjList.length];

		/* Queue to add all the neighbours of the visited nodes*/
		LinkedList<Integer> queue = new LinkedList<Integer>();

		queue.add(source);
		visited[source] = 1; // Once added to the queue mark it as Visited
		int element;
		int k = 0;
		while (!queue.isEmpty()) {
			element = Integer.parseInt(queue.remove().toString());
			bfs[k++] = element;
			for (int j = 0; j < adjList[element].length; j++) {
				int neigh = adjList[element][j];
				if (visited[neigh] == 0) {
					queue.add(neigh);
					visited[neigh] = 1;
				}
			}
		}

		System.out.print("BFS Traversal for the graph:");
		for (int l = 0; l < bfs.length; l++) {
			System.out.print(bfs[l] + ",");
		}
	}
}
