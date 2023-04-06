package com.leetcode.problem.graph;

import com.leetcode.common.Utils;

/**
 * <a href="https://leetcode.com/problems/01-matrix/description/">Problem description</a>
 */
public class Solved_Problem54201Matrix {

  public static void main(String[] args) {

    Utils.printMatrix(new Solution().updateMatrix(new int[][]{
        {0, 0, 0},
        {0, 1, 0},
        {0, 0, 0},
    })); //[[0,0,0],[0,1,0],[0,0,0]]

    System.out.println("");

    Utils.printMatrix(new Solution().updateMatrix(new int[][]{
        {0, 0, 0},
        {0, 1, 0},
        {1, 1, 1},
    })); //[[0,0,0],[0,1,0],[1,2,1]]

    System.out.println("");

    Utils.printMatrix(new Solution().updateMatrix(new int[][]{
        {1, 1, 1},
        {1, 1, 0},
        {1, 1, 1},
    }));


  }

  static class Solution {

    public int[][] updateMatrix(int[][] mat) {
      int[][] dp = new int[mat.length][mat[0].length];

      final int MAX = mat.length * mat[0].length;

      for (int i = 0; i < mat.length; i++) {
        for (int j = 0; j < mat[i].length; j++) {
          if (mat[i][j] == 1) {
            dp[i][j] = MAX;
            int top = i > 0 ? dp[i - 1][j] + 1 : MAX;
            int left = j > 0 ? dp[i][j - 1] + 1 : MAX;
            dp[i][j] = Math.min(top, left);
          }
        }
      }

      for (int i = mat.length - 1; i >= 0; i--) {
        for (int j = mat[i].length - 1; j >= 0; j--) {
          if (mat[i][j] == 1) {
            dp[i][j] = Math.min(
                dp[i][j],
                Math.min(
                    Math.min(i < dp.length - 1 ? dp[i + 1][j] + 1 : MAX, MAX),
                    Math.min(j < dp[0].length - 1 ? dp[i][j + 1] + 1 : MAX, MAX)
                )
            );
          }
        }
      }

      return dp;
    }
  }

}
