package com.leetcode.easy;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;

/**
 * Created by richa on 3/23/17.
 *
 Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 */
public class ValidParenthesis {

    public class Solution {
        public boolean isValid(String s) {
            Deque<Character> stack = new ArrayDeque<Character>();

            HashMap<Character, Character> map = new HashMap<Character, Character>();
            map.put('(', ')');
            map.put('{', '}');
            map.put('[', ']');

            for(int i = 0; i < s.length(); i++){
                char c = s.charAt(i);
                if(map.containsKey(c)){
                    stack.push(c);
                }else{
                    if(stack.isEmpty()){
                        return false;
                    }
                    char openBracket = stack.pop();
                    if(!map.containsKey(openBracket) || map.get(openBracket) != c){
                        return false;
                    }
                }
            }

            if(stack.size() > 0){
                return false;
            }
            return true;
        }
    }
}
