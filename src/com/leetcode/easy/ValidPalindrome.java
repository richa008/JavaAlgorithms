package com.leetcode.easy;

/**
 * Created by richa on 4/8/17.
 *
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

 For example,
 "A man, a plan, a canal: Panama" is a palindrome.
 "race a car" is not a palindrome.
 */
public class ValidPalindrome {
    public class Solution {
        public boolean isPalindrome(String s) {
            String s1 = s.toLowerCase().replaceAll("\\W","");
            String rev = new StringBuffer(s1).reverse().toString();
            return s1.equals(rev);
        }
    }
}
