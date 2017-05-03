package com.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by richa on 5/1/17.
 *
 * Given a set of distinct integers, nums, return all possible subsets.

 Note: The solution set must not contain duplicate subsets.

 For example,
 If nums = [1,2,3], a solution is:

 [
 [3],
 [1],
 [2],
 [1,2,3],
 [1,3],
 [2,3],
 [1,2],
 []
 ]
 */
public class SubSets {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        backtrack(list, new ArrayList<Integer>(), nums, 0);
        return list;
    }

    void backtrack(List<List<Integer>> list, List<Integer> tempList, int nums[], int index){
        list.add(new ArrayList<Integer>(tempList));
        for(int i = index; i < nums.length; i++){
            tempList.add(nums[i]);
            backtrack(list, tempList, nums, i+1);
            tempList.remove(tempList.size() - 1);
        }
    }

    public static void main(String args[]){
        SubSets s = new SubSets();
        int array[] = {1,2,3};
        s.subsets(array);
    }
}
