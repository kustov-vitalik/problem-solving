package com.leetcode.problem.matrix;

public class Solved_Problem329LongestIncreasingPathInMatrix {

  public static void main(String[] args) {
    Solution problem = new Solution();
    System.out.println(
        problem.longestIncreasingPath(new int[][]{{9, 9, 4}, {6, 6, 8}, {2, 1, 1}})); // 4
    System.out.println(
        problem.longestIncreasingPath(new int[][]{{3, 4, 5}, {3, 2, 6}, {2, 2, 1}})); // 4
    System.out.println(problem.longestIncreasingPath(new int[][]{{1}})); // 1
    System.out.println(problem.longestIncreasingPath(new int[][]{{0}, {1}, {5}, {5}})); // 3
    System.out.println(problem.longestIncreasingPath(new int[][]{
        {18, 4, 19, 15, 8, 8, 10, 4, 9, 5},
        {2, 13, 10, 11, 2, 7, 0, 9, 0, 16},
        {2, 10, 18, 2, 17, 18, 18, 18, 10, 3},
        {5, 17, 14, 5, 19, 19, 7, 19, 1, 8},
        {11, 18, 9, 4, 12, 1, 19, 18, 11, 2}}
    )); // 5
    System.out.println(problem.longestIncreasingPath(new int[][]{
        {1, 2, 3, 4, 5, 6, 7, 8, 9, 10},
        {20, 19, 18, 17, 16, 15, 14, 13, 12, 11},
        {21, 22, 23, 24, 25, 26, 27, 28, 29, 30},
        {40, 39, 38, 37, 36, 35, 34, 33, 32, 31},
        {41, 42, 43, 44, 45, 46, 47, 48, 49, 50}}
    )); // 50
  }

  static class Solution {

    int[][] cache;

    public int longestIncreasingPath(int[][] matrix) {
      if (matrix.length == 1 && matrix[0].length == 1) {
        return 1;
      }

      int maxLen = 0;

      cache = new int[matrix.length][matrix[0].length];

      for (int i = 0; i < matrix.length; i++) {
        for (int j = 0; j < matrix[i].length; j++) {
          if (cache[i][j] == 0) {

            int localMax = maxLen(matrix, i, j);
            cache[i][j] = localMax;
            maxLen = Math.max(maxLen, localMax);
          }
        }
      }

//      for (int[] ints : cache) {
//        System.out.println(Arrays.toString(ints));
//      }

      return maxLen;
    }


    private int maxLen(int[][] matrix, int i, int j) {
      if (cache[i][j] > 0) {
        return cache[i][j];
      }

      int value = matrix[i][j];

      int maxU = 0;
      int maxD = 0;
      int maxL = 0;
      int maxR = 0;
      if (i - 1 >= 0) {
        int up = matrix[i - 1][j];
        if (up > value) {
          maxU = maxLen(matrix, i - 1, j);
          cache[i - 1][j] = maxU;
        }
      }
      if (i + 1 < matrix.length) {
        int down = matrix[i + 1][j];
        if (down > value) {
          maxD = maxLen(matrix, i + 1, j);
          cache[i + 1][j] = maxD;
        }
      }
      if (j - 1 >= 0) {
        int left = matrix[i][j - 1];
        if (left > value) {
          maxL = maxLen(matrix, i, j - 1);
          cache[i][j - 1] = maxL;
        }
      }
      if (j + 1 < matrix[i].length) {
        int right = matrix[i][j + 1];
        if (right > value) {
          maxR = maxLen(matrix, i, j + 1);
          cache[i][j + 1] = maxR;
        }
      }

      if (maxL == 0 && maxR == 0 && maxU == 0 && maxD == 0) {
        cache[i][j] = 1;
      }

      return 1 + Math.max(Math.max(maxU, maxD), Math.max(maxL, maxR));
    }
  }

}
