package com.crackingCodingInterview.problems;

import java.util.HashMap;

/**
 * Created by richa on 11/16/16.
 * CTCI Array and String Problems
 */
public class ArrayStringProblems {

    //TODO: Solve without using extra array

    /**
     * Determine if a string has unique characters
     * Assumption made - String is made of unicode characters
     *
     * @return - Returns true if the string has unique characters
     */
    public boolean doesStringHaveUniqueCharacters(String myString) {
        if (myString.length() > 128) {
            return false;
        }

        HashMap<Character, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < myString.length(); i++) {
            char c = myString.charAt(i);
            if (hashMap.get(c) != null) {
                return false;
            } else {
                hashMap.put(c, 1);
            }
        }
        return true;
    }

    /**
     * Determine if a string is a permutation of another string
     * Note: can also be solved by converting strings to arrays and sorting the arrays
     *
     * @return - Returns true if the string is permutation
     */
    public boolean areStringsPermutation(String string1, String string2) {

        if (string1.length() != string2.length()) {
            return false;
        }
        HashMap<Character, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < string1.length(); i++) {
            char c = string1.charAt(i);
            Integer val = hashMap.get(c);
            if (val == null) {
                hashMap.put(c, 1);
            } else {
                hashMap.put(c, ++val);
            }
        }

        for (int i = 0; i < string2.length(); i++) {
            char c = string2.charAt(i);
            Integer val = hashMap.get(c);
            if (val == null) {
                return false;
            }
            if (--val < 0) {
                return false;
            }
            hashMap.put(c, val);

        }
        return true;
    }

    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max = 0, index = 0;

        for(int i = 0; i < s.length(); i++){
            if(map.containsKey(s.charAt(i))){
                index = Math.max(index, s.charAt(i) + 1);
            }
            map.put(s.charAt(i), i);
            max = Math.max(max, i - index + 1);

        }
        return max;
    }

    public static void main(String args[]){
        ArrayStringProblems a = new ArrayStringProblems();

        a.lengthOfLongestSubstring("pwwkew");
    }

}

