package com.ctci.chapter1;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class CheckPermutationTest {
	CheckPermutation check;
	
	@Before
	public void setUp(){
		check = new CheckPermutation();
	}

	@Test
	public void positivePermutationTest(){
		System.out.println("---------------------------------------");
		System.out.println("Positive Permutation Test");
		System.out.println("---------------------------------------");
		final String s1 = "race";
		final String s2 = "care";
		final boolean result = check.checkPermuteString(s1, s2);
		System.out.println("Permuation of Strings "+s1+","+s2+ " is: "+result);
		
		assertEquals(true, result);
	}
	
	@Test
	public void negativePermutationTest(){
		System.out.println("---------------------------------------");
		System.out.println("Negative Permutation Test");
		System.out.println("---------------------------------------");
		final String s1 = "race";
		final String s2 = "caree";
		final boolean result = check.checkPermuteString(s1, s2);
		System.out.println("Permuation of Strings "+s1+","+s2+ " is: "+result);
		assertEquals(false, result);
	}
	
	@Test
	public void emptyStringTest(){
		System.out.println("---------------------------------------");
		System.out.println("Empty String Test");
		System.out.println("---------------------------------------");
		final String s1 = "race";
		final String s2 = "";
		final boolean result = check.checkPermuteString(s1, s2);
		System.out.println("Permuation of Strings "+s1+","+s2+ " is: "+result);
		assertEquals(false, result);
	}
}
