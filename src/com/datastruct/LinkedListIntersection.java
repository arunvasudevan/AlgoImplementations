package src.com.datastruct;

/* Given 2 Singly Linked Lists, determine if the two lists intersect
 Cracking the Coding Interview Problem 2.7*/
class LinkedListIntersection{
	Node intersectingLinkedList(Node a, Node b){

		if(a==null || b==null)
			return null;

		Result r1=getTailandLength(a);
		Result r2=getTailandLength(b);

		if(r1.tail!=r2.tail)
			return null;

		Node longer=(r1.length > r2.length) ? a : b;
		Node shorter = (r1.length < r2.length) ? a : b;

		longer=moveLongerIndex(longer,Math.abs(r1.length-r2.length));

		while(longer!=null){
			if(longer==shorter)
				return longer;

			longer=longer.getNext();
			shorter=shorter.getNext();
		}
		return null;
	}

	Node moveLongerIndex(Node longer,int k){
		while(k>0){
			longer=longer.getNext();
			k--;
		}
		return longer;
	}
	public Result getTailandLength(Node n){
		Node tail=null;
		Node localHead=n;
		int length=0;
		while(localHead!=null){
			length++;
			tail=localHead;
			localHead=localHead.getNext();
		}
		//System.out.println("Length:"+length+ " Tail:"+tail.getData());
		return new Result(tail,length);
	}

	class Result {
	    int length=0;
	    Node tail=null;

	    public Result(Node n,int l){
	    	length=l;
	    	tail=n;
	    }
	}
	
	public static void main(String[] args){
		LinkedListIntersection ll=new LinkedListIntersection();
		Node n1=new Node(8);
		Node n2=new Node(7);
		Node n3=new Node(6);
		Node n4=new Node(5);
		Node n5=new Node(4);
		Node n6=new Node(3);
		
		n1.setNext(n2);
		n2.setNext(n3);
		n3.setNext(n4);
		n4.setNext(n5);
		n5.setNext(n6);
		n6.setNext(null);
		
		Node b1=new Node(16);
		Node b2=new Node(15);
		
		b1.setNext(b2);
		b2.setNext(n4);
		
		Node copyN1=n1;
		Node copyB1=b1;
		
		System.out.print("Input A: ");
		while(copyN1!=null){
			System.out.print(copyN1.getData()+"-->");
			copyN1=copyN1.getNext();
		}
		System.out.println("null");
		System.out.print("Input B: ");
		while(copyB1!=null){
			System.out.print(copyB1.getData()+"-->");
			copyB1=copyB1.getNext();
		}
		System.out.println("null");
		System.out.println("Intersected List is: "+ll.intersectingLinkedList(n1, b1).getData());
	}
}
