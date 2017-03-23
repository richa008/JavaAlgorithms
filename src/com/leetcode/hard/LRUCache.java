package com.leetcode.hard;

import java.util.HashMap;

/**
 * Created by richa on 3/23/17.
 *
 Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.

 get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.

 Follow up:
 Could you do both operations in O(1) time complexity?

 Example:

 LRUCache cache = new LRUCache( 2);

        cache.put(1, 1);
        cache.put(2, 2);
        cache.get(1);       // returns 1
        cache.put(3, 3);    // evicts key 2
        cache.get(2);       // returns -1 (not found)
        cache.put(4, 4);    // evicts key 1
        cache.get(1);       // returns -1 (not found)
        cache.get(3);       // returns 3
        cache.get(4);       // returns 4
 */

public class LRUCache {

    HashMap<Integer, Node> map = new HashMap<Integer, Node>();

    Node head;
    Node tail;
    int capacity;
    int count;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
        int count = 0;
    }

    public int get(int key) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            moveToHead(node);
            return node.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            node.value = value;
            moveToHead(node);
        }else{
            if(count == capacity){
                deleteTail();
            }else{
                count++;
            }
            Node newNode = new Node(value, key);
            addToHead(newNode);
            map.put(key, newNode);
        }
    }

    private void deleteTail(){
        if(capacity == count){
            Node toDeleteNode = tail.prev;
            Node prev = toDeleteNode.prev;
            prev.next = tail;
            tail.prev = prev;

            map.remove(toDeleteNode.key);
        }
    }

    private void addToHead(Node node){
        Node temp = head.next;
        head.next = node;
        node.prev = head;
        temp.prev = node;
        node.next = temp;
    }


    private void moveToHead(Node node){
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;

        addToHead(node);
    }
}

class Node{

    int value;
    int key;
    Node next;
    Node prev;

    public Node(int value, int key){
        this.value = value;
        this.key = key;
        this.prev = null;
        this.next = null;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
