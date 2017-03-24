package com.leetcode.easy;

public class Solution {
    public String longestPalindrome(String s) {
        
        int len = 0;
        String result = "";
        
        for(int i = 0; i < s.length(); i++){
            if(isPalindrome(s, i - len - 1, i)){
                result = s.substring(i - len - 1, i+1);
                len = len + 2;
            }else if(isPalindrome(s, i - len, i)){
                result = s.substring(i - len, i+1);
                len = len + 1;
            }
        }
        
        return result;
    }
    
    public boolean isPalindrome(String s, int start, int end){
        if(start < 0){
            return false;
        }
        
        while(start < end){
            if(s.charAt(start++) != s.charAt(end--)){
                return false;
            }
        }
        return true;
    }
}