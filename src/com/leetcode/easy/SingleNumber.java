package com.leetcode.easy;

/**
 * Created by richa on 3/23/17.
 *
 * Given an array of integers, every element appears twice except for one. Find that single one.

 Note:
 Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 */
public class SingleNumber {
    public class Solution {
        public int singleNumber(int[] nums) {

            int result = 0;
            for(int i = 0; i < nums.length; i++){
                result = result ^ nums[i];
            }

            return result;
        }
    }
}
