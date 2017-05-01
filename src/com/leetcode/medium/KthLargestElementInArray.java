package com.leetcode.medium;

/**
 * Created by richa on 4/30/17.
 *
 * Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.

 For example,
 Given [3,2,1,5,6,4] and k = 2, return 5.
 */
public class KthLargestElementInArray {
    public class Solution {
        public int findKthLargest(int[] nums, int k) {
            int l = 0, r = nums.length - 1;
            while(true){
                int pos = partition(nums, l, r);
                if(pos == k - 1){
                    return nums[pos];
                }
                if(pos > k - 1){
                    r = pos - 1;
                }else{
                    l = pos + 1;
                }
            }
        }

        public int partition(int nums[], int left, int right){
            int pivot = nums[left];
            int l = left+1;
            while(l <= right){
                if(nums[l] < pivot && nums[right] > pivot){
                    swap(nums, l, right);
                    l++; right--;
                }
                if(nums[l] >= pivot){
                    l++;
                }
                if(nums[right] <= pivot){
                    right--;
                }
            }
            swap(nums, left, right);
            return right;
        }

        public void swap(int nums[], int l, int r){
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
        }
    }
}
