package com.crackingCodingInterview.problems.stacks;

import java.util.Stack;

/**
 * Created by richa on 12/18/16.
 *
 */
public class StackProblems {

    /**
     * Sort stack in ascending order using another stack
     * @param stack - Stack to be sorted
     *
     *  @return sorted stack
     */
    public Stack<Integer> sortStack(Stack<Integer> stack){

        Stack<Integer> sortedStack = new Stack<Integer>();

        while (!stack.empty()){
            int v1 = stack.pop();
            if(!sortedStack.empty()){
                int v2 = sortedStack.peek();
                if(v1 < v2){
                    while (!sortedStack.empty()){
                        stack.push(sortedStack.pop());
                    }
                }
                sortedStack.push(v1);
            }
        }
        return sortedStack;
    }
}
