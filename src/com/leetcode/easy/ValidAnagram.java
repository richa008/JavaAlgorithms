package com.leetcode.easy;

/**
 * Created by richa on 3/23/17.
 *
 * Given two strings s and t, write a function to determine if t is an anagram of s.

 For example,
 s = "anagram", t = "nagaram", return true.
 s = "rat", t = "car", return false.
 */
public class ValidAnagram {
    public class Solution {
        public boolean isAnagram(String s, String t) {

            int charArray[] = new int[256];

            for(int i = 0; i < s.length(); i++){
                char c = s.charAt(i);
                charArray[c]++;
            }

            for(int i = 0; i < t.length(); i++){
                char c = t.charAt(i);
                charArray[c]--;
                if(charArray[c] < 0){
                    return false;
                }
            }

            for(int i = 0; i < charArray.length; i++){
                if(charArray[i] > 0){
                    return false;
                }
            }
            return true;
        }
    }
}
