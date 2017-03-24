package com.leetcode.easy;

/**
 * Created by richa on 3/23/17.
 *
 * Write a function that takes a string as input and returns the string reversed.

 Example:
 Given s = "hello", return "olleh".
 */
public class ReverseString {
    public class Solution {
        public String reverseString(String s) {
            char charArray[] = s.toCharArray();
            int j = charArray.length - 1;
            for(int i = 0; i < charArray.length/2; i++){
                char temp = charArray[i];
                charArray[i] = charArray[j];
                charArray[j] = temp;
                j--;
            }

            return (new String(charArray));
        }
    }
}
