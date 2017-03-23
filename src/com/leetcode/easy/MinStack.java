package com.leetcode.easy;

import java.util.Stack;

/**
 * Created by richa on 3/23/17.
 *
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

 push(x) -- Push element x onto stack.
 pop() -- Removes the element on top of the stack.
 top() -- Get the top element.
 getMin() -- Retrieve the minimum element in the stack.
 Example:
 MinStack minStack = new MinStack();
 minStack.push(-2);
 minStack.push(0);
 minStack.push(-3);
 minStack.getMin();   --> Returns -3.
 minStack.pop();
 minStack.top();      --> Returns 0.
 minStack.getMin();   --> Returns -2.
 */
public class MinStack {

    private Stack<Integer> minStack;

    private int minValue;

    /** initialize your data structure here. */
    public MinStack() {
        minStack = new Stack<Integer>();
        minValue = Integer.MAX_VALUE;
    }

    public void push(int x) {
        if(x <= minValue){
            minStack.push(minValue);
            minValue = x;
        }
        minStack.push(x);
    }

    public void pop() {
        if(minValue ==  minStack.pop()){
            minValue = minStack.pop();
        }
    }

    public int top() {
        return minStack.peek();
    }

    public int getMin() {
        return minValue;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
