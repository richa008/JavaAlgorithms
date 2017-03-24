package com.leetcode.easy;

import java.util.HashSet;

/**
 * Created by richa on 3/23/17.
 *
 * Given an array of integers, find if the array contains any duplicates. Your function should return true if any value appears at least twice in the array, and it should return false if every element is distinct.
 */
public class ContainsDuplicate {
    public class Solution {
        public boolean containsDuplicate(int[] nums) {
            HashSet set = new HashSet<Integer>();

            for(int num : nums){
                if(!set.add(num)){
                    return true;
                }
            }
            return false;
        }
    }
}
