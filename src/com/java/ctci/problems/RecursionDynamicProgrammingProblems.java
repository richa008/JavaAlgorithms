package com.java.ctci.problems;

import java.util.ArrayList;

/**
 * Created by richa on 1/15/17.
 *
 */
public class RecursionDynamicProgrammingProblems {

    /**
     *  Method 1
     *  A child is running up a staircase with n steps and can hop either 1, 2 or 3 steps at a time. Count how many
     *  possible ways are there for the child to run up the stairs
     *  Time complexity O(3^n)
     *
     * @param n - Total steps
     * @return - Number of ways
     */
    public int countWays(int n){
        if(n < 0){
            return 0;
        }
        if(n == 0){
            return 1;
        }
        return countWays(n -1 ) + countWays(n - 2) + countWays(n - 3);
    }

    /**
     *  Method 2 - With dynamic programming
     *  A child is running up a staircase with n steps and can hop either 1, 2 or 3 steps at a time. Count how many
     *  possible ways are there for the child to run up the stairs
     *  Time complexity O(n)
     *
     * @param n - Total steps
     * @return - Number of ways
     */
    public int countWays(int n, int array[]){
        if(n < 0){
            return 0;
        }
        if(n == 0){
            return 1;
        }
        if(array[n] > 0){
            return array[n];
        }
        array[n] = countWays(n -1, array) + countWays(n - 2, array) + countWays(n - 3, array);
        return array[n];
    }

    /**
     *  Find an index such that array[i] = i in a sorted array with no duplicates
     *
     * @param array - sorted array
     * @param start - starting index
     * @param end - ending index
     * @return index such that A[i] = i, or -1 if it doesn't exist
     */
    public int findMagicIndex(int array[], int start, int end){
        if(start < 0 || end > array.length || start > end){
            return -1;
        }

        int mid = (start + end)/2;
        if(array[mid] == mid){
            return mid;
        }
        else if(mid < array[mid]){
            return findMagicIndex(array, start, mid - 1);
        }else{
            return findMagicIndex(array, mid + 1, end);
        }

    }

    /**
     *  Find an index such that array[i] = i in a sorted array which can have duplicates
     *
     * @param array - sorted array
     * @param start - starting index
     * @param end - ending index
     * @return index such that A[i] = i, or -1 if it doesn't exist
     */
    public int findMagicIndex2(int array[], int start, int end) {
        if (start < 0 || end > array.length || start > end) {
            return -1;
        }

        int mid = (start + end) / 2;
        if (array[mid] == mid) {
            return mid;
        }
        if (array[mid] > 0) {
            int leftIndex = Math.min(mid - 1, array[mid]);
            int left = findMagicIndex2(array, start, leftIndex);
            if (left > 0) {
                return left;
            }
        }

        int rightIndex = Math.max(mid + 1, array[mid]);
        int right = findMagicIndex2(array, rightIndex, end);
        return right;
    }

    /**
     * Returns all subsets of the set. Time complexity O(2^n)
     *
     * @param set - Set of integers
     * @return - ArrayList of all subsets
     */
    public ArrayList<ArrayList<Integer>> getAllSubsets(ArrayList<Integer> set){

        int n = set.size();
        int max = 1 << n; // Computes 2^n

        ArrayList<ArrayList<Integer>> allSubsets = new ArrayList<ArrayList<Integer>>();

        for(int i = 0; i < max; i++){
            ArrayList<Integer> list = convertIntToSet(set, i);
            allSubsets.add(list);
        }

        return allSubsets;
    }

    private ArrayList<Integer> convertIntToSet(ArrayList<Integer> set, int num){
        int index = 0;
        ArrayList<Integer> subset = new ArrayList<Integer>();

        for(int i = num; i > 0; i >>= 1){
            if((i & 1) == 1){
                subset.add(set.get(index));
            }
            index++;
        }
        return subset;
    }

    /**
     * Get all permutations of string with unique characters. Time complexity O(n!)
     * @param string - string with unique characters
     * @return - Array list of permutations
     */
    public ArrayList<String> getPermutations(String string){

        if(string == null){
            return null;
        }

        if(string.length() == 0){
            ArrayList<String> permutations = new ArrayList<String>();
            permutations.add("");
            return permutations;
        }

        char firstChar = string.charAt(0);
        String remainingStr = string.substring(1); // Remove first char

        ArrayList<String> permutations = getPermutations(remainingStr);

        for(String permutation: permutations){
            for(int i = 0; i <= permutation.length(); i++){
                String s = insertCharacter(permutation, i, firstChar);
                permutations.add(s);
            }
        }
        return permutations;
    }

    private String insertCharacter(String permutation, int index, char c){
        String start = permutation.substring(0, index);
        String end = permutation.substring(index);
        return  start + c + end;
    }

    /**
     *  Print all valid combinations of n pair parenthesis
     *  @param n
     */
    public void printAllValidParenthesis(int n){
        char array[] = new char[n*2];
        printValidParenthesisHelper(array, 0, n, n);
    }

    public void printValidParenthesisHelper(char array[], int count, int leftRemaining, int rightRemaining){
        if(leftRemaining < 0 || rightRemaining < leftRemaining){
            return;
        }

        if(leftRemaining == 0 && rightRemaining == 0){
            System.out.println(array);
        }

        if(leftRemaining > 0){
            array[count] = '(';
            printValidParenthesisHelper(array, count+1, leftRemaining -1 , rightRemaining);
        }

        if(rightRemaining > leftRemaining){
            array[count] = ')';
            printValidParenthesisHelper(array, count + 1, leftRemaining, rightRemaining - 1);
        }
    }
}
