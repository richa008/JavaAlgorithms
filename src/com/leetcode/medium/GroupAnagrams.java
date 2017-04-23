package com.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by richa on 4/22/17.
 *
 * Given an array of strings, group anagrams together.

 For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"],
 Return:

 [
 ["ate", "eat","tea"],
 ["nat","tan"],
 ["bat"]
 ]

 */
public class GroupAnagrams {
    public class Solution {

        public List<List<String>> groupAnagrams(String[] strs) {

            HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();

            for(String str : strs){
                char array[] = str.toCharArray();
                Arrays.sort(array);
                String sortedStr = String.valueOf(array);
                if(!map.containsKey(sortedStr)){
                    map.put(sortedStr, new ArrayList<String>());
                }
                map.get(sortedStr).add(str);
            }
            return new ArrayList<List<String>>(map.values());
        }
    }
}
