package com.java.ctci.problems;

import com.model.main.TreeNode;

/**
 * Created by richa on 12/19/16.
 *
 */
public class TreeProblems {

    /**
     * Check if a binary tree is balanced
     *
     * @param root - root node of tree
     * @return true if the tree is balanced, false if not balanced
     */
    public boolean isTreeBalanced(TreeNode root){
        return (checkHeight(root) != -1);
    }

    private int checkHeight(TreeNode node){
        if(node == null){
            return -1;
        }

        int leftHeight = checkHeight(node.leftChild);
        if(leftHeight == -1){
            return -1;
        }

        int rightHeight = checkHeight(node.rightChild);
        if(rightHeight == -1){
            return -1;
        }

        int diff = Math.abs(leftHeight - rightHeight);
        if(diff > 1){
            return -1;
        }

        return Math.max(leftHeight, rightHeight) + 1;
    }

    /**
     * Given an sorted array of unique integers, create BST of minimal height
     *
     * @param array - Sorted array of unique integers
     * @return - Root node of tree
     */
    public TreeNode createMinimalBST(int array[]){
        return createMinimalBSTHelper(array, 0, array.length - 1);
    }

    private TreeNode createMinimalBSTHelper(int array[], int start, int end){
        if(start == end){
            return null;
        }

        int mid = (start + end)/2;
        TreeNode node = new TreeNode(array[mid]);
        node.leftChild = createMinimalBSTHelper(array, 0, mid - 1);
        node.rightChild = createMinimalBSTHelper(array, mid + 1, end);
        return node;
    }

}
