package com.java.ctci.problems;

import com.model.main.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;

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

    /**
     *  Creates a linked list of all nodes at each depth (Recursive solution)
     *  Time complexity - O(N)
     *  Space complexity - O(log N)
     *
     * @param node - root node of tree
     * @return - Array list of all linked lists
     */
    public ArrayList<LinkedList<TreeNode>> getLinkedListOfTreeNodesRecursive(TreeNode node){

        ArrayList<LinkedList<TreeNode>> lists = new ArrayList<LinkedList<TreeNode>>();
        linkedListOfNodesHelper(lists, node, 0);
        return lists;
    }

    private void linkedListOfNodesHelper(ArrayList<LinkedList<TreeNode>> lists, TreeNode node, int level){
        if(node == null){
            return;
        }

        if(lists.size() == level){
            LinkedList<TreeNode> list = new LinkedList<TreeNode>();
            list.add(node);
            lists.add(list);
        }else{
            LinkedList<TreeNode> list = lists.get(level);
            list.add(node);
        }

        linkedListOfNodesHelper(lists, node.leftChild, level + 1);
        linkedListOfNodesHelper(lists, node.rightChild, level + 1);
    }

    /**
     *  Creates a linked list of all nodes at each depth (Iterative solution)
     *  Time complexity - O(N)
     *
     * @param node - root node of tree
     * @return - Array list of all linked lists
     */
    public ArrayList<LinkedList<TreeNode>> getLinkedListOfTreeNodesIterative(TreeNode node){

        if(node == null){
            return null;
        }

        ArrayList<LinkedList<TreeNode>> lists = new ArrayList<LinkedList<TreeNode>>();
        LinkedList<TreeNode> current = new LinkedList<TreeNode>();
        current.add(node);

        while (!current.isEmpty()){
            lists.add(current);
            LinkedList<TreeNode> parents = current;
            current = new LinkedList<TreeNode>();

            for (TreeNode n : parents){
                if(n.leftChild != null){
                    current.add(n.leftChild);
                }else if(n.rightChild != null){
                    current.add(n.rightChild);
                }
            }
        }
        return lists;
    }

}
