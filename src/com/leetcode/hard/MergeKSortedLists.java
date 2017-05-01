package com.leetcode.hard;

import com.ListNode;

/**
 * Created by richa on 4/30/17.
 *
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 */
public class MergeKSortedLists {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */
    public class Solution {
        public ListNode mergeKLists(ListNode[] lists) {
            return partition(0, lists.length - 1, lists);
        }

        ListNode partition(int start, int end, ListNode[] lists){
            if(start == end){
                return lists[start];
            }
            if(start < end){
                int mid = (end + start)/2;
                ListNode l1 = partition(start, mid, lists);
                ListNode l2 = partition(mid+1, end, lists);

                ListNode dummy = new ListNode(0);
                merge(l1, l2, dummy);
                return dummy.next;
            }
            return null;
        }

        void merge(ListNode l1, ListNode l2, ListNode result){
            ListNode cur = result;

            while(l1 != null && l2 != null){
                if(l1.val < l2.val){
                    cur.next = new ListNode(l1.val);
                    l1 = l1.next;
                }else{
                    cur.next = new ListNode(l2.val);
                    l2 = l2.next;
                }
                cur = cur.next;
            }

            while(l1 != null){
                cur.next = new ListNode(l1.val);
                l1 = l1.next;
                cur = cur.next;
            }

            while(l2 != null){
                cur.next = new ListNode(l2.val);
                l2 = l2.next;
                cur = cur.next;
            }
        }
    }
}
