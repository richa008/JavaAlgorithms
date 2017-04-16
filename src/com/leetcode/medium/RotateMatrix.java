package com.leetcode.medium;

/**
 * Created by richa on 4/16/17.
 *
 * You are given an n x n 2D matrix representing an image.

 Rotate the image by 90 degrees (clockwise).

 Follow up:
 Could you do this in-place?
 */
public class RotateMatrix {

    public class Solution {
        public void rotate(int[][] matrix) {
            //Transpose matrix
            //Flip matrix horizontally
            int n = matrix.length;
            for(int i = 0; i < n; i++){
                for(int j = i+1; j < n; j++){
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = temp;
                }
            }

            for(int i = 0; i < n; i++){
                for(int j = 0; j < n/2; j++){
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[i][n-1-j];
                    matrix[i][n-1-j] = temp;
                }
            }
        }
    }
}
