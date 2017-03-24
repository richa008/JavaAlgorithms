package com.leetcode.easy;

import com.ListNode;

/**
 * Created by richa on 3/23/17.
 *
 * Reverse a singly linked list.
 */
public class ReverseLinkedList {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */
    public class Solution {
        public ListNode reverseList(ListNode head) {
            if(head == null){
                return null;
            }
            ListNode cur = head, prev = head, next = head.next;
            head.next = null;

            while(next != null){
                cur = next;
                next = next.next;
                cur.next = prev;
                prev = cur;
            }

            return cur;
        }
    }
}
