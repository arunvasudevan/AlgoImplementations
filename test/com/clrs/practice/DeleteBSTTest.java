package com.clrs.practice;

import org.junit.Before;
import org.junit.Test;

import com.datastruct.BSTNode;

public class DeleteBSTTest {
	BSTNode root, rootL, rootR, rootLL, rootLR, rootRR, rootRL;
	DeleteBST deleteBST;
	
	@Before
	public void setUp() throws Exception {
		
		deleteBST = new DeleteBST();
		
		root = new BSTNode(3);		
		rootL = new BSTNode(1);
		rootL.parent = root;
		rootLL = new BSTNode(0);
		rootLL.parent = rootL;
		rootLR = new BSTNode(2);
		rootLR.parent = rootL;
		
		rootR = new BSTNode(5);
		rootR.parent = root;
		rootRL = new BSTNode(4);
		rootRL.parent = rootR;
		rootRR = new BSTNode(6);
		rootRR.parent = rootR;

		root.left = rootL;
		root.right = rootR;
		rootL.left = rootLL;
		rootL.right = rootLR;
		rootR.left = rootRL;
		rootR.right = rootRR;
	}
	
	@Test
	public void testDeleteAnyNode(){
		System.out.println();
		System.out.println("Before Delete");
		printBSTInorder(root);
		deleteBST.deleteNodeInBST(root, rootL);
		System.out.println();
		System.out.println("After Deleting: "+rootL.data);
		printBSTInorder(root);
		
		deleteBST.deleteNodeInBST(root, rootR);
		System.out.println();
		System.out.println("After Deleting: "+rootR.data);
		printBSTInorder(root);
		
		deleteBST.deleteNodeInBST(root, rootRL);
		System.out.println();
		System.out.println("After Deleting: "+rootRL.data);
		printBSTInorder(root);
	}
	
	@Test
	public void testDeleteRootNode(){
		System.out.println("Before Delete");
		printBSTInorder(root);
		System.out.println();
		System.out.println("After Deleting: "+root.data);
		root = deleteBST.deleteNodeInBST(root, root);
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
