package com.leetcode.easy;

/**
 * Created by richa on 3/23/17.
 *
 * The Hamming distance between two integers is the number of positions at which the corresponding bits are different.

 Given two integers x and y, calculate the Hamming distance.
 */
public class HammingDistance {
    public class Solution {
        public int hammingDistance(int x, int y) {
            return Integer.bitCount(x ^y);
        }
    }
}
