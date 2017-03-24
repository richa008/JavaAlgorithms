package com.leetcode.easy;

import java.util.HashMap;

/**
 * Created by richa on 3/23/17.
 *
 * Given a roman numeral, convert it to an integer.

 Input is guaranteed to be within the range from 1 to 3999.
 */
public class RomanToInteger {
    public class Solution {
        public int romanToInt(String s) {
            HashMap<Character, Integer> numeralMap = new HashMap<Character, Integer>();
            numeralMap.put('I', 1);
            numeralMap.put('V', 5);
            numeralMap.put('X', 10);
            numeralMap.put('L', 50);
            numeralMap.put('C', 100);
            numeralMap.put('D', 500);
            numeralMap.put('M', 1000);

            int result = 0;

            for(int i = 0; i < s.length(); i++){
                char c = s.charAt(i);
                int val = numeralMap.get(c);

                if((i + 1) < s.length()){
                    char nextC = s.charAt(i + 1);
                    int nextVal = numeralMap.get(nextC);
                    if(val < nextVal){
                        result = result - val;
                    }else{
                        result = result + val;
                    }
                }else{
                    result = result + val;
                }
            }
            return result;
        }
    }
}
