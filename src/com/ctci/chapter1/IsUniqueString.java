package com.ctci.chapter1;

/**
 * Implement an algorithms to determine if a string has all unique characters.
 * What if you cannot use additional data structure?
 */

public class IsUniqueString {

	public static void main(String[] args) {
		IsUniqueString isUniqueString = new IsUniqueString();
		String str= "uncopyrightable";
		System.out.printf("String %s has Unique characters: %s",str, isUniqueString.isUnique(str));
	}

	public boolean isUnique(String inputStr){
		boolean booleanArr[] = new boolean[128];

		for(int i=0; i<inputStr.length(); i++) {
			int var = inputStr.charAt(i);

			if(booleanArr[var]) {
				return false;
			}
			booleanArr[var] = true;
		}
		return true;
	}
}
