package com.leetcode;

import java.util.Stack;

/*
 * Given a string and an integer k, you need to reverse the first k characters for every 2k characters counting 
 * from the start of the string. If there are less than k characters left, reverse all of them. 
 * If there are less than 2k but greater than or equal to k characters, 
 * then reverse the first k characters and left the other as original.

 Example:
 Input: s = "abcdefg", k = 2
 Output: "bacdfeg"
 
 Restrictions:
 The string consists of lower English letters only.
 Length of the given string and k will in the range [1, 10000]
 
 */

public class ReverseString {

	public static void main(String[] args) {
		ReverseString s = new ReverseString();
		System.out.println(s.reverseStr("abcdefg", 2));

	}

	public String reverseStr(String s, int k) {
		StringBuffer result = new StringBuffer();
		Stack<Character> sBuffer = new Stack<Character>();
		for (int i = 0; i < s.length(); i++) {

			if ((i % (2 * k)) < k) {
				sBuffer.push(s.charAt(i));
			} else {
				while (!sBuffer.isEmpty()) {
					result.append(sBuffer.pop().charValue());
				}
				result.append(s.charAt(i));
			}
		}

		while (!sBuffer.isEmpty()) {
			result.append(sBuffer.pop());
		}

		return result.toString();
	}
}
