package com.leetcode.easy;

/**
 * Created by richa on 3/23/17.
 *
 * Reverse digits of an integer.

 Example1: x = 123, return 321
 Example2: x = -123, return -321
 */
public class ReverseInteger {
    public class Solution {
        public int reverse(int x) {

            int result = 0;
            while(x != 0){
                int mod = x % 10;
                int newResult = result * 10 + mod;
                if((newResult - mod)/10 != result){
                    return 0;
                }
                result = newResult;
                x = x/10;
            }
            return result;
        }
    }
}
