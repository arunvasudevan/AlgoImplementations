package src.com.datastruct;

import java.util.ArrayList;
import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;

public class TestlistsByDepth {
	TreeNode n4;
	TreeNode n5;
	TreeNode n2;
	TreeNode n1;
	TreeNode n3;
	
	@Before
	public void setUp() throws Exception {
		n4=new TreeNode(4);
		n5=new TreeNode(5);
		n2=new TreeNode(2);
		n1=new TreeNode(1);
		n3=new TreeNode(3);
		
		n2.left=n1;
		n2.right=n3;
		n4.left=n2;
		n4.right=n5;
	}

	@Test
	public void test() {
		final listsByDepth l=new listsByDepth();
		final ArrayList<LinkedList<TreeNode>> arr=l.BFS(n4);
		int i=1;
		for(final LinkedList<TreeNode> list:arr){
			System.out.println();
			System.out.println("Linked List:"+i++);
			while(!list.isEmpty()){
				final TreeNode u=list.remove();
				System.out.println("Data:"+u.data);	
			}
		}
	}

}
