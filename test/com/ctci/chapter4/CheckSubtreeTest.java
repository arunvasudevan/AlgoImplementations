package com.ctci.chapter4;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.datastruct.TreeNode;

/*
 * Problem Statement:
 * Check Subtree: T1 and T2 are two very large binary trees, with T1 much bigger than T2. Create an algorithm 
 * to determine if T2 is a subtree of T1.
 * 
 * A tree T2 is a subtree of T1 if there exists a node n in T1 such that the subtree of n is identical to T2.
 * That is, if you cut off the tree at node n, the two trees would be identical.
 */

public class CheckSubtreeTest {
	
	TreeNode rootT1, rootL, rootR, rootLL, rootLR, rootRR, rootRL;
	CheckSubtree checkSubTree;

	@Before
	public void setUp() throws Exception {
		checkSubTree = new CheckSubtree();
		
		rootT1 = new TreeNode(3);		
		rootL = new TreeNode(1);
		rootLL = new TreeNode(0);
		rootLR = new TreeNode(2);
		rootR = new TreeNode(5);
		rootRL = new TreeNode(4);
		rootRR = new TreeNode(6);

		rootT1.left = rootL;
		rootT1.right = rootR;
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
		boolean expectedResult = checkSubTree.compareSubtree(rootT1, rootR);
		System.out.println("Is T1 a Subtree of T2:"+expectedResult);
		
		assertEquals(true, expectedResult);
	}

}
