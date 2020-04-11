package com.leetcode;

/*
 * Problem Statement:
 * Say you have an array for which the ith element is the price of a given stock on day i.

If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.

Example 1:
Input: [7, 1, 5, 3, 6, 4]
Output: 5

max. difference = 6-1 = 5 (not 7-1 = 6, as selling price needs to be larger than buying price)
Example 2:
Input: [7, 6, 4, 3, 1]
Output: 0

In this case, no transaction is done, i.e. max profit = 0.
 * 
 */

public class MaxProfit {

	public int maxProfit(int[] prices) {
        int min=0, profit =0, maxProfit=0;
        if(prices.length > 1) {
            min = prices[0];
            for(int i=1; i<prices.length; i++) {
                profit = prices[i] - min;
                
                if(profit > maxProfit) {
                    maxProfit = profit;
                } else if (profit < 0 && prices[i] < min) {
                    min = prices[i];
                }
            }
        }
        return maxProfit;
    }
	public static void main(String[] args) {
		final int[] input = {7, 1, 5, 3, 6, 4};
		final MaxProfit m = new MaxProfit();
		System.out.println("Max Profit:"+m.maxProfit(input));
	}
}
