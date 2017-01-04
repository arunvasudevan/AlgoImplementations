package com.datastruct;

public class TestRouteBetweenNodes {

	public static void main(String[] args) {
		routeBetweenNodes r=new routeBetweenNodes();
		GraphNode n1=new GraphNode(1,false);
		System.out.println("N1 Visited:"+n1.getVisitedFlag());
		GraphNode n2=new GraphNode(2,false);
		System.out.println("N2 Visited:"+n2.getVisitedFlag());
		GraphNode n3=new GraphNode(3,false);
		System.out.println("N3 Visited:"+n3.getVisitedFlag());
		
		GraphNode n4=new GraphNode(4,false);
		//n2.addChild(null);
		//n3.addChild(null);
		//n1.addChild(n2);
		//n1.addChild(n3);
		
		
		
		GraphNode n5=new GraphNode(5,false);
		GraphNode n6=new GraphNode(6,false);
		
		n4.addChild(n5);
		n4.addChild(n6);
		
		n1.addChild(n4);
		//n5.addChild(null);
		//n6.addChild(null);
		
		
		System.out.println("Is there a route between n1 and n4: "+r.search(n1, n4));

	}

}
