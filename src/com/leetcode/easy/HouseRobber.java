package com.leetcode.easy;

/**
 * Created by richa on 3/23/17.
 *
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

 Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.
 */
public class HouseRobber {
    public class Solution {
        public int rob(int[] nums) {
            int odd = 0, even = 0;
            int maxAmount = 0;
            for(int i = 0; i < nums.length; i++){

                if((i % 2) == 0){
                    even = Math.max(odd, nums[i] + even);
                    maxAmount = Math.max(maxAmount, even);
                }else{
                    odd = Math.max(even, nums[i] + odd);
                    maxAmount = Math.max(maxAmount, odd);
                }

            }
            return maxAmount;
        }
    }
}
