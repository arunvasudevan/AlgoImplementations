package com.datastruct;

public class LinkedListNode {
	Node head;
	Node tail;
	
	public void insert(int data){
		Node n=new Node(data);
		n.setNext(null);
		if(head==null){
			head=n;
			tail=n;
		}
		else{
			tail.setNext(n);
			tail=n;
		}
	}
	
	public void printList(){
		if(head==null)
			System.out.println("List is empty");
		else{
			Node temp=head;
			while(temp!=null){
				System.out.println(temp.getData());
				temp=temp.getNext();
			}
		}
			
	}
	

}
