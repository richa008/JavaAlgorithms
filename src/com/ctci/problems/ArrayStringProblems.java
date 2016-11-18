package com.ctci.problems;

/**
 * Created by richa on 11/16/16.
 * CTCI Array and String Problems
 */
public class ArrayStringProblems {

    //TODO: Solve without using extra array
    /**
     * Determine if a string has unique characters
     * Assumption made - String is made of unicode characters
     * @param - String
     * @return - Returns true if the string has unique characters
     */
    public boolean doesStringHaveUniqueCharacters(String myString){
        if(myString.length() > 128){
            return false;
        }

        boolean charArray[] = new boolean[256];
        for(int i = 0; i < myString.length(); i++){
            char c = myString.charAt(i);
            if(charArray[c]){
                return false;
            }else{
                charArray[c] = true;
            }
        }
        return true;
    }
}

