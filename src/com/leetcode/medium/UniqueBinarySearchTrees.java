package com.leetcode.medium;

/**
 * Created by richa on 4/9/17.
 *
 * Given n, how many structurally unique BST's (binary search trees) that store values 1...n?

 For example,
 Given n = 3, there are a total of 5 unique BST's.

 1         3     3      2      1
 \       /     /      / \      \
 3     2     1      1   3      2
 /     /       \                 \
 2     1         2                 3
 */
public class UniqueBinarySearchTrees {
    public class Solution {
        public int numTrees(int n) {
            int dp[] = new int[n+1];
            dp[0] = 1;
            dp[1] = 1;
            for(int level = 2; level <= n; level++){
                for(int i = 1; i <= level; i++){
                    dp[level] += dp[level-i]*dp[i-1];
                }
            }
            return dp[n];
        }
    }
}
