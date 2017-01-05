package src.com.datastruct;

public class Graph {
	
	GraphNode[] vertices;
	int size;
	int count;
	
	public Graph(int size){
		this.size=size;
		vertices=new GraphNode[size];
	}
		
	GraphNode[] getNodes(){
		return vertices;
	}	
	
	public void addNode(GraphNode n){
		if(count<size)
			vertices[count++]=n;
		else
			System.out.println("Reached the size of the Graph");
	}	
}
