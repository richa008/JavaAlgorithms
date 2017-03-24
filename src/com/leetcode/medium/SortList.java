package com.leetcode.medium;

import com.ListNode;

/**
 * Created by richa on 3/23/17.
 *
 * Sort a linked list in O(n log n) time using constant space complexity.
 */
public class SortList {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */
    public class Solution {
        public ListNode sortList(ListNode head) {

            if(head == null || head.next == null){
                return head;
            }

            ListNode fast = head, slow = head, prev = head;

            while(fast != null && fast.next != null){
                prev = slow;
                slow = slow.next;
                fast = fast.next.next;
            }

            prev.next = null;

            ListNode l1 = sortList(head);
            ListNode l2 = sortList(slow);

            return merge(l1, l2);
        }

        public ListNode merge(ListNode l1, ListNode l2){

            ListNode l = new ListNode(0);
            ListNode cur = l;

            while(l1 != null && l2 != null){
                if(l1.val <= l2.val){
                    cur.next = l1;
                    cur = cur.next;
                    l1 = l1.next;
                }
                else{
                    cur.next = l2;
                    cur = cur.next;
                    l2 = l2.next;
                }
            }

            if(l1 != null){
                cur.next = l1;
                cur = cur.next;
            }

            if(l2 != null){
                cur.next = l2;
                cur = cur.next;
            }

            cur = l;
            l = l.next;
            cur.next = null;

            return l;
        }
    }
}
