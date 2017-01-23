package com.ctci.chapter4;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.datastruct.BSTNode;

//Write an algorithms to find the next node (i.e. in-order successor) of a given node in a 
//BST. You may assume that each node has a link to its parent.

public class TestSuccessorNode {
	
	BSTNode n1,n2,n3,n4,n5,n6,n7;
	successorNode nextNode;
	
	@Before
	public void setUp() throws Exception{
		nextNode=new successorNode();
		
		// Build the BST
		n1=new BSTNode(4);
		n2=new BSTNode(2);
		n3=new BSTNode(1);
		n4=new BSTNode(3);
		n5=new BSTNode(5);
		n6=new BSTNode(6);
		n7=new BSTNode(7);
		
		
		n1.parent=null;
		n1.left=n2;
		n1.right=n6;
		
		n2.parent=n1;
		n2.left=n3;
		n2.right=n4;
		
		n3.parent=n2;
		
		n4.parent=n2;
		
		n6.parent=n1;
		n6.left=n5;
		n6.right=n7;
		
		n5.parent=n6;
		
		n7.parent=n6;
	}

	@Test
	public void testRightNodeSuccessor() {
		BSTNode n=nextNode.findSuccessor(n6);
		
		if(n!=null)
			System.out.println("Successor Node of:"+n6.data+" is:"+n.data);
		else
			System.out.println("Successor Node of:"+n6.data+" is:"+n);
		
		assertEquals(n7, n);
	}
	
	@Test
	public void testEndOfTree(){
		BSTNode n=nextNode.findSuccessor(n7);
		
		if(n!=null)
			System.out.println("Successor Node of:"+n7.data+" is:"+n.data);
		else
			System.out.println("Successor Node of:"+n7.data+" is:"+n);
		
		assertEquals(null, n);
	}
	
	@Test
	public void testParentNodeSuccessor(){
		BSTNode n=nextNode.findSuccessor(n4);
		
		if(n!=null)
			System.out.println("Successor Node of:"+n4.data+" is:"+n.data);
		else
			System.out.println("Successor Node of:"+n4.data+" is:"+n);
		
		assertEquals(n1, n);
	}
	
	@Test
	public void testRootNodeSuccessor(){
		BSTNode n=nextNode.findSuccessor(n1);
		
		if(n!=null)
			System.out.println("Successor Node of:"+n1.data+" is:"+n.data);
		else
			System.out.println("Successor Node of:"+n1.data+" is:"+n);
		
		assertEquals(n5, n);
	}

	
	@Test
	public void testLeftNodeSuccessor(){
		BSTNode n=nextNode.findSuccessor(n3);
		
		if(n!=null)
			System.out.println("Successor Node of:"+n3.data+" is:"+n.data);
		else
			System.out.println("Successor Node of:"+n3.data+" is:"+n);
		
		assertEquals(n2, n);
	}
	
	@Test
	public void testNullInputNode(){
		BSTNode n=nextNode.findSuccessor(null);
		
		if(n!=null)
			System.out.println("Successor Node of:"+null+" is:"+n.data);
		else
			System.out.println("Successor Node of:"+null+" is:"+n);
		
		assertEquals(null, n);
	}
}
