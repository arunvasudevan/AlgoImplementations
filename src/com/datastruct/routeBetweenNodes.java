package com.datastruct;

import java.util.LinkedList;
import java.util.Queue;

public class routeBetweenNodes {
	
	public boolean search(GraphNode n1, GraphNode n2){
		if(n1!=null && n2!=null){
			if(!findRoute(n1, n2)){
				return findRoute(n2,n1);
			}
			else
				return true;
		}
		return false;
	}
	
	public boolean findRoute(GraphNode n1, GraphNode n2){
		Queue<GraphNode> q=new LinkedList<GraphNode>();
		
		q.add(n1);
		n1.setVisitedFlag(true);
		
		while(!q.isEmpty()){
			GraphNode n=q.remove();
			if(n==n2)
				return true;
			for(GraphNode n3: n1.child){
				if(n3.getVisitedFlag()==false)
					q.add(n3);
			}
		}	
		return false;
	}

}
