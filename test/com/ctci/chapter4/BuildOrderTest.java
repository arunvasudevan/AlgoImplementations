package com.ctci.chapter4;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Stack;

import org.junit.Before;
import org.junit.Test;

public class BuildOrderTest {
	BuildOrder build;
	BuildOrderRevisited buildRevisited;
	Stack<String> expectedStack;
	ArrayList<String> expectedResult;

	@Before
	public void setUp() throws Exception {
		build = new BuildOrder();
		buildRevisited = new BuildOrderRevisited();

		expectedStack = new Stack<String>();
		expectedStack.add("f");
		expectedStack.add("a");
		expectedStack.add("b");
		expectedStack.add("d");
		expectedStack.add("c");
		expectedStack.add("e");

		expectedResult = new ArrayList<String>();
		expectedResult.add("f");
		expectedResult.add("e");
		expectedResult.add("a");
		expectedResult.add("b");
		expectedResult.add("d");
		expectedResult.add("c");
	}

	@Test
	public void testProblemBuildOrder() {
		System.out.println();
		System.out.println("---------------------------------------");
		System.out.println("Problem Build Order");
		System.out.println("---------------------------------------");
		final String[] projects = { "a", "b", "c", "d", "e", "f" };
		final String[][] dependencies = { { "d", "a" }, { "d", "b" }, { "b", "f" }, { "a", "f" }, { "c", "d" } };
		final ArrayList<String> resultArray = build.findBuildOrder(projects, dependencies);
		System.out.print("Build Order (Approach 1):");
		for (final String project : resultArray) {
			System.out.print(project + ",");
		}

		final Stack<String> stack = buildRevisited.findBuildOrder(projects, dependencies);
		System.out.print("Stack Output (Approach 2):");
		for (final String project : stack) {
			System.out.print(project + ",");
		}

		assertEquals(expectedResult, resultArray);
		assertEquals(expectedStack, stack);
	}

	@Test
	public void testCyclicBuildOrder() {
		System.out.println("---------------------------------------");
		System.out.println("Cyclic Build Order Test");
		System.out.println("---------------------------------------");
		final String[] projects = { "a", "b", "c", "d", "e", "f" };
		final String[][] dependencies = { { "d", "a" }, { "d", "b" }, { "b", "f" }, { "a", "d" }, { "c", "d" } };
		final Stack<String> resultStack = buildRevisited.findBuildOrder(projects, dependencies);
		System.out.print("Cyclic Build Order Output is:" + resultStack);
		for (final String project : resultStack) {
			System.out.print(project + ",");
		}

		assertEquals(null, resultStack);
	}

}
