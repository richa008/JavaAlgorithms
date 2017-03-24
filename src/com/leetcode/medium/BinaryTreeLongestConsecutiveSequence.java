package com.leetcode.medium;

import com.TreeNode;

/**
 * Created by richa on 3/23/17.
 * Given a binary tree, find the length of the longest consecutive sequence path.

 The path refers to any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The longest consecutive path need to be from parent to child (cannot be the reverse).

 For example,
 1
 \
 3
 / \
 2   4
 \
 5
 Longest consecutive sequence path is 3-4-5, so return 3.
 2
 \
 3
 /
 2
 /
 1
 Longest consecutive sequence path is 2-3,not3-2-1, so return 2.
 */
public class BinaryTreeLongestConsecutiveSequence {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    public class Solution {
        public int longestConsecutive(TreeNode root) {
            if(root == null){
                return 0;
            }
            return longestConsecutiveHelper(root, 1);
        }

        public int longestConsecutiveHelper(TreeNode root, int count){
            if(root == null){
                return count;
            }
            int left = (root.left != null && root.val + 1 == root.left.val) ? count+1: 1;
            int right = (root.right != null && root.val + 1 == root.right.val) ? count+1: 1;

            int lCount = longestConsecutiveHelper(root.left, left);
            int rCount = longestConsecutiveHelper(root.right, right);

            return Math.max(Math.max(lCount, rCount), count);
        }
    }
}
