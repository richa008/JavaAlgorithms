package com.leetcode.hard;

import com.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * Created by richa on 4/15/17.
 *
 * Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.

 Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.

 For example, you may serialize the following tree

 1
 / \
 2   3
 / \
 4   5
 as "[1,2,3,null,null,4,5]", just the same as how LeetCode OJ serializes a binary tree. You do not necessarily need to follow this format, so please be creative and come up with different approaches yourself.

 */
public class SerializeDeserializeBinaryTree {
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
            StringBuilder result = new StringBuilder();
            preorder(root, result);
            return result.toString();
        }

        void preorder(TreeNode node, StringBuilder sb){
            if(node == null){
                sb.append("X").append(",");
                return;
            }
            sb.append(node.val).append(",");
            preorder(node.left, sb);
            preorder(node.right, sb);
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            LinkedList<String> list = new LinkedList<String>();
            list.addAll(Arrays.asList(data.split(",")));

            return buildTree(list);
        }

        TreeNode buildTree(LinkedList<String> list){
            String str = list.remove();
            if(str.equals("X")){
                return null;
            }
            TreeNode n = new TreeNode(Integer.valueOf(str));
            n.left = buildTree(list);
            n.right = buildTree(list);

            return n;
        }

    }

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
}
