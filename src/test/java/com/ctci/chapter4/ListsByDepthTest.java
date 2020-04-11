package com.ctci.chapter4;

import java.util.ArrayList;
import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;

import com.datastruct.TreeNode;

//Problem Statement: Given a Binary Tree return a linked list for each depth. 
//For Ex: A Tree with a depth of D should return D linkedLists


public class ListsByDepthTest {
	TreeNode n1,n2,n3,n4,n5,n6,n7,n8;
	
	@Before
	public void setUp() throws Exception {
		n4=new TreeNode(1);
		n5=new TreeNode(3);
		n2=new TreeNode(2);
		n1=new TreeNode(1);
		n3=new TreeNode(4);
		n6=new TreeNode(6);
		n7=new TreeNode(7);
		n8=new TreeNode(5);
		
		n2.right=n3;
		n4.left=n2;
		n4.right=n5;
		n5.left=n6;
		n5.right=n7;
		n3.left=n8;
	}

	@Test
	public void test() {
		final ListsByDepth l=new ListsByDepth();
		final ArrayList<LinkedList<TreeNode>> arr=l.BFS(n4);
		/*int i=1;
		for(final LinkedList<TreeNode> list:arr){
			System.out.println();
			System.out.println("Linked List:"+i++);
			while(!list.isEmpty()){
				final TreeNode u=list.remove();
				System.out.println("Data:"+u.data);	
			}
		}*/
	}

}
