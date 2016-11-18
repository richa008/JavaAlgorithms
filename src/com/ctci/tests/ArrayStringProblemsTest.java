package com.ctci.tests;

import com.ctci.problems.ArrayStringProblems;
import static org.junit.Assert.*;

/**
 * Created by richa on 11/16/16.
 */
public class ArrayStringProblemsTest {

    private ArrayStringProblems prob;

    @org.junit.Before
    public void setUp() throws Exception {
        prob = new ArrayStringProblems();
    }

    @org.junit.After
    public void tearDown() throws Exception {

    }

    @org.junit.Test
    public void doesStringHaveUniqueCharactersTest() throws Exception{
        assertEquals(prob.doesStringHaveUniqueCharacters(""), true);
        assertEquals(prob.doesStringHaveUniqueCharacters("abcdba"), false);
        assertEquals(prob.doesStringHaveUniqueCharacters("abhjk"), true);

    }

    @org.junit.Test
    public void areStringsPermutationTest() throws Exception{
        assertEquals(prob.areStringsPermutation("", "ff"), false);
        assertEquals(prob.areStringsPermutation("aaab", "aabb"), false);
        assertEquals(prob.areStringsPermutation("aabb", "aaab"), false);
        assertEquals(prob.areStringsPermutation("abcd", "efgh"), false);
        assertEquals(prob.areStringsPermutation("abcds", "sabdc"), true);

    }

}