package com.homeaway;

/**
 *  Question : For supplied, long number, find whether it is a palindrome. Note, the solution for this using character
 *  array approach is very simple. The candidate needs to come up with a solution that involves only numeric calculation.
 */

public class IsNumberPalindrome {

//    public static void main(String[] args) {
//        long number = 234565432L;
//
//        System.out.println(String.format("Number %s is %s", number, isPalindrome(number)));
//    }


    public static boolean isPalindrome(long number) {
        long reverse = 0;
        long digits = 10;
        long originalNumber = number;
        while(number/10 > 1){
            reverse= (reverse*digits) + (number%10);
            number= number/10;
        }

        reverse = (reverse*digits) + (number%10);

        if(reverse == originalNumber) {
            return true;
        }

        return false;
    }

}
