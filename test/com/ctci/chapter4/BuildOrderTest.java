package com.ctci.chapter4;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class BuildOrderTest {
	BuildOrder build;
	BuildOrderRevisited buildRevisited;

	@Before
	public void setUp() throws Exception {
		build = new BuildOrder();
		buildRevisited = new BuildOrderRevisited();
	}

	@Test
	public void testProblemBuildOrder() {
		String[] projects = { "a", "b", "c", "d", "e", "f" };
		String[][] dependencies = { { "d", "a" }, { "d", "b" }, { "b", "f" },
				{ "a", "f" }, { "c", "d" } };
		ArrayList<String> resultArray = build.findBuildOrder(projects,
				dependencies);
		System.out.print("Build Order:");
		for (String project : resultArray) {
			System.out.print(project + ",");
		}
		ArrayList<String> expectedResult = new ArrayList<String>();
		expectedResult.add("f");
		expectedResult.add("e");
		expectedResult.add("a");
		expectedResult.add("b");
		expectedResult.add("d");
		expectedResult.add("c");

		buildRevisited.findBuildOrder(projects, dependencies);
		
		assertEquals(expectedResult, resultArray);
	}

	/*@Test
	public void testCyclicBuildOrder() {
		String[] projects = { "a", "b", "c", "d", "e", "f" };
		String[][] dependencies = { { "d", "a" }, { "d", "b" }, { "b", "f" },
				{ "a", "d" }, { "c", "d" } };
		ArrayList<String> resultArray = build.findBuildOrder(projects,
				dependencies);
		System.out.print("Build Order 2:");
		for (String project : resultArray) {
			System.out.print(project + ",");
		}
		ArrayList<String> expectedResult = new ArrayList<String>();
		expectedResult.add("f");
		expectedResult.add("e");
		expectedResult.add("a");
		expectedResult.add("b");
		expectedResult.add("d");
		expectedResult.add("c");

		assertEquals(expectedResult, resultArray);
	}*/

}
