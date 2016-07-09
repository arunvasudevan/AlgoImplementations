package src.com.datastruct;

class LinkedListIntersection{
	Node intersectingLinkedList(Node a, Node b){

		if(a==null || b==null)
			return null;

		Result r1=getTailandLength(a);
		Result r2=getTailandLength(b);

		if(r1.tail!=r2.tail)
			return null;

		Node longer=(r1.length > r2.length) ? r1.tail : r2.tail;
		Node shorter = (r1.length < r2.length) ? r1.tail : r2.tail;

		longer=moveLongerIndex(longer,Math.abs(r1.length-r2.length));

		while(longer!=null){
			if(longer==shorter)
				return longer;

			longer=longer.next;
			shorter=shorter.next;
		}
		return null;
	}

	Node moveLongerIndex(Node longer,int k){
		while(k>0){
			longer=longer.next;
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
			localHead=localHead.next;
		}
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
}
