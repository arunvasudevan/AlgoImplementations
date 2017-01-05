package src.com.datastruct;

public class TestRouteBetweenNodes {

	public static void main(String[] args) {
		final Graph g=new Graph(4);
		final GraphNode n1=new GraphNode(1, 2);
		final GraphNode n2=new GraphNode(2, 10);
		final GraphNode n3=new GraphNode(3, 19);
		final GraphNode n4=new GraphNode(4, 3);
		//final GraphNode n5=new GraphNode(5, 15);

		g.addNode(n1);
		g.addNode(n2);
		g.addNode(n3);
		g.addNode(n4);
		
		for(final GraphNode n:g.getNodes()){
			System.out.println("Available Nodes: "+n.name);
		}
		
		n1.addAdjacent(n2);
		n1.addAdjacent(n3);
		n1.addAdjacent(n4);
		n2.addAdjacent(n4);
		n4.addAdjacent(n3);
		
		final routeBetweenNodes r=new routeBetweenNodes();
		
		System.out.println(" Node n1 available in n3: "+r.search(n1, n4));
		
	}

}
