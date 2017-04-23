package com.leetcode.easy;

import com.ListNode;

/**
 * Created by richa on 4/22/17.
 *
 * Given a singly linked list, determine if it is a palindrome.

 Follow up:
 Could you do it in O(n) time and O(1) space?
 */
public class PalindromeLinkedList {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */
    public class Solution {
        public boolean isPalindrome(ListNode head) {
            if(head == null){
                return true;
            }
            ListNode slow = head, fast = head;

            while(fast != null && fast.next != null){
                slow = slow.next;
                fast = fast.next.next;
            }
            if(fast != null){
                slow = slow.next;
            }
            ListNode cur = slow, prev = null;
            while(cur != null){
                ListNode temp = cur.next;
                cur.next = prev;
                prev = cur;
                cur = temp;
            }
            slow = prev;
            cur = head;

            while(slow != null){
                if(cur.val != slow.val){
                    return false;
                }
                cur = cur.next;
                slow = slow.next;
            }
            return true;
        }
    }
}
