package com.ctci.chapter4;

import java.util.ArrayList;
import java.util.LinkedList;

import org.junit.Test;

import com.datastruct.TreeNode;
import com.datastruct.TreeNodeModified;

//Problem Statement: Given a Binary Tree return a linked list for each depth.
//For Ex: A Tree with a depth of D should return D linkedLists

// Test class List of Depths
public class ListofDepthsTest {

	@Test
    public void testWithoutChangeOfTreeProperty(){
        final ListofDepthsTest t=new ListofDepthsTest();
        System.out.println("Test Method1:");
        t.withoutChangeOfTreePropertyMethod();
    }

    @Test
    public void testWithChangeOfTreeProeprty(){
        final ListofDepthsTest t=new ListofDepthsTest();
        System.out.println("Test Method2:");
        t.changeOfTreePropertyMethod();
    }

	// w/o change of tree property
	void changeOfTreePropertyMethod(){

		final TreeNode n4=new TreeNode(4);
		final TreeNode n5=new TreeNode(5);
		final TreeNode n2=new TreeNode(2);
		final TreeNode n1=new TreeNode(1);
		final TreeNode n3=new TreeNode(3);

		n2.left=n1;
		n2.right=n3;
		n4.left=n2;
		n4.right=n5;

		final ListofDepth l=new ListofDepth();
		final ArrayList<LinkedList<TreeNode>> a=l.listofTreeDepth(n4, 0);
		int i=1;
		for(final LinkedList<TreeNode> temp:a){
			System.out.println("Depth:"+ i);
			while(!temp.isEmpty()){
				System.out.println("  Data:"+temp.remove().data);
			}
			i++;
		}
	}


	void withoutChangeOfTreePropertyMethod(){
		final TreeNodeModified n4=new TreeNodeModified(4);
		final TreeNodeModified n5=new TreeNodeModified(5);
		final TreeNodeModified n2=new TreeNodeModified(2);
		final TreeNodeModified n1=new TreeNodeModified(1);
		final TreeNodeModified n3=new TreeNodeModified(3);

		n2.left=n1;
		n2.right=n3;
		n4.left=n2;
		n4.right=n5;

		final ListofDepths l=new ListofDepths();
		final LinkedList<TreeNodeModified>[] arr=l.BFS(n4);
		int i=1;
		for(final LinkedList<TreeNodeModified> list:arr){
			System.out.println("Linked List:"+i++);
			while(!list.isEmpty()){
				final TreeNodeModified u=list.remove();
				System.out.println("  Depth: "+u.depth+" ,Data:"+u.data);
			}
		}
	}
}
