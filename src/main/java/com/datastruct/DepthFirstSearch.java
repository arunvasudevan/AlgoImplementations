package com.datastruct;

public class DepthFirstSearch {

	public static void main(String[] args) {
		final TreeNode root=new TreeNode(3);
		final TreeNode d1l=new TreeNode(1);
		root.left=d1l;
		final TreeNode d1r=new TreeNode(5);
		root.right=d1r;
		
		final TreeNode d2l=new TreeNode(0);
		d1l.left=d2l;
		final TreeNode d2r=new TreeNode(2);
		d1l.right=d2r;
		d2r.left=d2r.right=d2l.left=d2l.right=null;
		final TreeNode d2rl=new TreeNode(4);
		d1r.left=d2rl;
		final TreeNode d2rr=new TreeNode(6);
		d1r.right=d2rr;
		d2rl.left=d2rl.right=d2rr.left=d2rr.right=null;
		
		final DepthFirstSearch DFS=new DepthFirstSearch();
		DFS.DFSearch(root);
	}
	
void DFSearch(TreeNode root){
		if (root==null)
				return;
		
			DFSearch(root.left);
			System.out.println(root.data);
			DFSearch(root.right);
		
	}
	
}
