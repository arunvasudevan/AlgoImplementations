package com.clrs.practice;

import com.datastruct.*;

public class InsertBST {
	
	public void insertNodeInBST (BSTNode root, BSTNode newNode) {
		System.out.println("BST Before Insert:");
		printBSTInorder(root);
		System.out.println();
		BSTNode findLeaf = root;
		BSTNode parent = findLeaf;
		while (findLeaf != null) {
			parent = findLeaf;
			
			if(newNode.data <= findLeaf.data) {
				findLeaf = findLeaf.left;
			} else {
			    findLeaf = findLeaf.right;
			}
		}
		newNode.parent = parent;
		
		if(parent == null) { // If Tree is null
			root = newNode;
		}else if(newNode.data <= parent.data) {
			parent.left = newNode;
		} else {
			parent.right = newNode;
		}
		
		System.out.println("BST After Inserting:");
		printBSTInorder(root);
	}
	
	public void printBSTInorder(BSTNode root) {
		if(root != null) {
			printBSTInorder(root.left);
			
			System.out.print(root.data+",");
			
			printBSTInorder(root.right);
		}
	}
	
	public static void main(String[] args) {
		BSTNode root, rootL, rootR, rootLL, rootLR, rootRR, rootRL;
		
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
		rootR.left = rootRL;
		rootR.right = rootRR;
		
		
		InsertBST bstInsert = new InsertBST();
		bstInsert.insertNodeInBST(root, rootLR);
	}
}
