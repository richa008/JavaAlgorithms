package com.leetcode.medium;

/**
 * Created by richa on 4/9/17.
 *
 * Given a board with m by n cells, each cell has an initial state live (1) or dead (0). Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using the following four rules (taken from the above Wikipedia article):

 Any live cell with fewer than two live neighbors dies, as if caused by under-population.
 Any live cell with two or three live neighbors lives on to the next generation.
 Any live cell with more than three live neighbors dies, as if by over-population..
 Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
 Write a function to compute the next state (after one update) of the board given its current state.


 */
public class GameOfLife {
    public class Solution {
        public void gameOfLife(int[][] board) {
            int m = board.length;
            if(m == 0){
                return;
            }
            int n = board[0].length;

            for(int i = 0; i < m; i++){
                for(int j = 0; j < n; j++){
                    int liveNeighbors = getLiveNeighbors(i, j, m, n, board);
                    if((board[i][j] == 1) && (liveNeighbors == 2 || liveNeighbors == 3)){
                        board[i][j] = 3;
                    }else if(board[i][j] == 0 && liveNeighbors == 3){
                        board[i][j] = 2;
                    }
                }
            }

            for(int i = 0; i < m; i++){
                for(int j = 0; j < n; j++){
                    board[i][j] = board[i][j] >>> 1;
                }
            }
        }

        int getLiveNeighbors(int i, int j, int m, int n, int board[][]){
            int dirs[][] = {{-1,0}, {1,-1}, {0, 1}, {1, 1}, {1, 0}, {-1,1}, {0, -1}, {-1,-1}};
            int count = 0;
            for(int k = 0; k < dirs.length; k++){
                int x = i + dirs[k][0];
                int y = j + dirs[k][1];

                if(x >= 0 && y >= 0 && x < m && y < n && ((board[x][y] & 1) == 1)){
                    count++;
                }
            }
            return count;
        }
    }
}
