package com.leetcode.easy;

import java.util.HashSet;

/**
 * Created by richa on 4/8/17.
 *
 * Write an algorithm to determine if a number is "happy".

 A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.

 Example: 19 is a happy number

 12 + 92 = 82
 82 + 22 = 68
 62 + 82 = 100
 12 + 02 + 02 = 1
 */
public class HappyNumber {
    public class Solution {
        // Add square of digits to set. If number cannot be added (repeats), it is not a happy number
        public boolean isHappy(int n) {
            HashSet<Integer> set = new HashSet<Integer>();

            while(set.add(n)){
                int sumSquares = 0;
                while(n > 0){
                    int r = n % 10;
                    sumSquares += r * r;
                    n = n/10;
                }

                if(sumSquares == 1){
                    return true;
                }
                n = sumSquares;
            }
            return false;
        }
    }
}
