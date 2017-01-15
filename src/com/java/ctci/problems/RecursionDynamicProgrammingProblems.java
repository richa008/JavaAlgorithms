package com.java.ctci.problems;

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
}
