package com.leetcode.problem.graph;

public class Solved_Problem1020NumberOfEnclaves {

  public static void main(String[] args) {
    System.out.println(new Solution().numEnclaves(new int[][]{
        {0,0,0,0},
        {1,0,1,0},
        {0,1,1,0},
        {0,0,0,0},
    })); // 3
  }

  static class Solution {

    int counter;
    public int numEnclaves(int[][] grid) {

      counter = 0;
      int numOfEnclaves = 0;

      for (int i = 0; i < grid.length; i++) {
        for (int j = 0; j < grid[i].length; j++) {
          if (isEnclave(grid, i, j)) {
            numOfEnclaves += counter;
            counter = 0;
          }
        }
      }

      return numOfEnclaves;

    }

    private boolean isEnclave(int[][] grid, int i, int j) {
      if (i < 0 || i > grid.length - 1 || j < 0 || j > grid[i].length - 1) {
        return false;
      }

      boolean isLand = grid[i][j] == 1;
      if (isLand) {
        boolean touchesBounds = cleanAndGetTouchesBounds(grid, i, j);
        if (touchesBounds) {
          counter = 0;
        }
        return !touchesBounds;
      }

      return false;
    }

    private boolean cleanAndGetTouchesBounds(int[][] grid, int i, int j) {
      if (i < 0 || i > grid.length - 1 || j < 0 || j > grid[i].length - 1) {
        return true;
      }

      boolean isLand = grid[i][j] == 1;
      if (isLand) {
        grid[i][j] = 0;
        counter++;
        boolean b1 = cleanAndGetTouchesBounds(grid, i-1, j);
        boolean b2 = cleanAndGetTouchesBounds(grid, i+1, j);
        boolean b3 = cleanAndGetTouchesBounds(grid, i, j-1);
        boolean b4 = cleanAndGetTouchesBounds(grid, i, j+1);

        return b1 || b2 || b3 || b4;
      }

      return false;
    }
  }

}
