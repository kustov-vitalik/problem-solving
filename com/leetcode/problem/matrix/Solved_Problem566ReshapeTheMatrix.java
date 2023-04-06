package com.leetcode.problem.matrix;

import com.leetcode.common.Utils;

/**
 * <a href="https://leetcode.com/problems/reshape-the-matrix">Problem description</a>
 */
public class Solved_Problem566ReshapeTheMatrix {

  public static void main(String[] args) {
    Utils.printMatrix(new Solution().matrixReshape(new int[][]{
        {1,2},
        {3,4}
    }, 1, 4));

    Utils.printMatrix(new Solution().matrixReshape(new int[][]{
        {1,2},
        {3,4}
    }, 4, 1));
  }

  static class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {

      if (r * c != mat.length * mat[0].length) {
        return mat;
      }

      int[] temp = new int[r*c];
      int[][] reshaped = new int[r][c];
      for (int i = 0; i < mat.length; i++) {
        System.arraycopy(mat[i], 0, temp, i * mat[i].length, mat[i].length);
      }


      for (int l = 0; l < reshaped.length; l++) {
        System.arraycopy(temp, l * reshaped[l].length, reshaped[l], 0, reshaped[l].length);
      }

      return reshaped;
    }
  }
}
