package com.leetcode.easy;

import com.TreeNode;

/**
 * Created by richa on 4/8/17.
 *
 * Given a binary tree, determine if it is height-balanced.

 For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 */
public class BalancedBinaryTree {
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
        public boolean isBalanced(TreeNode root) {
            if(root == null || getDepth(root) != -1){
                return true;
            }
            return false;
        }

        int getDepth(TreeNode node){
            if(node == null){
                return 0;
            }
            int lHt = getDepth(node.left);
            if(lHt == -1){
                return -1;
            }
            int rHt = getDepth(node.right);
            if(rHt == -1){
                return -1;
            }
            if(lHt - rHt > 1 || rHt - lHt > 1){
                return -1;
            }
            return 1 + Math.max(lHt, rHt);
        }
    }
}
