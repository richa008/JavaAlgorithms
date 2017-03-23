package com.leetcode.medium;

import java.util.List;

/**
 * Created by richa on 3/23/17.
 *
 Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s can be segmented into a space-separated sequence of one or more dictionary words. You may assume the dictionary does not contain duplicate words.

 For example, given
 s = "leetcode",
 dict = ["leet", "code"].

 Return true because "leetcode" can be segmented as "leet code".

 UPDATE (2017/1/4):
 */
public class WordBreak {

    public class Solution {
        public boolean wordBreak(String s, List<String> wordDict) {

            boolean res[] = new boolean[s.length() + 1];
            res[0] = true;
            for(int i = 1; i <= s.length(); i++){
                for(int j = 0; j < i; j++){
                    String sub = s.substring(j, i);
                    if(res[j] && wordDict.contains(sub)){
                        res[i] = true;
                    }
                }
            }
            return res[s.length()];
        }
    }
}
