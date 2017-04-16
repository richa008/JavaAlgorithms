package com.leetcode.medium;

import com.leetcode.RandomListNode;

/**
 * Created by richa on 4/15/17.
 *
 * A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.

 Return a deep copy of the list.
 */
public class CopyRandomPointer {
    /**
     * Definition for singly-linked list with a random pointer.
     * class RandomListNode {
     *     int label;
     *     RandomListNode next, random;
     *     RandomListNode(int x) { this.label = x; }
     * };
     */
    public class Solution {
        public RandomListNode copyRandomList(RandomListNode head) {
            if(head == null){
                return head;
            }
            RandomListNode cur = head;
            while(cur != null){
                RandomListNode node = new RandomListNode(cur.label);
                node.next = cur.next;
                cur.next = node;
                cur = cur.next.next;
            }

            cur = head;
            while(cur != null){
                if(cur.random != null){
                    cur.next.random = cur.random.next;
                }
                cur = cur.next.next;
            }

            cur = head;
            RandomListNode dupHead = new RandomListNode(0), next = null, dupCopy = dupHead;
            while(cur != null){
                next = cur.next.next;
                dupCopy.next = cur.next;
                dupCopy = cur.next;

                cur.next = next;
                cur = next;
            }
            return dupHead.next;
        }
    }
}
