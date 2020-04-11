package com.ctci.chapter1;

public class URLIfy {

	public char[] convertToURL(char[] input, int length) {
		for(int i=0; i < input.length; i++) {
			if(input[i] == ' '){
				length = length + 2;
				input = copyCharArray(input, length - 1, i);
				input[i] = '%';
				input[++i] = '2';
				input[++i] = '0';
			}
		}
		System.out.print("URLified String: ");
		for(final char ch:input) {
			System.out.print(ch);
		}
		return input;
	}

	private char[] copyCharArray (char[] input, int length, int index){
		for(int i = length; i >= index && i > 1; i--) {
			input[i] = input[i-2];
		}
		return input;
	}
	/*public static void main(String[] args) {
		final URLIfy u = new URLIfy();
		final String input = "   ";
		u.convertToURL(input.toCharArray(), 1);

	}*/

}
