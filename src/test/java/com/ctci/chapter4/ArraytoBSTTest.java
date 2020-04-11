package com.ctci.chapter4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import org.junit.Test;

import com.datastruct.TreeNode;

public class ArraytoBSTTest {

    @Test
    public void testArraytoBST() {

        final int inputSize = 10;
        final ArraytoBST a = new ArraytoBST();

        final ArrayList<Integer> arr = new ArrayList<>();
        final Random rand = new Random();
        for (int i = 0; i < inputSize; i++) {
            arr.add(rand.nextInt(100));
        }

        Collections.sort(arr);
        final TreeNode root = a.converttoBST(arr);

        final ArraytoBSTTest t = new ArraytoBSTTest();
        t.depthFirstTraversal(root);
    }

    public void depthFirstTraversal(TreeNode n) {

        if (n == null)
            return;

        depthFirstTraversal(n.left);
        System.out.println(n.data);
        depthFirstTraversal(n.right);
    }
}
