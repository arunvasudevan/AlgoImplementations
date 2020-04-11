package com.datastruct;

public class LinkedListImpl {

	public static void main(String[] args) {
		LinkedListNode n=new LinkedListNode();
		for(int i=0;i<10;i=i+2){
			n.insert(i);
		}
		
		n.printList();

	}

}
