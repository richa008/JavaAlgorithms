package com.leetcode.medium;

import java.util.HashSet;
import java.util.List;

/**
 * Created by richa on 4/21/17.
 *
 */
public class WordLadder {
    public class Solution {
        public int ladderLength(String beginWord, String endWord, List<String> wordList) {

            if(wordList == null || wordList.size() == 0){
                return 0;
            }

            HashSet<String> beginSet = new HashSet<String>();
            HashSet <String> endSet = new HashSet<String>();
            HashSet <String> visited = new HashSet<String>();

            beginSet.add(beginWord);
            endSet.add(endWord);

            if(!wordList.contains(endWord)){
                return 0;
            }

            int len = 1;

            while(!beginSet.isEmpty() && !endSet.isEmpty()){

                if(beginSet.size() > endSet.size()){ //Two way BFS, helps with speed
                    HashSet <String> temp = beginSet;
                    beginSet = endSet;
                    endSet = temp;
                }

                HashSet <String> temp = new HashSet<String>();
                for(String word: beginSet){
                    char array[] = word.toCharArray();

                    for(int i = 0; i < array.length; i++){

                        for(char c = 'a'; c < 'z'; c++){
                            char old = array[i];
                            array[i] = c;
                            String nextWord = String.valueOf(array);

                            if(endSet.contains(nextWord)){
                                return len + 1;
                            }

                            if(!visited.contains(nextWord) && wordList.contains(nextWord)){
                                visited.add(nextWord);
                                temp.add(nextWord);
                            }
                            array[i] = old;
                        }
                    }
                }
                beginSet = temp;
                len++;
            }
            return 0;
        }
    }
}
