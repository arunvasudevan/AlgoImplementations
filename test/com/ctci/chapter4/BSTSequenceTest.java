package com.ctci.chapter4;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.datastruct.TreeNode;

/*
 * Problem Statement - 4.9
 * A binary search tree was created by traversing through an array from left to right and inserting each element.
 * Given a binary search tree with distinct elements, print all possible arrays that could have led to this tree.
 * 
 */

public class BSTSequenceTest {
	
	TreeNode root, rootL, rootR, rootLL, rootLR, rootRR, rootRL;
	BSTSequence bstSeq;

	@Before
	public void setUp() throws Exception {
		bstSeq = new BSTSequence();
		
		root = new TreeNode(3);
		
		rootL = new TreeNode(1);
		rootL.parent = root;
		
		rootLL = new TreeNode(0);
		rootLL.parent = rootL;
		
		rootLR = new TreeNode(2);
		rootLR.parent = rootL;
		
		rootR = new TreeNode(5);
		rootR.parent = root;
		
		rootRL = new TreeNode(4);
		rootRL.parent = rootR;
		rootRR = new TreeNode(6);
		rootRR.parent = rootR;

		root.left = rootL;
		root.right = rootR;
		rootL.left = rootLL;
		rootL.right = rootLR;
		rootR.left = rootRL;
		rootR.right = rootRR;
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testNormalFlow() {
		final ArrayList<ArrayList<Integer>> result = bstSeq.findBSTSequence(root);
		System.out.println("----------------------------------------");
		System.out.println("Normal Input");
		System.out.println("----------------------------------------");
		System.out.println("Result:");
		for(final ArrayList<Integer> resultArray: result) {
			for(final Integer a: resultArray){
				System.out.print(a+",");
			}
			System.out.println();
		}
		
		final List<List<Integer>> expectedResult = new ArrayList();	
		expectedResult.add(Arrays.asList(3,1,5,0,2,4,6));
		expectedResult.add(Arrays.asList(3,1,5,0,2,6,4));
		expectedResult.add(Arrays.asList(3,1,5,0,4,2,6));
		expectedResult.add(Arrays.asList(3,1,5,0,4,6,2));
		expectedResult.add(Arrays.asList(3,1,5,0,6,4,2));
		expectedResult.add(Arrays.asList(3,1,5,0,6,2,4));
		expectedResult.add(Arrays.asList(3,1,5,2,0,4,6));
		expectedResult.add(Arrays.asList(3,1,5,2,0,6,4));
		expectedResult.add(Arrays.asList(3,1,5,2,4,0,6));
		expectedResult.add(Arrays.asList(3,1,5,2,4,6,0));
		expectedResult.add(Arrays.asList(3,1,5,2,6,4,0));
		expectedResult.add(Arrays.asList(3,1,5,2,6,0,4));
		expectedResult.add(Arrays.asList(3,1,5,4,2,0,6));
		expectedResult.add(Arrays.asList(3,1,5,4,2,6,0));
		expectedResult.add(Arrays.asList(3,1,5,4,0,2,6));
		expectedResult.add(Arrays.asList(3,1,5,4,0,6,2));
		expectedResult.add(Arrays.asList(3,1,5,4,6,0,2));
		expectedResult.add(Arrays.asList(3,1,5,4,6,2,0));
		expectedResult.add(Arrays.asList(3,1,5,6,2,4,0));
		expectedResult.add(Arrays.asList(3,1,5,6,2,0,4));
		expectedResult.add(Arrays.asList(3,1,5,6,4,2,0));
		expectedResult.add(Arrays.asList(3,1,5,6,4,0,2));
		expectedResult.add(Arrays.asList(3,1,5,6,0,4,2));
		expectedResult.add(Arrays.asList(3,1,5,6,0,2,4));
		expectedResult.add(Arrays.asList(3,5,1,0,2,4,6));
		expectedResult.add(Arrays.asList(3,5,1,0,2,6,4));
		expectedResult.add(Arrays.asList(3,5,1,0,4,2,6));
		expectedResult.add(Arrays.asList(3,5,1,0,4,6,2));
		expectedResult.add(Arrays.asList(3,5,1,0,6,4,2));
		expectedResult.add(Arrays.asList(3,5,1,0,6,2,4));
		expectedResult.add(Arrays.asList(3,5,1,2,0,4,6));
		expectedResult.add(Arrays.asList(3,5,1,2,0,6,4));
		expectedResult.add(Arrays.asList(3,5,1,2,4,0,6));
		expectedResult.add(Arrays.asList(3,5,1,2,4,6,0));
		expectedResult.add(Arrays.asList(3,5,1,2,6,4,0));
		expectedResult.add(Arrays.asList(3,5,1,2,6,0,4));
		expectedResult.add(Arrays.asList(3,5,1,4,2,0,6));
		expectedResult.add(Arrays.asList(3,5,1,4,2,6,0));
		expectedResult.add(Arrays.asList(3,5,1,4,0,2,6));
		expectedResult.add(Arrays.asList(3,5,1,4,0,6,2));
		expectedResult.add(Arrays.asList(3,5,1,4,6,0,2));
		expectedResult.add(Arrays.asList(3,5,1,4,6,2,0));
		expectedResult.add(Arrays.asList(3,5,1,6,2,4,0));
		expectedResult.add(Arrays.asList(3,5,1,6,2,0,4));
		expectedResult.add(Arrays.asList(3,5,1,6,4,2,0));
		expectedResult.add(Arrays.asList(3,5,1,6,4,0,2));
		expectedResult.add(Arrays.asList(3,5,1,6,0,4,2));
		expectedResult.add(Arrays.asList(3,5,1,6,0,2,4));
		
		assertEquals(expectedResult, result);	
	}

	@Test
	public void testNullInput(){
		final ArrayList<ArrayList<Integer>> result = bstSeq.findBSTSequence(null);
		
		System.out.println("----------------------------------------");
		System.out.println("Null Input");
		System.out.println("----------------------------------------");
		System.out.println("Result:"+result);
		
		assertEquals(null, null);
	}
	
}
