package com.leetcode.problem.matrix;

import com.leetcode.common.Utils;

/**
 * <a href="https://leetcode.com/problems/set-matrix-zeroes/">Problem description</a>
 */
public class Solved_Problem73SetMatrixZeroes {

  public static void main(String[] args) {
    var matrix = new int[][] {
        {1,1,1,1},
        {1,0,1,1},
        {1,1,1,1},
        {1,1,1,1},
        {1,1,1,1},
        {1,1,1,1},
    };
    new Solution().setZeroes(matrix);
    Utils.printMatrix(matrix);
  }

  static class Solution {
    public void setZeroes(int[][] matrix) {
      boolean[] rows = new boolean[matrix.length];
      boolean[] cols = new boolean[matrix[0].length];

      for (int i = 0; i < matrix.length; i++) {
        for (int j = 0; j < matrix[i].length; j++) {
          if (matrix[i][j] == 0) {
            rows[i] = true;
            cols[j] = true;
          }
        }
      }

      for (int i = 0; i < matrix.length; i++) {
        for (int j = 0; j < matrix[i].length; j++) {
          if (rows[i] || cols[j]) {
            matrix[i][j] = 0;
          }
        }
      }

    }
  }
}
