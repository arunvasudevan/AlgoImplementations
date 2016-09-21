package com.datastruct;

/*==========================
Merge two arrays -
Given two sorted arrays, merge them together to form a third array which is also sorted

[1, 4, 6] and [3, 7] => [1, 3, 4, 6, 7]
[3,  5] and [2, 6, 8] => [2, 3, 5, 6, 8]

*/

public class AmazonInterviewQ2 {

	public static void main(String[] args) {
		AmazonInterviewQ2 a2=new AmazonInterviewQ2();
		
		int[] a=new int[]{1,4,6};
		int[] b=new int[]{3,7};
		int[] result=a2.mergeSortedArray(a, b);
		
		for(int i:result)
			System.out.println(i);
	}
	
	int[] mergeSortedArray(int[] a1, int[] a2){
	    int[] result=new int[a1.length+a2.length];
	    int i=0,j=0,k=0;
	    
	    while(i<a1.length && j<a2.length){     
	        if (a1[i]<a2[j]){
	        	result[k++]=a1[i++];
	        }
	        else if(a1[i]>a2[j]){
	        	result[k++]=a2[j++];
	           }
	        else if(a1[i]==a2[j]){
	        	result[k++]=a2[j++];
	           i++;
	        }    
	    }  
	    while(j<a2.length){
	    	result[k++]=a2[j++];
         }
	    
        while(i<a1.length){
        	result[k++]=a2[i++];
         }  
	    return result;
	}
}
