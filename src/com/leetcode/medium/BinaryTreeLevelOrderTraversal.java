package com.leetcode.medium;

import com.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * Created by richa on 4/30/17.
 *
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

 For example:
 Given binary tree [3,9,20,null,null,15,7],
 3
 / \
 9  20
 /  \
 15   7
 return its level order traversal as:
 [
 [3],
 [9,20],
 [15,7]
 ]
 */
public class BinaryTreeLevelOrderTraversal {
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
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> levelList = new ArrayList<List<Integer>>();
            Queue<TreeNode> queue = new ArrayDeque<TreeNode>();

            if(root == null){
                return levelList;
            }
            queue.offer(root);
            while(!queue.isEmpty()){
                int size = queue.size();
                List<Integer> l = new ArrayList<Integer>();
                for(int i = 0; i < size; i++){
                    TreeNode t = queue.poll();
                    if(t.left != null){
                        queue.offer(t.left);
                    }
                    if(t.right != null){
                        queue.offer(t.right);
                    }
                    l.add(t.val);
                }
                levelList.add(l);
            }
            return levelList;
        }
    }
}
