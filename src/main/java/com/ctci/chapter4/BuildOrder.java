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
	ArrayList<String> resultList;

	public ArrayList<String> findBuildOrder(String[] projects,
			String[][] dependencies) {
		resultList = new ArrayList<String>();
		for (int i = projects.length - 1; i > 0; i--) {
			String currentProject = projects[i];
			//System.out.println("current Project:" + currentProject);
			if (!resultList.contains(currentProject)) {
				findDependencies(dependencies, currentProject);
			}
		}
		return resultList;
	}

	/**
	 * @param dependencies
	 * @param currentProject
	 */
	private void findDependencies(String[][] dependencies, String currentProject) {
		for (int i = 0; i < dependencies.length; i++) {
			int j = 0;
			if (currentProject == dependencies[i][j]) {
				findDependencies(dependencies, dependencies[i][++j]);
			}
		}
		if (!resultList.contains(currentProject)) {
			resultList.add(currentProject);
		}
	}
}
