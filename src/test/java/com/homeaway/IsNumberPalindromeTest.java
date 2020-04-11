package com.homeaway;

import org.junit.Assert;
import org.junit.Test;

public class IsNumberPalindromeTest {

    @Test
    public void testPalindrome(){
        long number = 234565432L;
        Assert.assertTrue(IsNumberPalindrome.isPalindrome(number));
    }

    @Test
    public void testFalseCondition(){
        long number = 23456543L;
        Assert.assertFalse(IsNumberPalindrome.isPalindrome(number));
    }

    @Test
    public void testSingleDigit(){
        long number = 2L;
        Assert.assertTrue(IsNumberPalindrome.isPalindrome(number));
    }

    @Test
    public void testPerfectDivisible(){
        long number = 10L;
        Assert.assertFalse(IsNumberPalindrome.isPalindrome(number));
    }
}
