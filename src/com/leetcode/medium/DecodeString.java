package com.leetcode.medium;

import java.util.Stack;

/**
 * Created by richa on 3/25/17.
 *
 * Given an encoded string, return it's decoded string.

 The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.

 You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.

 Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there won't be input like 3a or 2[4].

 Examples:

 s = "3[a]2[bc]", return "aaabcbc".
 s = "3[a2[c]]", return "accaccacc".
 s = "2[abc]3[cd]ef", return "abcabccdcdcdef".
 */
public class DecodeString {
    public class Solution {
        public String decodeString(String s) {
            Stack<Integer> countStack = new Stack<Integer>();
            Stack<String> resultStack = new Stack<String>();
            resultStack.push("");

            for(int i = 0; i < s.length(); i++){
                char ch = s.charAt(i);
                if (ch >= '0' && ch <= '9') {
                    int start = i;
                    while (s.charAt(i + 1) >= '0' && s.charAt(i + 1) <= '9') i++;
                    countStack.push(Integer.parseInt(s.substring(start, i + 1)));
                }else if (ch == '['){
                    resultStack.push("");
                }else if(ch == ']'){
                    StringBuilder sb = new StringBuilder();
                    int count = countStack.pop();
                    String temp = resultStack.pop();
                    for(int j = 0; j < count; j++){
                        sb.append(temp);
                    }
                    resultStack.push(resultStack.pop() + sb.toString());
                }else{
                    resultStack.push(resultStack.pop() + ch);
                }
            }
            return resultStack.pop();
        }
    }
}
