package com.leetcode.easy;

/**
 * Created by richa on 3/23/17.
 *
 * The count-and-say sequence is the sequence of integers beginning as follows:
 1, 11, 21, 1211, 111221, ...

 1 is read off as "one 1" or 11.
 11 is read off as "two 1s" or 21.
 21 is read off as "one 2, then one 1" or 1211.
 Given an integer n, generate the nth sequence.

 Note: The sequence of integers will be represented as a string.
 */
public class CountAndSay {
    public class Solution {
        public String countAndSay(int n) {

            String sb = new String("1");
            int num = 1;

            while(num < n){
                int count = 1;
                StringBuilder temp = new StringBuilder("");
                for(int i = 0; i < sb.length(); i++){
                    if((i + 1) >= sb.length()){
                        temp.append(count);
                        temp.append(sb.charAt(i));
                        count = 1;
                    }else{
                        if(sb.charAt(i) == sb.charAt(i+1)){
                            count++;
                        }else{
                            temp.append(count);
                            temp.append(sb.charAt(i));
                            count = 1;
                        }
                    }
                }
                sb = temp.toString();
                num++;
            }
            return sb;

        }
    }
}
