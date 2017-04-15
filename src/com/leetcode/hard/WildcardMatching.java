package com.leetcode.hard;

/**
 * Created by richa on 4/11/17.
 *
 * '?' Matches any single character.
 '*' Matches any sequence of characters (including the empty sequence).

 The matching should cover the entire input string (not partial).

 The function prototype should be:
 bool isMatch(const char *s, const char *p)

 Some examples:
 isMatch("aa","a") → false
 isMatch("aa","aa") → true
 isMatch("aaa","aa") → false
 isMatch("aa", "*") → true
 isMatch("aa", "a*") → true
 isMatch("ab", "?*") → true
 isMatch("aab", "c*a*b") → false
 */
public class WildcardMatching {
    public class Solution {
        public boolean isMatch(String s, String p) {
            int startIdx = -1, matched = 0, sPtr = 0, pPtr = 0;

            while(sPtr < s.length()){
                if(pPtr < p.length() && (s.charAt(sPtr) == p.charAt(pPtr) || (p.charAt(pPtr) == '?'))){
                    sPtr++;
                    pPtr++;
                }
                else if((pPtr < p.length()) && p.charAt(pPtr) == '*'){
                    startIdx = pPtr;
                    pPtr++;
                    matched = sPtr;
                }
                else if(startIdx != -1){
                    pPtr = startIdx + 1;
                    matched++;
                    sPtr = matched;
                }
                else{
                    return false;
                }
            }

            while(pPtr < p.length() && p.charAt(pPtr) == '*'){
                pPtr++;
            }

            return (pPtr == p.length());
        }
    }
}
