package com.model.main;

/**
 * Created by richa on 12/19/16.
 *
 */
public class TreeNode {

    public int data;

    public TreeNode leftChild;

    public TreeNode rightChild;

    public TreeNode parent;

    public TreeNode(int data){
        this.data = data;
        leftChild = null;
        rightChild = null;
    }
}
