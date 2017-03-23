package com.ctci.chapter1;

public class URLIfy {

	char[] convertToURL(char[] input, int length) {
		for(int i=0; i< length; i++) {
			if(input[i] == ' '){
				length = length + 2;
				input = copyCharArray(input, length, i);
				input[i] = '%';
				input[++i] = '2';
				input[i] = '0';
			}
		}
		return input;
	}

	char[] copyCharArray (char[] input, int length, int index){
		for(int i = length; i >= index; i++) {
			input[i] = input[i-2];
		}
		return input;
	}
	public static void main(String[] args) {
		URLIfy u = new URLIfy();
		String input = "Mr John Smith    ";
		u.convertToURL(input.toCharArray(), 9);

	}

}
