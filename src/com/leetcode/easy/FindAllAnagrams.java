package com.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by richa on 4/16/17.
 *
 * Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.

 Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.

 The order of output does not matter.

 Example 1:

 Input:
 s: "cbaebabacd" p: "abc"

 Output:
 [0, 6]

 Explanation:
 The substring with start index = 0 is "cba", which is an anagram of "abc".
 The substring with start index = 6 is "bac", which is an anagram of "abc".
 Example 2:

 Input:
 s: "abab" p: "ab"

 Output:
 [0, 1, 2]

 Explanation:
 The substring with start index = 0 is "ab", which is an anagram of "ab".
 The substring with start index = 1 is "ba", which is an anagram of "ab".
 The substring with start index = 2 is "ab", which is an anagram of "ab".

 //Sliding window
 */
public class FindAllAnagrams {
    public class Solution {
        public List<Integer> findAnagrams(String s, String p) {
            ArrayList <Integer> result = new ArrayList<Integer>();
            if(s == null || p == null || s.length() == 0 || p.length() == 0){
                return result;
            }

            int charArray[] = new int[256];
            for(char c : p.toCharArray()){
                charArray[c]++;
            }

            int left = 0, right = 0, count = p.length();
            while(right < s.length()){
                char c = s.charAt(right++);
                if(charArray[c] > 0){
                    count--;
                }
                charArray[c]--;

                if(count == 0){
                    result.add(left);
                }

                if(right - left == p.length()){
                    char lchar = s.charAt(left++);
                    if(charArray[lchar] >= 0){
                        count++;
                    }
                    charArray[lchar]++;
                }
            }
            return result;

        }
    }
}
