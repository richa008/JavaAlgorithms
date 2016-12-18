package com.java.ctci.problems.stacks;

import java.util.Stack;

/**
 * Created by richa on 12/18/16.
 *
 * Stack with a min() function that returns the min() element. Push, pop and min should all run in O(1)
 */
public class MinStack extends Stack<Integer>{

    private Stack<Integer> s2 = new Stack<Integer>();

    public void push(int value){
        if(value <= min()){
            s2.push(value);
        }

        super.push(value);
    }

    public Integer pop(){
        int value = super.pop();
        if(min() == value){
            s2.pop();
        }
        return value;
    }

     public Integer min(){
        if(!s2.empty()){
            return s2.peek();
        }
        return Integer.MAX_VALUE;
    }
}
