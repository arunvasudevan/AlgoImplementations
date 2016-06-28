package com.datastruct;

import java.util.HashSet;
import java.util.LinkedList;

public class RemoveDuplicates {

	public static void main(String[] args) {
		LinkedList<Integer> n=new LinkedList<Integer>();
		n.add(5);
		n.add(3);
		n.add(5);
		n.add(2);
		n.add(3);
		
		//for(int i=0;i<n.size();i++)
		//	System.out.println("Before: "+n.get(i));
		
		RemoveDuplicates r=new RemoveDuplicates();
		r.RemoveDups(n);
		
		for(int i=0;i<n.size();i++)
			System.out.println("After: "+n.get(i));
	}
	
	public void RemoveDups(LinkedList<Integer> n){
		HashSet<Integer> set=new HashSet<Integer>();
		LinkedList<Integer> previous=null;
		int j=0;
		for(int i=0;i<n.size();i++){
			
			if(set.contains(n.get(i))){
				previous.set(j, n.get(i));
				
				continue;
			}
			else{
				System.out.println("Else: "+n.get(i));
				set.add(n.get(i));
				previous=n;
				j++;
			}
		}
		
	}

}
