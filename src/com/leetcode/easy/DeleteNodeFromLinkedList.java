package com.leetcode.easy;

import com.ListNode;

/**
 * Created by richa on 3/23/17.
 *
 * Write a function to delete a node (except the tail) in a singly linked list, given only access to that node.

 Supposed the linked list is 1 -> 2 -> 3 -> 4 and you are given the third node with value 3, the linked list should become 1 -> 2 -> 4 after calling your function.
 */
public class DeleteNodeFromLinkedList {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */
    public class Solution {
        public void deleteNode(ListNode node) {

            while(node.next != null){
                node.val = node.next.val;

                if(node.next.next == null){
                    node.next = null;
                }else{
                    node = node.next;
                }

            }
        }
    }
}
