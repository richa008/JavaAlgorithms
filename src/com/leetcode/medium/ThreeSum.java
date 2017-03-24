package com.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by richa on 3/23/17.
 *
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

 Note: The solution set must not contain duplicate triplets.

 For example, given array S = [-1, 0, 1, 2, -1, -4],

 A solution set is:
 [
 [-1, 0, 1],
 [-1, -1, 2]
 ]
 */
public class ThreeSum {
    public class Solution {
        public List<List<Integer>> threeSum(int[] nums) {

            List<List<Integer>> list = new ArrayList();

            Arrays.sort(nums);

            for(int i = 0; i + 2 < nums.length; i++){
                if((i > 0) && (nums[i] == nums[i - 1])){
                    continue;
                }
                int j = i + 1, k = nums.length - 1;

                while(j < k){
                    int diff = 0- nums[i];
                    if(nums[k] + nums[j] == diff){
                        List<Integer> l = new ArrayList();
                        l.add(nums[i]);
                        l.add(nums[j]);
                        l.add(nums[k]);
                        list.add(l);
                        j++;
                        k--;

                        while((j < k) && (nums[j] == nums[j-1])){
                            j++;
                        }
                        while((j < k) && (nums[k] == nums[k+1])){
                            k--;
                        }
                    }
                    else if(diff < (nums[j] + nums[k])){
                        k--;
                    }else{
                        j++;
                    }
                }
            }
            return list;
        }
    }
}
