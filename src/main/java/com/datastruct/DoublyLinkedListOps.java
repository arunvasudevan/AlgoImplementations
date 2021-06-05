package com.datastruct;

public class DoublyLinkedListOps {

    boolean search(DoublyLinkedListNode node, int searchVal){
        while(node!= null){
            if(node.val == searchVal){
                return true;
            }
            node = node.next;
        }
        return false;
    }

    DoublyLinkedListNode insert(DoublyLinkedListNode node, int insertVal){
        DoublyLinkedListNode newNode = new DoublyLinkedListNode(insertVal);
        newNode.next = node;
        if(node != null) {
            node.prev = newNode;
        }
        return newNode;
    }

    public static void printLinkedList(DoublyLinkedListNode node){
        DoublyLinkedListNode headNode = node;
        while(headNode != null){
            System.out.print(headNode.val + " --> ");
            headNode = headNode.next;
        }
        System.out.print("null");
        System.out.println();
    }
}
