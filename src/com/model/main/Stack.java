package com.model.main;

/**
 * Created by richa on 12/4/16.
 *
 */
public class Stack {

    private Node top;

    public void push(Object data){
        Node newNode = new Node(data);
        newNode.next = top;
        top = newNode;
    }

    public Object pop(){
        if(top == null){
            return null;
        }
        Object item = top.data;
        top = top.next;

        return item;
    }

    public Object peek(){
        if(top == null){
            return null;
        }
        return top.data;
    }

}
