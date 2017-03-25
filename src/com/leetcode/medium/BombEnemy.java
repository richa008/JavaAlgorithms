package com.leetcode.medium;

/**
 * Created by richa on 3/24/17.
 *
 * Given a 2D grid, each cell is either a wall 'W', an enemy 'E' or empty '0' (the number zero), return the maximum enemies you can kill using one bomb.
 The bomb kills all the enemies in the same row and column from the planted point until it hits the wall since the wall is too strong to be destroyed.
 Note that you can only put the bomb at an empty cell.

 Example:
 For the given grid

 0 E 0 0
 E 0 W E
 0 E 0 0

 return 3. (Placing a bomb at (1,1) kills 3 enemies)
 */
public class BombEnemy {
    public class Solution {
        public int maxKilledEnemies(char[][] grid) {

            if(grid == null || grid.length == 0 || grid[0].length == 0){
                return 0;
            }

            int row = 0, rows = grid.length, cols = grid[0].length, max = 0;
            int tempCols[] = new int[cols];

            for(int i = 0; i < rows; i++){
                for(int j = 0; j < cols; j++){
                    if(j == 0 || grid[i][j-1] == 'W'){
                        row = getEnemiesForRow(grid, i, j, cols);
                    }
                    if(i == 0 || grid[i-1][j] == 'W'){
                        tempCols[j] = getEnemiesForCol(grid, i, j, rows);
                    }
                    if(grid[i][j] == '0'){
                        max = Math.max(row + tempCols[j], max);
                    }
                }
            }
            return max;
        }

        private int getEnemiesForRow(char grid[][], int i, int j, int cols){
            int num = 0;
            while(j < cols && grid[i][j] != 'W'){
                if(grid[i][j] == 'E'){
                    num++;
                }
                j++;
            }
            return num;
        }

        private int getEnemiesForCol(char grid[][], int i, int j, int rows){
            int num = 0;
            while(i < rows && grid[i][j] != 'W'){
                if(grid[i][j] == 'E'){
                    num++;
                }
                i++;
            }
            return num;
        }
    }
}
