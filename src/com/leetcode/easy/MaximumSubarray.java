package com.leetcode.easy;

/**
 * Created by richa on 3/23/17.
 *
 * Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

 For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
 the contiguous subarray [4,-1,2,1] has the largest sum = 6.
 */
public class MaximumSubarray {
    public class Solution {
        public int maxSubArray(int[] nums) {
            int maxSoFar = nums[0];
            int maxEndingHere = nums[0];

            for(int i = 1; i < nums.length; i++){
                maxEndingHere = Math.max(maxEndingHere + nums[i], nums[i]);
                maxSoFar = Math.max(maxEndingHere, maxSoFar);
            }

            return maxSoFar;
        }
    }
}
