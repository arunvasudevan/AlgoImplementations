package com.ctci.chapter1;

import org.junit.Before;
import org.junit.Test;

public class URLIfyTest {
	URLIfy url;
	
	@Before
	public void setUp(){
		url = new URLIfy();
	}

	@Test
	public void normalTest(){
		System.out.println();
		System.out.println("---------------------------------------");
		System.out.println("Normal Test");
		System.out.println("---------------------------------------");
		final String input = "Mr John Smith    ";
		url.convertToURL(input.toCharArray(), 13);
	}
	
	@Test
	public void emptyString(){
		System.out.println();
		System.out.println("---------------------------------------");
		System.out.println("Empty String");
		System.out.println("---------------------------------------");
		
		final String input = " T  ";
		url.convertToURL(input.toCharArray(), 2);	
	}
}
