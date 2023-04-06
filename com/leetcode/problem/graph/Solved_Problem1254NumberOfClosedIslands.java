package com.leetcode.problem.graph;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/number-of-closed-islands/">Problem description</a>
 */
public class Solved_Problem1254NumberOfClosedIslands {

  public static void main(String[] args) {
    System.out.println(new Solution().closedIsland(new int[][]{
        {1,1,1,1,1,1,1,0},
        {1,0,0,0,0,1,1,0},
        {1,0,1,0,1,1,1,0},
        {1,0,0,0,0,1,0,1},
        {1,1,1,1,1,1,1,0}
    })); // 2

    System.out.println(new Solution().closedIsland(new int[][]{
        {0,0,1,0,0},
        {0,1,0,1,0},
        {0,1,1,1,0}
    })); // 1

    int[][] grid = {
        {0, 0, 1, 1, 0, 1, 0, 0, 1, 0},
        {1, 1, 0, 1, 1, 0, 1, 1, 1, 0},
        {1, 0, 1, 1, 1, 0, 0, 1, 1, 0},
        {0, 1, 1, 0, 0, 0, 0, 1, 0, 1},
        {0, 0, 0, 0, 0, 0, 1, 1, 1, 0},
        {0, 1, 0, 1, 0, 1, 0, 1, 1, 1},
        {1, 0, 1, 0, 1, 1, 0, 0, 0, 1},
        {1, 1, 1, 1, 1, 1, 0, 0, 0, 0},
        {1, 1, 1, 0, 0, 1, 0, 1, 0, 1},
        {1, 1, 1, 0, 1, 1, 0, 1, 1, 0}
    };
    System.out.println(new Solution().closedIsland(grid)); // 5

    for (int i = 0; i < grid.length; i++) {
      System.out.println(Arrays.toString(grid[i]));
    }
  }

  static class Solution {
    public int closedIsland(int[][] grid) {

      int numberOfClosedIslands = 0;

      for (int i = 0; i < grid.length; i++) {
        for (int j = 0; j < grid[i].length; j++) {
          if (isClosedIsland(grid, i, j)) {
            numberOfClosedIslands++;
          }
        }
      }


      return numberOfClosedIslands;
    }

    private boolean isClosedIsland(int[][] grid, int i, int j) {
      if (i < 0 || i > grid.length - 1 || j < 0 || j > grid[i].length - 1) {
        return false;
      }

      boolean isLand = grid[i][j] == 0;

      if (isLand) {
        return !cleanAndGetTouchesBounds(grid, i, j);
      }

      return false;
    }

    /**
     * Return true if clean process touches bounds
     */
    private boolean cleanAndGetTouchesBounds(int[][] grid, int i, int j) {
      if (i < 0 || i > grid.length - 1 || j < 0 || j > grid[i].length - 1) {
        return true;
      }

      boolean isLand = grid[i][j] == 0;
      if (isLand) {
        grid[i][j] = 1;
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
