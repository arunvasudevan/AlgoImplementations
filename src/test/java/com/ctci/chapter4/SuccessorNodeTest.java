package com.ctci.chapter4;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.datastruct.BSTNode;
import com.datastruct.TreeNode;

//Write an algorithms to find the next node (i.e. in-order successor) of a given node in a 
//BST. You may assume that each node has a link to its parent.

public class SuccessorNodeTest {
	
	BSTNode rootAlt,n2a,n3a,n4a,n5a,n6a,n7a;
	TreeNode root,n2,n3,n4,n5,n6,n7;
	SuccessorNode nextNodeA;
	SuccessorNodewithNoParentLink nextNode;
	
	@Before
	public void setUp() throws Exception{
		nextNodeA=new SuccessorNode();
		nextNode = new SuccessorNodewithNoParentLink();
		
		// Build the BST
		rootAlt=new BSTNode(4);
		n2a=new BSTNode(2);
		n3a=new BSTNode(1);
		n4a=new BSTNode(3);
		n5a=new BSTNode(5);
		n6a=new BSTNode(6);
		n7a=new BSTNode(7);
		
		root=new TreeNode(4);
		n2=new TreeNode(2);
		n3=new TreeNode(1);
		n4=new TreeNode(3);
		n5=new TreeNode(5);
		n6=new TreeNode(6);
		n7=new TreeNode(7);
		
		
		rootAlt.parent=null;
		rootAlt.left=n2a;
		rootAlt.right=n6a;
		
		root.left=n2;
		root.right=n6;
		
		n2a.parent=rootAlt;
		n2a.left=n3a;
		n2a.right=n4a;
		
		n2.left=n3;
		n2.right=n4;
		
		n3a.parent=n2a;
		
		n4a.parent=n2a;
		
		n6a.parent=rootAlt;
		n6a.left=n5a;
		n6a.right=n7a;
		
		n6.left=n5;
		n6.right=n7;
		
		n5a.parent=n6a;
	
		n7a.parent=n6a;
	}

	
	@Test
	public void testRightNodeSuccessor() {
		final BSTNode nA=nextNodeA.findSuccessor(n6a);
		final TreeNode n=nextNode.successorNode(root, n6);
		
		if(n!=null && nA!=null){
			System.out.println("Successor Node of:"+n6.data+" is:"+n.data);
			System.out.println("Successor Node (No Parent Link) of:"+n6a.data+" is:"+nA.data);
		}
		else{
			System.out.println("Successor Node of:"+n6.data+" is:"+n);
			System.out.println("Successor Node (No Parent Link) of:"+n6a.data+" is:"+nA);
		}
		
		assertEquals(n7, n);
		assertEquals(n7a, nA);
	}
	
	@Test
	public void testEndOfTree(){
		final BSTNode nA=nextNodeA.findSuccessor(n7a);
		final TreeNode n=nextNode.successorNode(root, n7);
		
		if(n!=null && nA!=null){
			System.out.println("Successor Node of:"+n7.data+" is:"+n.data);
			System.out.println("Successor Node (No Parent Link) of:"+n7a.data+" is:"+nA.data);
		}
		else{
			System.out.println("Successor Node of:"+n7.data+" is:"+n);
			System.out.println("Successor Node (No Parent Link) of:"+n7a.data+" is:"+nA);
		}
		
		assertEquals(null, n);
		assertEquals(null, nA);
	}
	
	@Test
	public void testParentNodeSuccessor(){
		final BSTNode nA=nextNodeA.findSuccessor(n4a);
		final TreeNode n=nextNode.successorNode(root, n4);
		
		if(n!=null && nA!=null){
			System.out.println("Successor Node of:"+n4.data+" is:"+n.data);
			System.out.println("Successor Node (No Parent Link) of:"+n4a.data+" is:"+nA.data);
		}
		else{
			System.out.println("Successor Node of:"+n4.data+" is:"+n);
			System.out.println("Successor Node (No Parent Link) of:"+n4a.data+" is:"+nA);
		}
		
		assertEquals(root, n);
		assertEquals(rootAlt, nA);
	}
	
	@Test
	public void testRootNodeSuccessor(){
		final BSTNode nA=nextNodeA.findSuccessor(rootAlt);
		final TreeNode n=nextNode.successorNode(root, root);
		
		if(n!=null && nA!=null){
			System.out.println("Successor Node of:"+rootAlt.data+" is:"+n.data);
			System.out.println("Successor Node (No Parent Link) of:"+rootAlt.data+" is:"+nA.data);
		}
		else{
			System.out.println("Successor Node of:"+root.data+" is:"+n);
			System.out.println("Successor Node (No Parent Link) of:"+root.data+" is:"+nA);
		}
		
		assertEquals(n5, n);
		assertEquals(n5a, nA);
	}

	
	@Test
	public void testLeftNodeSuccessor(){
		final BSTNode nA=nextNodeA.findSuccessor(n3a);
		final TreeNode n=nextNode.successorNode(root, n3);
		
		if(n!=null && nA!=null){
			System.out.println("Successor Node of:"+n3.data+" is:"+n.data);
			System.out.println("Successor Node (No Parent Link) of:"+n3a.data+" is:"+nA.data);
		}
		else{
			System.out.println("Successor Node of:"+n3.data+" is:"+n);
			System.out.println("Successor Node (No Parent Link) of:"+n3a.data+" is:"+nA);
		}
		
		assertEquals(n2, n);
		assertEquals(n2a, nA);
	}
	
	@Test
	public void testNullInputNode(){
		final BSTNode nA=nextNodeA.findSuccessor(null);
		final TreeNode n=nextNode.successorNode(root, null);
		
		if(n!=null && nA!=null){
			System.out.println("Successor Node of:"+null+" is:"+n.data);
			System.out.println("Successor Node (No Parent Link) of:"+null+" is:"+nA.data);
		}
		else{
			System.out.println("Successor Node of:"+null+" is:"+n);
			System.out.println("Successor Node (No Parent Link) of:"+null+" is:"+nA);
		}
		
		assertEquals(null, n);
		assertEquals(null, nA);
	}
}
