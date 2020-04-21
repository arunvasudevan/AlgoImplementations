package com.clrs.practice;

/**
 * Given a rod of length n inches and an array of prices that contains prices of all pieces of size smaller than n.
 * Determine the maximum value obtainable by cutting up the rod and selling the pieces.
 */

public class RodCutting {
    /**
     * @param prices
     * @param lengthOfRod
     * @return
     */
    public int maxProfitCutRod(int[] prices, int lengthOfRod) {
        int[] revenue = new int[lengthOfRod + 1];
        int q;
        for (int i = 1; i <= lengthOfRod; i++) {
            q = Integer.MIN_VALUE;
            for (int j = 1; j <= i; j++) {
                q = Math.max(q, prices[j] + revenue[i - j]);
            }
            revenue[i] = q;
        }
        return revenue[lengthOfRod];
    }
}
