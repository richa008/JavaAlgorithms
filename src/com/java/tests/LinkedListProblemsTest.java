package com.java.tests;

import com.java.problems.LinkedListProblems;
import com.model.main.LinkedList;
import com.model.main.LinkedListNode;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

/**
 * Created by richa on 12/3/16.
 * Unit tests for LinkedListProblems
 */
public class LinkedListProblemsTest {

    private LinkedList list;
    private LinkedListProblems llprob;

    @Before
    public void setUp() throws Exception {
        list = new LinkedList();
        list.addNodeToTail(1);
        list.addNodeToTail(2);
        list.addNodeToTail(1);
        list.addNodeToTail(3);
        list.addNodeToTail(3);
        list.addNodeToTail(2);

        llprob = new LinkedListProblems();
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void removeDuplicatesFromList() throws Exception {
        llprob.removeDuplicatesFromList(list.head);
        assertEquals(asList(1, 2, 3), list.getDataFromLinkedList());

    }

    @Test
    public void getKthLastElementTest() throws Exception {
        LinkedListNode node = llprob.getKthLastElement(1, list.head);
        assertEquals(3, node.data);

        node = llprob.getKthLastElement(0, list.head);
        assertEquals(2, node.data);

        node = llprob.getKthLastElement(5, list.head);
        assertEquals(1, node.data);

        node = llprob.getKthLastElement(3, list.head);
        assertEquals(1, node.data);

        node = llprob.getKthLastElement(8, list.head);
        assertEquals(null, node);
    }

    @Test
    public void partitionListTest() throws Exception{

        LinkedList newlist = new LinkedList();
        newlist.addNodeToTail(2);
        newlist.addNodeToTail(4);
        newlist.addNodeToTail(3);
        newlist.addNodeToTail(1);
        newlist.addNodeToTail(3);

        LinkedListNode newHead = llprob.partitionList(newlist.head, 3);
        newlist.head = newHead;
        assertEquals(asList(1, 2, 4, 3, 3), newlist.getDataFromLinkedList());

    }

}