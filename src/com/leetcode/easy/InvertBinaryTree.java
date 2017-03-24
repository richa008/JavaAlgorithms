package com.leetcode.easy;

import com.TreeNode;

/**
 * Created by richa on 3/23/17.
 *
 * Invert a binary tree.
 */
public class InvertBinaryTree {
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
        public TreeNode invertTree(TreeNode root) {

            if(root == null){
                return null;
            }

            root.left = invertTree(root.left);
            root.right = invertTree(root.right);

            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;

            return root;

        }
    }
}
