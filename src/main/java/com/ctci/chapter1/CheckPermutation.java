package com.ctci.chapter1;

import java.util.HashMap;
public class CheckPermutation {

	boolean checkPermuteString(String s1, String s2){
		if(s1.length() != s2.length()) {
			return false;
		}
		int permuteCount = 0;
		final HashMap<Character, Integer> charMap = new HashMap<Character, Integer>();
		
		for(int i=0; i< s1.length(); i++) {
			final char ch = s1.charAt(i);
			int count = 0;
			if(charMap.get(ch) != null){
				count = charMap.get(ch);
			}
			charMap.put(ch, ++count);
		}
		
		for(int j=0; j < s2.length(); j++) {
			final char ch2 = s2.charAt(j);
			if(charMap.get(ch2) != null) {
				int count = charMap.get(ch2);
				++permuteCount;
				if(count == 0){
					charMap.remove(ch2);
				} else {
					charMap.put(ch2, --count);
				}
			}
		}
		
		if(permuteCount == s1.length())
			return true;
			
		return false;
	}
	
	/*public static void main(String[] args){
		CheckPermutation check = new CheckPermutation();
		
		System.out.println(check.checkPermuteString("race", "caree"));
	}*/
}
