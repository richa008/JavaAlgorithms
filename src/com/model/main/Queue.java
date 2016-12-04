package com.model.main;

/**
 * Created by richa on 12/4/16.
 */
public class Queue {

    private Node first, last;

    public void enQueue(Object data) {
        Node n = new Node(data);
        if (first == null) {
            first = n;
            last = n;
        } else {
            last.next = n;
            last = n;
        }
    }

    public Object dequeue() {
        if (first == null) {
            return null;
        }
        Node n = first;
        first = first.next;

        if (first == null) {
            last = null; //Empty queue
        }

        return n.data;
    }
}
