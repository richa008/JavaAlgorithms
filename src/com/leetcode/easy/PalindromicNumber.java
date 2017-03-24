package com.leetcode.easy;

/**
 * Created by richa on 3/23/17.
 *
 * Determine whether an integer is a palindrome. Do this without extra space.
 */
public class PalindromicNumber {
    public class Solution {
        public boolean isPalindrome(int x) {
            if(x < 0 || ((x > 0) && (x%10 == 0))){
                return false;
            }

            int result = 0;
            while(x > result){
                result = result *10 + x % 10;
                x = x/10;
            }
            return (x == result || (x == result/10));
        }
    }
}
