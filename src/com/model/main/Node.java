package com.model.main;

/**
 * Created by richa on 12/4/16.
 * Used by Stack and Queue
 */
public class Node {

    public Object data;

    public Node next;

    public Node(Object data){
        this.data = data;
        this.next = null;
    }
}
