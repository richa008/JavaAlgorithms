package com.java.ctci.problems;

import com.model.main.LinkedListNode;

import java.util.HashMap;

/**
 * Created by richa on 12/3/16.
 * CTCI linked list problems
 */
public class LinkedListProblems {

    /**
     * Remove duplicate nodes in a linked list
     * Time complexity - O(n), Space complexity - O(n)
     */
    public void removeDuplicatesFromList(LinkedListNode head) {

        if (head == null) {
            return;
        }
        HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
        LinkedListNode current = head;
        LinkedListNode previous = null;
        while (current != null) {
            if (hashMap.get(current.data) != null && previous != null) {
                previous.next = current.next;
            } else {
                hashMap.put(current.data, 1);
                previous = current;
            }
            current = current.next;
        }
    }

    /**
     * Returns the kth last element from the list
     * Time complexity - O(n), Space complexity - O(1)
     */
    public LinkedListNode getKthLastElement(int k, LinkedListNode head) {
        if (head == null || k < 0) {
            return null;
        }
        LinkedListNode p1 = head, p2 = head;
        int i = 0;

        while (i < k) {
            if (p2.next == null) {
                return null;
            }
            p2 = p2.next;
            i++;
        }

        while (p2.next != null) {
            p2 = p2.next;
            p1 = p1.next;
        }

        return p1;
    }

    /*
     * Deletes a node in the middle of a singly linked list given only access to that node
     *
     *  @param node - Node to be deleted
     */
    public void deleteNode(LinkedListNode node) {
        if (node == null || node.next == null) {
            return;
        }
        while (node.next != null) {
            LinkedListNode nextNode = node.next;
            node.data = nextNode.data;
            node.next = nextNode.next;
        }
    }

    /*
     *  Partitions linked list around a value pivot such that nodes less than pivot come before all nodes greater than or equal to pivot
     *
     *  @param head - head of the linkedlist
     *  @param pivot - List is partitioned based on the pivot
     */
    public LinkedListNode partitionList(LinkedListNode head, int pivot) {
        if (head == null) {
            return null;
        }
        LinkedListNode newHead = head, newTail = head, current = head;

        while (current != null) {
            LinkedListNode nextNode = current.next;

            if (current.data < pivot) {
                current.next = newHead;
                newHead = current;
            } else {
                newTail.next = current;
                newTail = current;
            }
            current = nextNode;
        }
        newTail.next = null;
        return newHead;
    }


    //TODO: Implement a function to check if the linked list is a palindrome
    /* Method 1: Reverse the list and compare
     * Method 2: Use slow pointer and fast pointer, add half of the list to a stack. Compare remaining half from the stack
     */
}
