package com.model.tests;

import com.model.main.LinkedList;
import org.junit.Test;

import java.util.ArrayList;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

/**
 * Created by richa on 12/3/16.
 *
 * Unit test for LinkedLists
 */
public class LinkedListTest {

    private LinkedList list;

    @org.junit.Before
    public void setUp() throws Exception {
        list = new LinkedList();
        list.addNodeToTail(1);
        list.addNodeToTail(2);
        list.addNodeToTail(3);
        list.addNodeToTail(4);
    }

    @org.junit.After
    public void tearDown() throws Exception {

    }

    @Test
    public void getDataFromLinkedList() throws Exception {
        ArrayList rList = list.getDataFromLinkedList();
        assertEquals(asList(1, 2, 3, 4), rList);
    }

    @Test
    public void deleteNodeTest() throws Exception {
        list.deleteNode(3);
        ArrayList rList = list.getDataFromLinkedList();
        assertEquals(asList(1, 2, 4), rList);
    }

}