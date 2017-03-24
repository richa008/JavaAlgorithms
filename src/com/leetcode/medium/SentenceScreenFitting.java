package com.leetcode.medium;

/**
 * Created by richa on 3/23/17.
 *
 * Given a rows x cols screen and a sentence represented by a list of non-empty words, find how many times the given sentence can be fitted on the screen.
 Input:
 rows = 2, cols = 8, sentence = ["hello", "world"]

 Output:
 1

 Explanation:
 hello---
 world---

 The character '-' signifies an empty space on the screen.
 Example 2:

 Input:
 rows = 3, cols = 6, sentence = ["a", "bcd", "e"]

 Output:
 2

 Explanation:
 a-bcd-
 e-a---
 bcd-e-

 The character '-' signifies an empty space on the screen.
 Example 3:

 Input:
 rows = 4, cols = 5, sentence = ["I", "had", "apple", "pie"]

 Output:
 1

 Explanation:
 I-had
 apple
 pie-I
 had--

 The character '-' signifies an empty space on the screen.
 */
public class SentenceScreenFitting {
    public class Solution {
        public int wordsTyping(String[] sentence, int rows, int cols) {
            int[] nextIndex = new int[sentence.length];
            int[] times = new int[sentence.length];
            for(int i=0;i<sentence.length;i++) {
                int curLen = 0;
                int cur = i;
                int time = 0;
                while(curLen + sentence[cur].length() <= cols) {
                    curLen += sentence[cur++].length()+1;
                    if(cur==sentence.length) {
                        cur = 0;
                        time ++;
                    }
                }
                nextIndex[i] = cur;
                times[i] = time;
            }
            int ans = 0;
            int cur = 0;
            for(int i=0; i<rows; i++) {
                ans += times[cur];
                cur = nextIndex[cur];
            }
            return ans;
        }
    }
    /*
    public class Solution {
    public int wordsTyping(String[] sentence, int rows, int cols) {
        int timesArray[] = new int[rows];
        int index = 0;
        for(int rowNo = 0; rowNo < rows; rowNo++){
            int len = 0, times = 0;

            while(len + sentence[index].length() <= cols){
                len += sentence[index].length() + 1;
                index++;
                if(index == sentence.length){
                    index = 0;
                    times++;
                }
            }
            timesArray[rowNo] = times;
        }
        int count = 0;
        for(int i = 0; i < timesArray.length; i++){
            count += timesArray[i];
        }
        return count;
    }
}
     */
}
