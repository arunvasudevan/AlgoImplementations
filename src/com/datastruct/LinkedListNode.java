package com.datastruct;

public class LinkedListNode {
	int data;
	LinkedListNode next=null;
	
	public LinkedListNode(int d) {
		data=d;
	}
	
	public void appendToTail(int d){
		LinkedListNode n=new LinkedListNode(d);
		LinkedListNode current=this;
		
		while(current.next!=null){
			current=current.next;
		}
		current.next=n;
	}

}
