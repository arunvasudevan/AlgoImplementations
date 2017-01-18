package com.datastruct;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import com.datastruct.TreeNode;
import com.datastruct.arraytoBST;

public class TestArraytoBST {

	public static void main(String[] args) {
		
		if(args.length==0){
			System.out.println("Please input the size of the input array");
			System.exit(0);
		}
		
		final int inputSize=Integer.parseInt(args[0]);
		final arraytoBST a=new arraytoBST();
		
		final ArrayList<Integer> arr=new ArrayList<>();
		final Random rand=new Random();
		for(int i=0;i<inputSize;i++){
			arr.add(rand.nextInt(100));
		}
		
		Collections.sort(arr);		
		final TreeNode root=a.converttoBST(arr);
		
		final TestArraytoBST t=new TestArraytoBST();
		t.depthFirstTraversal(root);
	}

	public void depthFirstTraversal(TreeNode n){
		
		if(n==null)
			return;
		
		depthFirstTraversal(n.left);
		System.out.println(n.data);
		depthFirstTraversal(n.right);
	}
}
