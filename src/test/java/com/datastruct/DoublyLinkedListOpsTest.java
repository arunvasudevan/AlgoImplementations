package com.datastruct;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class DoublyLinkedListOpsTest {

    static DoublyLinkedListNode head;

    @BeforeClass
    public static void setup() {
        DoublyLinkedListNode node1 = new DoublyLinkedListNode(4);
        DoublyLinkedListNode node2 = new DoublyLinkedListNode(9);
        node1.next = node2;
        node2.prev = node1;
        DoublyLinkedListNode node3 = new DoublyLinkedListNode(16);
        node2.next = node3;
        node3.prev = node2;
        DoublyLinkedListNode node4 = new DoublyLinkedListNode(1);
        node4.prev = node3;
        node3.next = node4;
        head = node1;
    }

    @Test
    public void testSearch(){
        DoublyLinkedListOps doublyLinkedListOps = new DoublyLinkedListOps();
        boolean result = doublyLinkedListOps.search(head, 16);
        System.out.println("Is Value 16 Present in the Node? "+result);
        Assert.assertTrue(result);
    }

    @Test
    public void testInsert(){
        DoublyLinkedListOps doublyLinkedListOps = new DoublyLinkedListOps();
        DoublyLinkedListNode newHead = doublyLinkedListOps.insert(head, 99);
        Assert.assertEquals(99, newHead.val);
        DoublyLinkedListOps.printLinkedList(newHead);
    }


}
