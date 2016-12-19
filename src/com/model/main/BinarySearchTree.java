package com.model.main;

/**
 * Created by richa on 12/19/16.
 *
 */
public class BinarySearchTree {

    private TreeNode root = null;

    /**
     * Inserts a node into the binary search tree
     * @param data - Data to be inserted
     */

    public void insert(int data) {

        if (root == null) {
            root = new TreeNode(data);
            return;
        }

        TreeNode current = root;

        while (true) {
            if (current.data <= data) {
                if (current.rightChild == null) {
                    current.rightChild = new TreeNode(data);
                    return;
                } else {
                    current = current.rightChild;
                }
            }

            if (current.data > data) {
                if (current.leftChild == null) {
                    current.leftChild = new TreeNode(data);
                    return;
                } else {
                    current = current.leftChild;
                }
            }
        }
    }

    public void printPreorder(TreeNode node){
        if(node != null){
            System.out.println(node.data);
            printPreorder(node.leftChild);
            printPreorder(node.rightChild);
        }
    }

    public void printInorder(TreeNode node){
        if(node != null){
            printInorder(node.leftChild);
            System.out.println(node.data);
            printInorder(node.rightChild);
        }
    }

    public void printPostorder(TreeNode node){
        if(node != null){
            printPostorder(node.leftChild);
            printPostorder(node.rightChild);
            System.out.println(node.data);
        }
    }

    public static void main(String args[]){

        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(6);
        tree.insert(4);
        tree.insert(8);
        tree.insert(3);
        tree.insert(5);
        tree.insert(7);
        tree.insert(10);
        tree.insert(9);

        tree.printInorder(tree.root);
    }
}
