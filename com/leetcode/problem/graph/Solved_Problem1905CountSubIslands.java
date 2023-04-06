package com.leetcode.problem.graph;

/**
 * <a href="https://leetcode.com/problems/count-sub-islands/">Problem description</a>
 */
public class Solved_Problem1905CountSubIslands {

  public static void main(String[] args) {
    System.out.println(new Solution().countSubIslands(new int[][]{
        {1,1,1,0,0},
        {0,1,1,1,1},
        {0,0,0,0,0},
        {1,0,0,0,0},
        {1,1,0,1,1},
    }, new int[][]{
        {1,1,1,0,0},
        {0,0,1,1,1},
        {0,1,0,0,0},
        {1,0,1,1,0},
        {0,1,0,1,0},
    })); //3

    System.out.println(new Solution().countSubIslands(new int[][]{
        {1,0,1,0,1},
        {1,1,1,1,1},
        {0,0,0,0,0},
        {1,1,1,1,1},
        {1,0,1,0,1},
    }, new int[][]{
        {0,0,0,0,0},
        {1,1,1,1,1},
        {0,1,0,1,0},
        {0,1,0,1,0},
        {1,0,0,0,1},
    })); //2
  }

  static class Solution {
    public int countSubIslands(int[][] grid1, int[][] grid2) {

      int counter = 0;

      for (int i = 0; i < grid1.length; i++) {
        for (int j = 0; j < grid1[i].length; j++) {
          if (isSubIsland(grid2, i, j, grid1)) {
            counter++;
          }
        }
      }

      return counter;
    }

    private boolean isSubIsland(int[][] grid, int i, int j, int[][] coverGrid) {

      if (i < 0 || i > grid.length - 1 || j < 0 || j > grid[i].length - 1 || grid[i][j] == 0) {
        return false;
      }

      if (coverGrid[i][j] == 0) {
        clean(grid, i, j);
        return false;
      }

      return cleanAndGetMatches(grid, i, j, coverGrid);
    }

    private void clean(int[][] grid, int i, int j) {
      if (i < 0 || i > grid.length - 1 || j < 0 || j > grid[i].length - 1 || grid[i][j] == 0) {
        return;
      }

      grid[i][j] = 0;
      clean(grid, i-1, j);
      clean(grid, i+1, j);
      clean(grid, i, j-1);
      clean(grid, i, j+1);
    }

    private boolean cleanAndGetMatches(int[][] grid, int i, int j, int[][] coverGrid) {
      if (i < 0 || i > grid.length - 1 || j < 0 || j > grid[i].length - 1 || grid[i][j] == 0) {
        return true;
      }

      if (coverGrid[i][j] == 0) {
        clean(grid, i, j);
        return false;
      }

      grid[i][j] = 0;

      boolean b1 = cleanAndGetMatches(grid, i-1, j, coverGrid);
      boolean b2 = cleanAndGetMatches(grid, i+1, j, coverGrid);
      boolean b3 = cleanAndGetMatches(grid, i, j-1, coverGrid);
      boolean b4 = cleanAndGetMatches(grid, i, j+1, coverGrid);

      return  b1 && b2 && b3 && b4;

    }
  }
}
