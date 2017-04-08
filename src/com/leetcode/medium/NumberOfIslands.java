package com.leetcode.medium;

/**
 * Created by richa on 4/8/17.
 *
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

 Example 1:

 11110
 11010
 11000
 00000
 Answer: 1

 Example 2:

 11000
 11000
 00100
 00011
 Answer: 3
 */
public class NumberOfIslands {
    public class Solution {
        public int numIslands(char[][] grid) {

            int m = grid.length;
            if(m == 0){
                return 0;
            }
            int n = grid[0].length;
            int visited[][] = new int[m][n], count = 0;

            for(int i = 0; i < m; i++){
                for(int j = 0; j < n; j++){
                    if(visited[i][j] == 0 && grid[i][j] == '1'){
                        count++;
                        dfs(i, j, grid, visited, m, n);
                    }
                }
            }
            return count;
        }

        public void dfs(int i, int j, char grid[][], int visited[][],int m, int n){
            int dir[][] = {{-1,0}, {0,1}, {1,0}, {0,-1}};
            visited[i][j] = 1;
            for(int k = 0; k < dir.length; k++){
                int x = dir[k][0] + i;
                int y = dir[k][1] + j;
                if(x >= 0 && y >= 0 && x < m && y < n && visited[x][y] == 0 && grid[x][y] == '1'){
                    dfs(x,y,grid,visited,m,n);
                }
            }
        }
    }
}
