package com.leetcode.medium;

/**
 * Created by richa on 3/23/17.
 *
 * Given a non negative integer number num. For every numbers i in the range 0 ≤ i ≤ num calculate the number of 1's in their binary representation and return them as an array.

 Example:
 For num = 5 you should return [0,1,1,2,1,2].
 
 Index : 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15
 num : 0 1 1 2 1 2 2 3 1 2 2 3 2 3 3 4
 
 */
public class CountingBits {
    public class Solution {
        public int[] countBits(int num) {
            int pow = 1;
            int t = 0;
            int result[] = new int[num + 1];
            result[0] = 0;

            for(int i = 1; i <= num; i++){
                if(i == pow){
                    pow = pow * 2;
                    t = 0;
                }
                result[i] = result[t] + 1;
                t++;
            }
            return result;

        }
    }
}
