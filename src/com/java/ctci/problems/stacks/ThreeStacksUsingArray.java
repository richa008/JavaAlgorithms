package com.java.ctci.problems.stacks;

/**
 * Created by richa on 12/17/16.
 *
 *  Three stacks implemented using a single array
 */
public class ThreeStacksUsingArray {

    private int STACK_SIZE = 3;
    private int topsArray[] = {-1, -1, -1};

    int stackArray[] = new int[3 * STACK_SIZE];

    /**
     * Push a value on stack specified by stackIndex
     * @param stackIndex - Index of the stack, can be 1, 2 or 3
     * @param value - Value to be pushed
     *
     * @throws Exception when stack is full
     */
    public void push(int stackIndex, int value) throws Exception{
        int index = stackIndex - 1;

        if(topsArray[index] == STACK_SIZE - 1){
            throw new Exception("Stack is full");
        }
        topsArray[index]++;
        stackArray[getArrayIndex(index)] = value;
    }

    /**
     * Pop a value from stack specified by stackIndex
     * @param stackIndex - Index of the stack, can be 1, 2 or 3
     *
     * @throws Exception when stack is empty
     */
    public int pop(int stackIndex) throws Exception{
        int index = stackIndex - 1;

        if(topsArray[index] == -1){
            throw new Exception("Stack is empty");
        }
        int value = stackArray[getArrayIndex(index)];
        stackArray[getArrayIndex(index)] = 0;
        topsArray[index]--;

        return value;
    }

    private int getArrayIndex(int index){
        return index * STACK_SIZE + topsArray[index];
    }

    private void printStackArray(){
        for(int i = 0; i < stackArray.length; i++){
            System.out.println(stackArray[i]);
        }
    }

    public static void main(String args[]){

        //TODO Write unit tests for this
        ThreeStacksUsingArray s = new ThreeStacksUsingArray();
        try {

            s.push(1, 1);
            s.push(1, 2);
            s.push(1, 3);
            s.push(2, 3);
            s.push(3, 1);
            s.push(3, 1);
            s.push(3, 1);
            s.pop(2);
            s.pop(3);
            s.push(3, 2);

            s.printStackArray();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
}
