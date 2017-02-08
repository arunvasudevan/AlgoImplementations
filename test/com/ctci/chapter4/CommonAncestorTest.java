package com.ctci.chapter4;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.datastruct.TreeNode;

public class CommonAncestorTest {

	TreeNode root, rootL, rootR, rootLL, rootLR, rootRR, rootRL;
	CommonAncestor ca;

	@Before
	public void setUp() throws Exception {
		ca = new CommonAncestor();
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

	@Test
	public void testSameLevels() {
		System.out.println("----------------------------");
		System.out.println("Same Levels");
		System.out.println("----------------------------");
		TreeNode result = ca.findCommonAncestor(root, rootRL, rootRR);
		System.out.println("Common Parent of "+rootRL.data+" and "+rootRR.data+" is : "+result.data);
		assertEquals(root, result);
	}

	@Test
	public void testDifferentLevels() {
		System.out.println("----------------------------");
		System.out.println("Different Levels");
		System.out.println("----------------------------");
		TreeNode result = ca.findCommonAncestor(root, rootR, rootLR);

		System.out.println("Common Parent of "+rootR.data+" and "+rootLR.data+" is : "+result.data);
		assertEquals(result, root);
	}

	@Test
	public void testInvalidNode() {
		System.out.println("----------------------------");
		System.out.println("Invalid Node");
		System.out.println("----------------------------");
		final TreeNode newNode = new TreeNode(9);
		TreeNode result = ca.findCommonAncestor(root, rootL, newNode);

		System.out.println("Common Parent is: "+result);
		assertEquals(result, null);
	}
}
