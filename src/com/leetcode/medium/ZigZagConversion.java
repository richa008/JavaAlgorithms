package com.leetcode.medium;

/**
 * Created by richa on 3/23/17.
 *
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

 P   A   H   N
 A P L S I I G
 Y   I   R
 And then read line by line: "PAHNAPLSIIGYIR"
 Write the code that will take a string and make this conversion given a number of rows:

 string convert(string text, int nRows);
 convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
 */
public class ZigZagConversion {
    public class Solution {
        public String convert(String s, int numRows) {

            StringBuilder array[] = new StringBuilder[numRows];

            if(numRows <= 1){
                return s;
            }

            for(int i = 0; i < numRows; i++){
                array[i] = new StringBuilder("");
            }

            boolean down = true;
            int rowNo = 0;

            for(int i = 0; i < s.length(); i++){
                array[rowNo].append(s.charAt(i));
                if(down){
                    rowNo++;
                }else{
                    rowNo--;
                }
                if(rowNo == 0){
                    down = true;
                }
                else if(rowNo == numRows - 1){
                    down = false;
                }
            }

            String result = "";
            for(int i = 0; i < array.length; i++){
                result = result + array[i];
            }
            return result;
        }
    }
}
