package com.leetcode;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class ZombieInMatrixTest {

    static List<List<Integer>> input;

    @BeforeClass
    public static void setup(){
        input = Arrays.asList(Arrays.asList(0, 1, 1, 0, 1),
            Arrays.asList(0, 1, 0, 1, 0),
            Arrays.asList(0, 0, 0, 0, 1),
            Arrays.asList(0, 1, 0, 0, 0));
    }

    @Test
    public void testZombie(){
        ZombieInMatrix zombieInMatrix= new ZombieInMatrix();
        int result = zombieInMatrix.minHours(4, 5, input);
        Assert.assertEquals(2, result);
    }
}
