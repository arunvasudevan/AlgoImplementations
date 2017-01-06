package src.com.datastruct;

import java.util.LinkedList;


// Test class List of Depths
public class TestListofDepths {

	public static void main(String[] args) {
		final TreeNode n4=new TreeNode(4);
		final TreeNode n5=new TreeNode(5);
		final TreeNode n2=new TreeNode(2);
		final TreeNode n1=new TreeNode(1);
		final TreeNode n3=new TreeNode(3);

		n2.left=n1;
		n2.right=n3;
		n4.left=n2;
		n4.right=n5;
		
		final listofDepths l=new listofDepths();
		final LinkedList<TreeNode>[] arr=l.BFS(n4);
		int i=1;
		for(final LinkedList<TreeNode> list:arr){
			System.out.println();
			System.out.println("Linked List:"+i++);
			while(!list.isEmpty()){
				final TreeNode u=list.remove();
				System.out.println("Depth: "+u.depth+" ,Data:"+u.data);	
			}
		}
	}

}
