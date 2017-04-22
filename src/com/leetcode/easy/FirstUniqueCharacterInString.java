package com.leetcode.easy;

/**
 * Created by richa on 4/18/17.
 *
 * Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.

 Examples:

 s = "leetcode"
 return 0.

 s = "loveleetcode",
 return 2.

 */
public class FirstUniqueCharacterInString {
    public class Solution {
        public int firstUniqChar(String s) {
            if(s == null || s.length() == 0){
                return -1;
            }
            int freq[] = new int[256];
            for(int i = 0; i < s.length(); i++){
                freq[s.charAt(i)-'a']++;
            }

            for(int i = 0; i < s.length(); i++){
                if(freq[s.charAt(i) - 'a'] == 1){
                    return i;
                }
            }
            return -1;
        }
    }
}
