package com.leetcode.medium;

import com.ListNode;

/**
 * Created by richa on 3/23/17.
 *
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

 You may assume the two numbers do not contain any leading zero, except the number 0 itself.

 Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 Output: 7 -> 0 -> 8
 */
public class AddTwoNumbers {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */
    public class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            int carry = 0, value = 0;
            ListNode head = null, current = null;
            while(l1 != null && l2 != null){
                value = (l1.val + l2.val + carry)%10;
                carry = (l1.val + l2.val + carry)/10;

                if(head == null){
                    head = new ListNode(value);
                    current = head;
                }else{
                    current.next = new ListNode(value);
                    current = current.next;
                }
                l1 = l1.next;
                l2 = l2.next;
            }
            while(l1 != null){
                value = (l1.val + carry)%10;
                carry = (l1.val + carry)/10;

                current.next = new ListNode(value);
                current = current.next;
                l1 = l1.next;
            }

            while(l2 != null){
                value = (l2.val + carry)%10;
                carry = (l2.val + carry)/10;

                current.next = new ListNode(value);
                current = current.next;
                l2 = l2.next;
            }

            if(carry > 0){
                current.next = new ListNode(carry);
                current = current.next;
            }

            return head;
        }
    }
}
