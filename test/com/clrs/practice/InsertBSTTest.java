package com.clrs.practice;

import org.junit.Before;
import org.junit.Test;

import com.datastruct.BSTNode;

public class InsertBSTTest {
	
	BSTNode root, rootL, rootR, rootLL, rootLR, rootRR, rootRL;
	InsertBST insertBST;
	DeleteBST deleteBST;
	
	@Before
	public void setUp() throws Exception {
		
		insertBST = new InsertBST();
		deleteBST = new DeleteBST();
		
		root = new BSTNode(3);		
		rootL = new BSTNode(1);
		rootL.parent = root;
		rootLL = new BSTNode(0);
		rootLL.parent = rootL;
		rootLR = new BSTNode(2);
		//rootLR.parent = rootL;
		
		rootR = new BSTNode(5);
		rootR.parent = root;
		rootRL = new BSTNode(4);
		rootRL.parent = rootR;
		rootRR = new BSTNode(6);
		rootRR.parent = rootR;

		root.left = rootL;
		root.right = rootR;
		rootL.left = rootLL;
		//rootL.right = rootLR;
		rootR.left = rootRL;
		rootR.right = rootRR;
	}
	
	@Test
	public void testNullTree() {
		System.out.println("----------------------------------------");
		System.out.println("Insert a Node in Null Tree");
		System.out.println("----------------------------------------");
		insertBST.insertNodeInBST(null, rootLR);
	}

	@Test
	public void testInsert() {
		System.out.println();
		System.out.println("----------------------------------------");
		System.out.println("Insert a Node in BST");
		System.out.println("----------------------------------------");
		insertBST.insertNodeInBST(root, rootLR);
		
		deleteBST.deleteNodeInBST(root, rootRL);
		System.out.println();
		System.out.println("Deleting node:"+rootRL.data);
		printBSTInorder(root);
	}

	
	public void printBSTInorder(BSTNode root) {
		if(root != null) {
			printBSTInorder(root.left);
			
			System.out.print(root.data+",");
			
			printBSTInorder(root.right);
		}
	}
}
