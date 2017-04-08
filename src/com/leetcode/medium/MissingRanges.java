package com.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by richa on 3/25/17.
 *
 * Given a sorted integer array where the range of elements are in the inclusive range [lower, upper], return its missing ranges.

 For example, given [0, 1, 3, 50, 75], lower = 0 and upper = 99, return ["2", "4->49", "51->74", "76->99"].
 */
public class MissingRanges {
    public class Solution {
        public List<String> findMissingRanges(int[] nums, int lower, int upper) {
            List<String> list = new ArrayList<String>();
            int low = lower - 1;
            for(int i = 0; i <= nums.length; i++){
                int high = (i == nums.length? upper+1: nums[i]);
                if(low + 2 == high){
                    list.add(String.valueOf(low + 1));
                }else if(low + 2 < high){
                    list.add(String.valueOf(low + 1) + "->" + String.valueOf(high - 1));
                }
                low = high;
            }
            return list;
        }
    }
}
