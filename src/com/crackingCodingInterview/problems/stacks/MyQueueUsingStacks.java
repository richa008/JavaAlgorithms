package com.crackingCodingInterview.problems.stacks;

import java.util.Stack;

/**
 * Created by richa on 12/18/16.
 *
 * Implement Queue using 2 stacks
 */
public class MyQueueUsingStacks {

    private Stack<Integer> pushStack = new Stack<Integer>();
    private Stack<Integer> popStack = new Stack<Integer>();

    public void enqueue(int value){
        pushStack.push(value);
    }

    public Integer dequeue(){
        if(popStack.isEmpty()){
            if(pushStack.isEmpty()){
                return null;
            }

            while (!pushStack.empty()){
                int v = pushStack.pop();
                popStack.push(v);
            }
        }
        return popStack.pop();
    }
}
