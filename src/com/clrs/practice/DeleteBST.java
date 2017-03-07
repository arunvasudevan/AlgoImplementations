package com.clrs.practice;

import com.datastruct.BSTNode;

public class DeleteBST {

	public BSTNode deleteNodeInBST(BSTNode root, BSTNode deleteNode){
		BSTNode newRoot = root;
		BSTNode parent =  null;
		while(newRoot != null && newRoot.data != deleteNode.data) {
			parent = newRoot;
			if(newRoot.data < deleteNode.data) {
				newRoot = newRoot.right; 
			} else if(newRoot.data > deleteNode.data) {
				newRoot = newRoot.left;
			}
		}
		
		if(newRoot == null) {
			return null;
		}
		
		
		// No Child Node
		if(newRoot.left == null && newRoot.right == null) {
			if(parent.left == newRoot) {
				parent.left = null;
			} else {
				parent.right = null;
			}
		}
		
		// One child
		if((newRoot.left == null && newRoot.right!= null) ||  
		(newRoot.right == null && newRoot.left!= null)) {
			if(parent.left == newRoot) {
				if(newRoot.left != null){
					parent.left = newRoot.left;
				} else if(newRoot.right != null){
					parent.left = newRoot.right;
				}
			} else {
				if(newRoot.left != null){
					parent.left = newRoot.left;
				} else if(newRoot.right != null){
					parent.left = newRoot.right;
				}
			}
		}
		
		// Both the child
		if(newRoot.left != null && newRoot.right != null) {
			final BSTNode newNode = findMinimum (newRoot.right);
						
			newRoot = deleteNodeInBST(newRoot, newNode);
			
			if(parent != null) {
				if(parent.left == newRoot) {
					parent.left = newNode;
				} else {
					parent.right = newNode;
				}
			} else {
				root = newNode;
			}
			
			newNode.left = newRoot.left;
			newNode.right = newRoot.right;
		}
		return root;	
	}
	
	BSTNode findMinimum(BSTNode node){
		if(node.left == null){
			return node;
		} 
		BSTNode miniNode = node.left;
		while(miniNode.left != null){
			miniNode = miniNode.left;
		}
		return miniNode;
	}
}
