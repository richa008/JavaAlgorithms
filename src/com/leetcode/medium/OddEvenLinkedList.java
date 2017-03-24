package com.leetcode.medium;

import com.ListNode;

/**
 *
 * Created by richa on 3/23/17.
 *
 * Given a singly linked list, group all odd nodes together followed by the even nodes. Please note here we are talking about the node number and not the value in the nodes.

 You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity.

 Example:
 Given 1->2->3->4->5->NULL,
 return 1->3->5->2->4->NULL.
 */
public class OddEvenLinkedList {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */
    public class Solution {
        public ListNode oddEvenList(ListNode head) {

            if(head == null || head.next == null){
                return head;
            }

            ListNode odd = head, even = head.next, evenStart = head.next;

            while(even != null && even.next != null){
                odd.next = odd.next.next;
                odd = odd.next;
                even.next = even.next.next;
                even = even.next;
            }
            odd.next = evenStart;
            return head;
        }
    }
}
