package com.ctci.problems;

import com.model.main.LinkedListNode;

import java.util.HashMap;

/**
 * Created by richa on 12/3/16.
 * CTCI linked list problems
 */
public class LinkedListProblems {

    /**
     * Remove duplicate nodes in a linked lit
     * Time complexity - O(n), Space complexity - O(n)
     *
     */
    public void removeDuplicatesFromList(LinkedListNode head){

        if(head == null){
            return;
        }
        HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
        LinkedListNode current = head;
        LinkedListNode previous = null;
        while (current != null){
            if(hashMap.get(current.data) != null && previous != null){
                previous.next = current.next;
            }else{
                hashMap.put(current.data, 1);
                previous = current;
            }
            current = current.next;
        }
    }
}
