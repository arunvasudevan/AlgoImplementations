package com.ctci.chapter4;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.datastruct.*;

public class CommonAncestorTest{
	
	TreeNode root, rootL, rootR, rootLL, rootLR, rootRR, rootRL;
	CommonAncestor ca;
	
	@Before
	public void setUp() throws Exception{
		ca = new CommonAncestor();
		root = new TreeNode(3);	
		
		rootL = new TreeNode(1);
		
		rootLL = new TreeNode(0);
		rootLR = new TreeNode(2);
		
		rootR = new TreeNode(5);
		
		rootRL = new TreeNode(4);
		rootRR = new TreeNode(6);	
		
		root.left = rootL;
		root.right = rootR;

		rootL.left = rootLL;
		rootL.right = rootLR;

		rootR.left = rootRL;
		rootR.right = rootRR;
	}

	@Test
	public void test() {
		ca.findCommonAncestor(root, rootRL, rootLR);
	}

}
