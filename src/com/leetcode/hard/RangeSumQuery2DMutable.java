package com.leetcode.hard;

/**
 * Created by richa on 3/24/17.
 */
public class RangeSumQuery2DMutable {
    public class NumMatrix {

        int matrix[][];
        int colSums[][];
        int m, n;

        public NumMatrix(int[][] matrix) {
            if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
                return;
            }
            m = matrix.length;
            n = matrix[0].length;
            this.matrix = matrix;
            colSums = new int[m+1][n];

            for(int i = 1; i < m+1; i++){
                for(int j = 0; j < n; j++){
                    colSums[i][j] = colSums[i-1][j] + matrix[i-1][j];
                }
            }
        }

        public void update(int row, int col, int val) {

            for(int i = row+1; i < m+1; i++){
                colSums[i][col] += val - matrix[row][col];
            }
            matrix[row][col] = val;
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            int sum = 0;
            for(int j = col1; j <= col2; j++){
                sum += colSums[row2+1][j] - colSums[row1][j];
            }
            return sum;
        }
    }

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * obj.update(row,col,val);
 * int param_2 = obj.sumRegion(row1,col1,row2,col2);
 */
}
