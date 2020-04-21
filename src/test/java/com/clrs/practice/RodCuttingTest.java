package com.clrs.practice;

import org.junit.Assert;
import org.junit.Test;

/**
 * Tests for Rod Cutting Class
 */

public class RodCuttingTest {
    //Prices for rods upto length 10
    int[] prices = new int[]{0,1,5,8,9,10,17,17,20,24,30};

    @Test
    public void testRodLengthFour(){
        RodCutting rodCutting= new RodCutting();
        int lengthOfRod = 4;
        int maxProfitCutRod = rodCutting.maxProfitCutRod(prices, lengthOfRod);
        System.out.printf("Maximum Profit for length of rod %d is %d", lengthOfRod, maxProfitCutRod);
        Assert.assertEquals(10, maxProfitCutRod);
    }

    @Test
    public void testRodLengthZero(){
        RodCutting rodCutting= new RodCutting();
        int lengthOfRod=0;
        int maxProfitCutRod = rodCutting.maxProfitCutRod(prices, lengthOfRod);
        System.out.printf("Maximum Profit for length of rod %d is %d", lengthOfRod, maxProfitCutRod);
        Assert.assertEquals(0, maxProfitCutRod);
    }

    @Test
    public void testRodLengthSeven(){
        RodCutting rodCutting= new RodCutting();
        int lengthOfRod = 7;
        int maxProfitCutRod = rodCutting.maxProfitCutRod(prices, lengthOfRod);
        System.out.printf("Maximum Profit for length of rod %d is %d", lengthOfRod, maxProfitCutRod);
        Assert.assertEquals(18, maxProfitCutRod);
    }
}
