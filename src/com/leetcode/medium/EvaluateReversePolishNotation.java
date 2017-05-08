package com.leetcode.medium;

import java.util.Stack;

/**
 * Created by richa on 5/8/17.
 *
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.

 Valid operators are +, -, *, /. Each operand may be an integer or another expression.

 Some examples:
 ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
 ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
 */
public class EvaluateReversePolishNotation {
    public class Solution {
        public int evalRPN(String[] tokens) {
            Stack<Integer> stack = new Stack<Integer>();

            for(String token : tokens){
                if("+".equals(token)){
                    int sum = stack.pop() + stack.pop();
                    stack.push(sum);
                }
                else if("-".equals(token)){
                    int num1 = stack.pop();
                    int num2 = stack.pop();
                    stack.push(num2 - num1);
                }
                else if("*".equals(token)){
                    int val = stack.pop() * stack.pop();
                    stack.push(val);
                }
                else if("/".equals(token)){
                    int num1 = stack.pop();
                    int num2 = stack.pop();
                    stack.push(num2/num1);
                }else{
                    stack.push(Integer.parseInt(token));
                }
            }
            return stack.pop();
        }
    }
}
