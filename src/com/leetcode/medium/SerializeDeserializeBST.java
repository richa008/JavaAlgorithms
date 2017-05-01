package com.leetcode.medium;

import com.TreeNode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;

/**
 * Created by richa on 4/30/17.
 *
 * Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.

 Design an algorithm to serialize and deserialize a binary search tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary search tree can be serialized to a string and this string can be deserialized to the original tree structure.

 */
public class SerializeDeserializeBST {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    public class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            StringBuilder sb = new StringBuilder("");
            createPreorder(root, sb);
            return sb.toString();
        }

        void createPreorder(TreeNode root, StringBuilder sb){
            if(root == null){
                return;
            }
            sb.append(root.val);
            sb.append(",");
            createPreorder(root.left, sb);
            createPreorder(root.right, sb);
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            List<String> list = Arrays.asList(data.split(","));
            ArrayDeque<String> queue = new ArrayDeque<String>(list);
            return createTree(Integer.MIN_VALUE, Integer.MAX_VALUE, queue);
        }

        TreeNode createTree(int min, int max, ArrayDeque<String> queue){
            String temp = queue.peekFirst();
            if(temp == null || temp.equalsIgnoreCase("")){
                return null;
            }
            int val = Integer.parseInt(temp);
            if(val < min || val > max){
                return null;
            }
            queue.poll();
            TreeNode root = new TreeNode(val);
            root.left = createTree(min, val, queue);
            root.right = createTree(val, max, queue);

            return root;
        }
    }

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
}
