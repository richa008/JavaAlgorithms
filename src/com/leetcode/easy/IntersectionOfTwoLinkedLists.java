package com.leetcode.easy;

import com.ListNode;

/**
 * Created by richa on 3/23/17.
 *
 * Write a program to find the node at which the intersection of two singly linked lists begins.
 */
public class IntersectionOfTwoLinkedLists {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) {
     *         val = x;
     *         next = null;
     *     }
     * }
     */
    public class Solution {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            ListNode curA = headA, curB = headB;
            int lenA = 0, lenB = 0;

            while(curA != null){
                curA = curA.next;
                lenA++;
            }

            while(curB != null){
                curB = curB.next;
                lenB++;
            }
            curB = headB;
            curA = headA;

            if(lenA < lenB){
                int diff = lenB - lenA;
                while(diff > 0){
                    curB = curB.next;
                    diff--;
                }
            }
            else if(lenA > lenB){
                int diff = lenA - lenB;
                while(diff > 0){
                    curA = curA.next;
                    diff--;
                }
            }

            while(curA != null && curB != null){
                if(curA == curB){
                    return curA;
                }
                curA = curA.next;
                curB = curB.next;
            }
            return null;
        }
    }
}
