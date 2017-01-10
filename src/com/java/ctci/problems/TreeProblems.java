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

    /**
     * Check if binary tree is a binary search tree
     *
     * @param node - root node
     * @return - true if tree is a BST
     */
    public boolean isBinarySearchTree(TreeNode node){
        return isBinarySearchTreeHelper(node, null, null);
    }

    private boolean isBinarySearchTreeHelper(TreeNode node, Integer min, Integer max){
        if(node == null){
            return false;
        }

        if((min != null && node.data <= min) || (max != null && node.data > max)){
            return false;
        }

        return !isBinarySearchTreeHelper(node.leftChild, min, node.data) && !isBinarySearchTreeHelper(node.rightChild, node.data, max);
    }

    /**
     * Finds next inorder successor of a given node in a binary search tree
     *
     * @param node - root node
     * @return - Inorder successor
     */
    public TreeNode nextInorderNode(TreeNode node){
        if(node == null){
            return null;
        }

        if(node.rightChild != null){
            return getLeftmostNode(node);
        }
        else{
            TreeNode parent = node.parent;
            while(parent != null && node != parent.leftChild){
                node = parent;
                parent = node.parent;
            }
            return parent;
        }
    }

    private TreeNode getLeftmostNode(TreeNode node){
        if(node == null){
            return null;
        }
        while (node.leftChild != null){
            node = node.leftChild;
        }
        return node;
    }

    /**
     *  Find first common ancestor of 2 nodes in binary tree
     *  Time complexity - O(n)
     *
     * @param node - root node
     * @param p - node in the tree
     * @param q - node in the tree
     * @return - common ancestor of p and q
     */
    public TreeNode findCommonAncestor(TreeNode node, TreeNode p, TreeNode q){
        if (!covers(node, p) && !covers(node, q) ){
            return null;
        }
        return commonAncestorHelper(node, p, q);
    }

    private TreeNode commonAncestorHelper(TreeNode node, TreeNode p, TreeNode q){
        if(node == null){
            return null;
        }
        if(p == node || q == node){
            return node;
        }

        boolean is_p_left = covers(node.leftChild, p);
        boolean is_q_left = covers(node.leftChild, q);

        if(is_p_left != is_q_left){
            return node;
        }else {
            if(is_p_left) {
                return commonAncestorHelper(node.leftChild, p, q);
            }else{
                return commonAncestorHelper(node.rightChild, p, q);
            }
        }
    }

    private boolean covers(TreeNode node, TreeNode p){
        return (node != null ) && ((node == p) || covers(node.leftChild, p) || covers(node.rightChild, p));
    }

    /**
     * Finds if subtree T2 is contained in tree T1
     * Time complexity O(log n) + O(log m)
     *
     * Alternative approach - Create inorder and pre-order traversals of both tree. Check if traversals of t2 are substrings of t1
     * Time complexity O(m + n)
     *
     * @param t1 - root node of tree T1 which has millions of nodes
     * @param t2 - root node of tree T2 which has hundreds of nodes
     * @return - returns true if T2 is contained in T1
     */
    public boolean containsTree(TreeNode t1, TreeNode t2){
        return (t2 == null) || isSubtree(t1, t2);
    }

    private boolean isSubtree(TreeNode t1, TreeNode t2){
        if(t1 == null){
            return false;
        }

        if(matches(t1, t2)){
            return true;
        }
        return (isSubtree(t1.leftChild, t2) || isSubtree(t1.rightChild, t2));
    }

    private boolean matches(TreeNode t1, TreeNode t2){
        if(t1 == null && t2 == null){
            return true;
        }
        else if(t1 == null){
            return false;
        }else if(t2 == null){
            return false;
        }
        if(t1.data != t2.data){
            return false;
        }

        return (matches(t1.leftChild, t2.leftChild) && matches(t1.rightChild, t2.rightChild));
    }

}
