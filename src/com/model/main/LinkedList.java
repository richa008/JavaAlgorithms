package com.model.main;

import java.util.ArrayList;

/**
 * Created by richa on 12/3/16.
 * LinkedList Class
 */
public class LinkedList {

    public LinkedListNode head = null;

    /*
     * Adds new node to the end of a linked list
     *
     * @param data - int value of the new node
     */
    public void addNodeToTail(int data){

        if(head == null){
            head = new LinkedListNode(data);
        }
        else{
            LinkedListNode pointer = head;
            while(pointer.next != null){
                pointer = pointer.next;
            }
            pointer.next = new LinkedListNode(data);
        }
    }

    /*
     * Deletes a node from the list
     *
     * @param data - int value of the node to be deleted
     */
    public void deleteNode(int data){
        if(head == null){
            return;
        }
        if(head.data == data){
            head = head.next;
            return;
        }
        LinkedListNode ptr = head;
        while (ptr.next != null){
            if(ptr.next.data == data){
                ptr.next = ptr.next.next;
            }else {
                ptr = ptr.next;
            }
        }
    }

    /*
     * Adds new node to the end of a linked list
     *
     * @return - Returns an arrayList of all data values of the linked list
     */
    public ArrayList getDataFromLinkedList(){

        ArrayList dataArray = new ArrayList();

        LinkedListNode pointer = head;
        while(pointer.next != null){
           dataArray.add(pointer.data);
            pointer = pointer.next;
        }
        dataArray.add(pointer.data);

        return dataArray;
    }
}
