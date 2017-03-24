package com.leetcode.medium;

/**
 * Created by richa on 3/23/17.
 *
 * Given an input string, reverse the string word by word.

 For example,
 Given s = "the sky is blue",
 return "blue is sky the".
 */
public class ReverseWordsInString {
    public class Solution {
        public String reverseWords(String s) {

            String[] parts = s.trim().split("\\s+");
            StringBuilder out = new StringBuilder();

            for (int i = parts.length - 1; i > 0; i--) {
                out.append(parts[i]);
                out.append(" ");
            }
            out.append(parts[0]);
            return out.toString();
        }
    }
}
