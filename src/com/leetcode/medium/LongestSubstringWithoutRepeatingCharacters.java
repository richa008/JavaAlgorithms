package com.leetcode.medium;

import java.util.HashMap;

/**
 * Created by richa on 3/23/17.
 *
 * Given a string, find the length of the longest substring without repeating characters.

 Examples:

 Given "abcabcbb", the answer is "abc", which the length is 3.

 Given "bbbbb", the answer is "b", with the length of 1.

 Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public class Solution {
        public int lengthOfLongestSubstring(String s) {
            if(s == null || s.length() == 0){
                return 0;
            }
            HashMap<Character, Integer> map = new HashMap<Character, Integer>();
            int max = 0, index = 0;

            for(int i = 0; i < s.length(); i++){
                if(map.containsKey(s.charAt(i))){
                    index = Math.max(index, map.get(s.charAt(i)) + 1);
                }
                map.put(s.charAt(i), i);
                max = Math.max(max, i - index + 1);

            }
            return max;
        }
    }
}
