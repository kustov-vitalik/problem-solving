package com.leetcode.problem.graph;

public class Solved_Problem200NumberOfIslands {

  public static void main(String[] args) {
    var result = new Solution().numIslands(new char[][]{
        {'1','1','1','1','0'},
        {'1','1','0','1','0'},
        {'1','1','0','0','0'},
        {'0','0','0','0','0'}
    });

    System.out.println(result); // 1
  }

  static class Solution {
    public int numIslands(char[][] grid) {

      int numOfIslands = 0;

      for (int i = 0; i < grid.length; i++) {
        for (int j = 0; j < grid[i].length; j++) {
          if (isIsland(grid, i, j)) {
            numOfIslands++;
          }
        }
      }

      return numOfIslands;

    }

    private boolean isIsland(char[][] grid, int i, int j) {
      if (i < 0 || i > grid.length - 1 || j < 0 || j > grid[i].length - 1 || grid[i][j] == '0') {
        return false;
      }

      boolean isIsland = grid[i][j] == '1';

      grid[i][j] = '0';

      isIsland(grid, i-1, j);
      isIsland(grid, i+1, j);
      isIsland(grid, i, j-1);
      isIsland(grid, i, j+1);

      return isIsland;
    }
  }

}
