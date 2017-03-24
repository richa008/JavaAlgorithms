package com.leetcode.medium;

/**
 * Created by richa on 3/23/17.
 *
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

 (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

 Find the minimum element.

 You may assume no duplicate exists in the array.
 */
public class FindMinimumInRotatedSortedArray {
    public class Solution {
        public int findMin(int[] nums) {

            int left = 0;
            int right = nums.length - 1;

            while(left < right){
                int mid = (left + right)/2;
                if (mid > 0 && nums[mid] < nums[mid - 1]) {
                    return nums[mid];
                }
                if(nums[mid] > nums[right]){
                    left = mid + 1;
                }else{
                    right = mid - 1;
                }
            }
            return nums[left];
        }
    }
}
