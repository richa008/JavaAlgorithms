package com.leetcode.medium;

import java.util.Random;

/**
 * Created by richa on 5/8/17.
 *
 * Shuffle a set of numbers without duplicates.

 Example:

 // Init an array with set 1, 2, and 3.
 int[] nums = {1,2,3};
 Solution solution = new Solution(nums);

 // Shuffle the array [1,2,3] and return its result. Any permutation of [1,2,3] must equally likely to be returned.
 solution.shuffle();

 // Resets the array back to its original configuration [1,2,3].
 solution.reset();

 // Returns the random shuffling of array [1,2,3].
 solution.shuffle();
 */
public class ShuffleAnArray {
    public class Solution {

        //int originalNums[];
        int nums[];

        public Solution(int[] nums) {
            this.nums = nums;
            //this.originalNums = new int[nums.length];
            //this.originalNums = nums.clone();
        }

        /** Resets the array to its original configuration and return it. */
        public int[] reset() {
            //nums = originalNums.clone();
            return nums;
        }

        /** Returns a random shuffling of the array. */
        public int[] shuffle() {
            int originalNums[] = nums.clone();
            for(int i = 0; i <  originalNums.length; i++){
                Random rand = new Random();
                int nextRand = rand.nextInt(originalNums.length);
                int temp = originalNums[i];
                originalNums[i] = originalNums[nextRand];
                originalNums[nextRand] = temp;
            }
            return originalNums;
        }
    }

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */
}
