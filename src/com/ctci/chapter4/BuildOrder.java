package com.ctci.chapter4;

import java.util.ArrayList;

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

public class BuildOrder {
	ArrayList<String> resultList = new ArrayList<String>();

	public ArrayList<String> findBuildOrder(String[] projects,
			String[][] dependencies) {
		for (int i = 0; i < projects.length; i++) {
			String currentProject = projects[i];
			if (!resultList.contains(currentProject)) {
				findDependencies(dependencies, currentProject);
			}
		}
		return resultList;
	}

	private void findDependencies(String[][] dependencies, String currentProject) {
		for (int i=0; i<dependencies.length; i++) {
			int j=0;
			while (currentProject == dependencies[i][j]) {
				findDependencies(dependencies, currentProject);
				++j;
			}
		}
	}
}
