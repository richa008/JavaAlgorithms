package com.ctci.tests;

import com.ctci.problems.LinkedListProblems;
import com.model.main.LinkedList;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

/**
 * Created by richa on 12/3/16.
 */
public class LinkedListProblemsTest {

    LinkedList list;
    LinkedListProblems llprob;

    @Before
    public void setUp() throws Exception {
        list = new LinkedList();
        list.addNodeToTail(1);
        list.addNodeToTail(2);
        list.addNodeToTail(1);
        list.addNodeToTail(3);
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

}