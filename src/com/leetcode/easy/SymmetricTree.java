package com.leetcode.easy;

import com.TreeNode;

/**
 * Created by richa on 4/8/17.
 *
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

 For example, this binary tree [1,2,2,3,4,4,3] is symmetric:

 1
 / \
 2   2
 / \ / \
 3  4 4  3
 But the following [1,2,2,null,3,null,3] is not:
 1
 / \
 2   2
 \   \
 3    3
 */
public class SymmetricTree {
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
        public boolean isSymmetric(TreeNode root) {
            return root == null || isSymmetricHelper(root.left, root.right);
        }

        boolean isSymmetricHelper(TreeNode left, TreeNode right){
            if(left == null || right == null){
                return left == right;
            }

            if(left.val != right.val){
                return false;
            }
            return isSymmetricHelper(left.left, right.right) && isSymmetricHelper(left.right, right.left);
        }
    }
}
