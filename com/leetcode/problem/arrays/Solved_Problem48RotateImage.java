package com.leetcode.problem.arrays;

import java.util.Arrays;

public class Solved_Problem48RotateImage {

  public static void main(String[] args) {
    var matrix = new int[][]{
        {1,2,3},
        {4,5,6},
        {7,8,9}
    };
    new Solution().rotate(matrix);

    for (int[] row : matrix) {
      System.out.println(Arrays.toString(row));
      /*
      7,4,1
      8,5,2
      9,6,3
       */
    }

  }

  static class Solution {
    public void rotate(int[][] matrix) {

      // to mirror
      for (int i = 0; i < matrix.length; i++) {
        for (int j = i; j < matrix[i].length; j++) {
          int tmp = matrix[i][j];
          matrix[i][j] = matrix[j][i];
          matrix[j][i] = tmp;
        }
      }

      // swap rows
      for (int i = 0; i < matrix.length; i++) {
        for (int j = 0; j < matrix[i].length/2; j++) {
          int tmp = matrix[i][j];
          matrix[i][j] = matrix[i][matrix[i].length - 1 - j];
          matrix[i][matrix[i].length - 1 - j] = tmp;
        }
      }

    }
  }

}
