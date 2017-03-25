package com.leetcode.hard;

/**
 * Created by richa on 3/24/17.
 *
 * Given a string, find the length of the longest substring T that contains at most k distinct characters.

 For example, Given s = “eceba” and k = 2,

 T is "ece" which its length is 3.
 */
public class LongestSubstringWithAtmostKDistantCharacters {
    public class Solution {
        public int lengthOfLongestSubstringKDistinct(String s, int k) {
            int count[] = new int[256];
            int res = 0, j = 0, num = 0;

            for(int i = 0; i < s.length(); i++){
                if(count[s.charAt(i)] == 0){
                    num++;
                }
                count[s.charAt(i)]++;
                if(num > k){
                    while(j < s.length() && --count[s.charAt(j++)] > 0);
                    num--;
                }
                res = Math.max(res, i - j + 1);
            }
            return res;
        }
    }
}
