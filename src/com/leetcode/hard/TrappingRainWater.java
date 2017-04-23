package com.leetcode.hard;

/**
 * Created by richa on 4/22/17.
 *
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.

 For example,
 Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
 */
public class TrappingRainWater {
    public class Solution {
        public int trap(int[] height) {

            int i = 0, j = height.length - 1;
            int leftmax = 0, rightmax = 0, water = 0;

            while(i < j){
                leftmax = Math.max(height[i], leftmax);
                rightmax = Math.max(height[j], rightmax);

                if(leftmax < rightmax){
                    water += leftmax - height[i];
                    i++;
                }else{
                    water += rightmax - height[j];
                    j--;
                }
            }
            return water;
        }
    }
}
