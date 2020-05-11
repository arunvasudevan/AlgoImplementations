package com.leetcode;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class ZombieInMatrixTest {

    static List<List<Integer>> input;

    @BeforeClass
    public static void setup(){
        List<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(1);
        list.add(1);
        list.add(0);
        list.add(1);
        input = new ArrayList<>(new ArrayList<>());
        input.add(list);
        List<Integer> list1 = new ArrayList<>();
        list1.add(0);
        list1.add(1);
        list1.add(0);
        list1.add(1);
        list1.add(0);
        input.add(list1);
        List<Integer> list2 = new ArrayList<>();
        list2.add(0);
        list2.add(0);
        list2.add(0);
        list2.add(0);
        list2.add(1);
        input.add(list2);
        List<Integer> list3 = new ArrayList<>();
        list3.add(0);
        list3.add(1);
        list3.add(0);
        list3.add(0);
        list3.add(0);
        input.add(list3);
    }

    @Test
    public void testZombie(){
        ZombieInMatrix zombieInMatrix= new ZombieInMatrix();
        int result = zombieInMatrix.minHours(4, 5, input);
        Assert.assertEquals(2, result);
    }
}
