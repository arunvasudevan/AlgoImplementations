package com.leetcode;

public class PalindromePermutations{
	
	char[] unpairedcharacters=new char[]{' ','!','-','/',',','_'};
	 public static void main(String[] args){
	     final PalindromePermutations p=new PalindromePermutations();
	     if(p.palindromeCheck("A Man, A Plan, A Canal - Panama!"))
	        System.out.println("Its a Palindrome Permuatation");
	     else
	        System.out.println("Its not a palindrome Permutation");
	 }
	 
	 boolean palindromeCheck(String s){
		 s=s.toLowerCase();
	     final char[] charArray=s.toCharArray();
	     final int[] letters=new int[128];
	     
	     for(int i=0;i<s.length();i++){
	    	
	    	if(String.valueOf(unpairedcharacters).indexOf(charArray[i])>=0)
	    		 continue;
	         letters[charArray[i]]++;
	         System.out.println(charArray[i]+" "+(int)charArray[i]);
	     } 
	     int oddCount=0;
	     for(int j=0;j<128;j++){
	          if(letters[j]%2!=0)
	             oddCount++;
	     }
	     
	     if(oddCount>1)
	        return false;
	     else
	        return true;
	 }
	}
