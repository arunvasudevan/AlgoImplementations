package com.datastruct;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.Stack;

/*  
 * Stacks of Plates 
 * Cracking the Coding Interview - Chapter 3 - Q-3_03  
 */

class stackArray{

ArrayList<Stack<Integer>> sa=new ArrayList<Stack<Integer>>();
Stack<Integer> s;
int stackCapacity;

public stackArray(int stackCapacity){
	this.stackCapacity=stackCapacity;
}

public stackArray(){
	final int default_stack_capacity=10;
	new stackArray(default_stack_capacity);
}

void push(int val){
	if(s==null){
		s=new Stack<Integer>();
		s.push(val);
		sa.add(s);
	}
	else{
	   if(s.size() == stackCapacity){
	   	s=new Stack<Integer>();
	   	s.push(val);
	   	sa.add(s);
	   }
	   else{
	   	s.add(val);
	   }
	}
}

public int pop() throws EmptyStackException{
	if(sa.isEmpty())
		throw new EmptyStackException();
	final int lastIdx=sa.size() -1;
	
	final Stack<Integer> tempStack=sa.get(lastIdx);
	
	if(tempStack.size() ==1)
		sa.remove(lastIdx);
	
	return tempStack.pop();
	
}

public static void main(String[] args){
	final int stackCapacity=10;
	final stackArray sc=new stackArray(stackCapacity);
	for(int i=0;i<22;i++){
		sc.push(i);
	}

	for(int i=0;i<3;i++){
		System.out.println(sc.pop());
	}
}

}
 