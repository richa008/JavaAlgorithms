package com.leetcode.easy;

/**
 * Created by richa on 3/23/17.
 *
 * You are climbing a stair case. It takes n steps to reach to the top.

 Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 */
public class ClimbingStairs {
    public class Solution {
        public int climbStairs(int n) {

            if(n == 0 || n == 1 || n == 2){return n;}
            int[] mem = new int[n];
            mem[0] = 1;
            mem[1] = 2;
            for(int i = 2; i < n; i++){
                mem[i] = mem[i-1] + mem[i-2];
            }
            return mem[n-1];
        }

    }
}
