package com.google.codejam2017;

import java.util.*;
import java.io.*;
import java.util.Stack;

class OversizePancakeFlipper {
	public static void main(String[] args){
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt();
		try{
		PrintWriter writer = new PrintWriter("OversizePancakeFlipperOutput.txt", "UTF-8");
		for(int i=0; i < t; i++){
			String s = in.next();
			int k = in.nextInt();
			int flipCount = 0;
			int emptyStartCount = 0;
			Stack<Character> st = new Stack<Character>();
			boolean emptySide = false;
			for(char ch: s.toCharArray()){
				if(ch == '-') {
					emptySide = true;
				}
				if(emptySide) {
					++emptyStartCount;
				}
				st.push(ch);
				if (emptyStartCount == k) {	
					// flip
					++ flipCount;
					Stack<Character> flipStack = new Stack<Character>();
					for(int j = emptyStartCount; j > 0; j--) {
						char oldChar = st.pop();
						char newChar;
						if(oldChar == '-')
							newChar = '+';
						else
							newChar = '-';
						flipStack.push(newChar);
					}
					emptyStartCount = 0; 
					emptySide = false;
					while(flipStack.size() > 0){
						char flippedChar = flipStack.pop();
						if(flippedChar == '-')
							emptySide = true;
						if(emptySide)
							emptyStartCount++;
						st.push(flippedChar);
					}	
				}
					
			}
			if(emptyStartCount == 0){
			//	System.out.println("Case #"+ (i+1) +": "+flipCount);
				writer.println("Case #"+ (i+1) +": "+flipCount);
			}
			else {
			//	System.out.println("Case #"+ (i+1) +": IMPOSSIBLE");
				writer.println("Case #"+ (i+1) +": IMPOSSIBLE");
			}
		}
	writer.close();
	in.close();
	} catch(Exception e) {
		System.out.println("Exception in writing to the file");
	}		
	}
}
