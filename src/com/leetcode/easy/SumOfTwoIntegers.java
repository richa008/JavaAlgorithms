package com.leetcode.easy;

/**
 * Created by richa on 3/23/17.
 *
 * Calculate the sum of two integers a and b, but you are not allowed to use the operator + and -.

 Example:
 Given a = 1 and b = 2, return 3.
 */
public class SumOfTwoIntegers {
    public class Solution {
        public int getSum(int a, int b) {
            if(b == 0){
                return a;
            }
            if(a == 0){
                return b;
            }
            while(b != 0){
                int carry = (a & b);
                a = a ^ b;
                b = carry << 1;
            }

            return a;
        }
    }
}
