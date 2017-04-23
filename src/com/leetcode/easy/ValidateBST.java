package com.leetcode.easy;

import com.TreeNode;

/**
 * Created by richa on 4/22/17.
 *
 * Given a binary tree, determine if it is a valid binary search tree (BST).

 Assume a BST is defined as follows:

 The left subtree of a node contains only nodes with keys less than the node's key.
 The right subtree of a node contains only nodes with keys greater than the node's key.
 Both the left and right subtrees must also be binary search trees.
 Example 1:
 2
 / \
 1   3
 Binary tree [2,1,3], return true.
 Example 2:
 1
 / \
 2   3
 Binary tree [1,2,3], return false.
 */
public class ValidateBST {
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
        public boolean isValidBST(TreeNode root) {
            if(root == null){
                return true;
            }
            return isValidBSTHelper(root, null, null);
        }

        boolean isValidBSTHelper(TreeNode node, Integer min, Integer max){
            if(node == null){
                return true;
            }
            if((max != null && node.val >= max) || (min != null && node.val <= min)){
                return false;
            }
            return isValidBSTHelper(node.left, min, node.val) && isValidBSTHelper(node.right, node.val, max);

        }
    }
}
