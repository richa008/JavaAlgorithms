package com.java.ctci.problems.stacks;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by richa on 12/18/16.
 *
 */
public class SetOfStacks {

    private static final int STACK_SIZE = 3;
    private ArrayList<Stack<Integer>> stacks;

    SetOfStacks(){
        stacks = new ArrayList<Stack<Integer>>();
    }

    private Stack<Integer> getLastStack(){
        return stacks.get(stacks.size() - 1);
    }

    private boolean isStackFull(Stack<Integer> stack){
        return (stack.size() >= STACK_SIZE);
    }

    private void createNewStackWithValue(int value){
        Stack<Integer> newStack = new Stack<Integer>();
        newStack.push(value);
        stacks.add(newStack);
    }

    public void push(int value){

        Stack<Integer> lastStack = getLastStack();

        if(stacks.size() == 0){
            createNewStackWithValue(value);
        }

        if(lastStack != null && !isStackFull(lastStack)){
            lastStack.push(value);
        }else{
            createNewStackWithValue(value);
        }
    }

    public Integer pop(){

        if(stacks.size() == 0){
            return null;
        }
        Stack<Integer> lastStack = getLastStack();
        if(lastStack == null || lastStack.isEmpty()){
            return null;
        }
        Integer value = lastStack.pop();
        if(lastStack.size() == 0){
            stacks.remove(stacks.size() - 1);
        }
        return value;
    }


}
