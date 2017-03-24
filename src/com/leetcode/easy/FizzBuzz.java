package com.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by richa on 3/23/17.
 *
 * Write a program that outputs the string representation of numbers from 1 to n.

 But for multiples of three it should output “Fizz” instead of the number and for the multiples of five output “Buzz”. For numbers which are multiples of both three and five output “FizzBuzz”.
 */
public class FizzBuzz {
    public class Solution {
        public List<String> fizzBuzz(int n) {

            List<String> strList = new ArrayList<String>();

            for(int i = 1; i <= n; i++){
                String s = ((i % 3) == 0 && (i % 5) == 0) ? "FizzBuzz" : (i % 3 == 0) ? "Fizz" : (i % 5 == 0) ? "Buzz" : Integer.toString(i);
                strList.add(s);
            }

            return strList;
        }
    }
}
