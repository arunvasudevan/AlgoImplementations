package com.ctci.chapter4;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.datastruct.TreeNode;

/* Problem Statement:
 * Find a Common Ancestor for 2 given nodes in a Binary Tree
 */

public class CommonAncestorTest {

	TreeNode root, rootL, rootR, rootLL, rootLR, rootRR, rootRL;
	CommonAncestor ca;
	CommonAncestorNoParent caNoParent;

	@Before
	public void setUp() throws Exception {
		ca = new CommonAncestor();
		caNoParent = new CommonAncestorNoParent();
		
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
		final TreeNode result = ca.findCommonAncestor(root, rootRL, rootRR);
		final TreeNode resultNoParent = caNoParent.findCommonAncestor(root, rootRL, rootRR);
		System.out.println("Common Parent of "+rootRL.data+" and "+rootRR.data+" is : "+result.data);

		System.out.println("Common Parent (No Parent TreeNode) of "+rootRL.data+" and "+rootRR.data+" is : "+resultNoParent.data);
		assertEquals(rootR, result);
		assertEquals(rootR, resultNoParent);
	}

	@Test
	public void testDifferentLevels() {
		System.out.println("----------------------------");
		System.out.println("Different Levels");
		System.out.println("----------------------------");
		final TreeNode result = ca.findCommonAncestor(root, rootR, rootLR);
		final TreeNode resultNoParent = caNoParent.findCommonAncestor(root, rootR, rootLR);
		System.out.println("Common Parent of "+rootR.data+" and "+rootLR.data+" is : "+result.data);
		System.out.println("Common Parent (No Parent TreeNode) of "+rootR.data+" and "+rootLR.data+" is : "+resultNoParent.data);
		assertEquals(root, result);
		assertEquals(root, resultNoParent);
	}
	
	@Test
	public void testParentNodes() {
		System.out.println("----------------------------");
		System.out.println("One Node Parent of Another");
		System.out.println("----------------------------");
		final TreeNode result = ca.findCommonAncestor(root, rootL, rootLR);
		final TreeNode resultNoParent = caNoParent.findCommonAncestor(root, rootL, rootLR);
		System.out.println("Common Parent of "+rootL.data+" and "+rootLR.data+" is : "+result.data);

		System.out.println("Common Parent (No Parent TreeNode) of "+rootL.data+" and "+rootLR.data+" is : "+resultNoParent.data);
		assertEquals(rootL, result);
		assertEquals(rootL, resultNoParent);
	}
	
	@Test
	public void testRootNodes() {
		System.out.println("----------------------------");
		System.out.println("Return Root Node");
		System.out.println("----------------------------");
		final TreeNode result = ca.findCommonAncestor(root, rootL, rootR);
		final TreeNode resultNoParent = caNoParent.findCommonAncestor(root, rootL, rootR);
		System.out.println("Common Parent of "+rootL.data+" and "+rootR.data+" is : "+result.data);

		System.out.println("Common Parent (No Parent TreeNode) of "+rootL.data+" and "+rootR.data+" is : "+resultNoParent.data);
		assertEquals(root, result);
		assertEquals(root, resultNoParent);
	}
	
	@Test
	public void testNullNode() {
		System.out.println("----------------------------");
		System.out.println("Tes Null Node Input");
		System.out.println("----------------------------");
		final TreeNode result = ca.findCommonAncestor(null, null, null);

		final TreeNode resultNoParent = caNoParent.findCommonAncestor(null, null, null);
		System.out.println("Common Parent of null and null is: "+result);
		

		System.out.println("Common Parent (No Parent TreeNode) of "+null+" and "+null+" is : "+resultNoParent);
		assertEquals(null, result);

		assertEquals(null, resultNoParent);
	}

	@Test
	public void testInvalidNode() {
		System.out.println("----------------------------");
		System.out.println("Invalid Node");
		System.out.println("----------------------------");
		final TreeNode newNode = new TreeNode(9);
		final TreeNode result = ca.findCommonAncestor(root, rootL, newNode);

		final TreeNode resultNoParent = caNoParent.findCommonAncestor(root, rootL, newNode);
		System.out.println("Common Parent is: "+result);
		

		System.out.println("Common Parent (No Parent TreeNode) of "+rootR.data+" and "+rootLR.data+" is : "+resultNoParent);
		//assertEquals(null, result);

		assertEquals(null, resultNoParent);
	}
}
