package com.ctci.chapter3;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.Stack;

/*  
 * Stacks of Plates 
 * Cracking the Coding Interview - Chapter 3 - Q-3_03  
 */

class StackArray{

ArrayList<Stack<Integer>> sa=new ArrayList<Stack<Integer>>();
Stack<Integer> s;
int stackCapacity;

public StackArray(int stackCapacity){
	this.stackCapacity=stackCapacity;
}

public StackArray(){
	final int default_stack_capacity=10;
	new StackArray(default_stack_capacity);
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
	final StackArray sc=new StackArray(stackCapacity);
	for(int i=0;i<22;i++){
		sc.push(i);
	}

	for(int i=0;i<3;i++){
		System.out.println(sc.pop());
	}
}

}
 