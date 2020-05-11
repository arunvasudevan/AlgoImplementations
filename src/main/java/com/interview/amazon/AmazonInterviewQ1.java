package com.interview.amazon;

/*
Find the largest fraction in a given array -
Fraction can be obtained by dividing one number in the array by any other number
for example - [5, 2, 3] => 2.5
*/

public class AmazonInterviewQ1 {

    public static void main(String[] args) {
        AmazonInterviewQ1 a = new AmazonInterviewQ1();
        int[] ar = new int[] { 5, 2, 3 };
        System.out.println("Largest fraction :" + a.largestFraction(ar));

    }

    double largestFraction(int[] ar) {
        int max = 0;
        double min = Integer.MAX_VALUE;
        for (int i = 0; i < ar.length; i++) {
            if (ar[i] != 0) {
                max = Math.max(ar[i], max);
                min = Math.min(ar[i], min);
            }
        }
        return max / min;
    }
}
