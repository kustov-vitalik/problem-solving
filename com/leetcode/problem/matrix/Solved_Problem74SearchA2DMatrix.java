package com.leetcode.problem.matrix;

/**
 * <a href="https://leetcode.com/problems/search-a-2d-matrix/">Problem description</a>
 */
public class Solved_Problem74SearchA2DMatrix {

  public static void main(String[] args) {
    System.out.println(new Solution().searchMatrix(new int[][]{
        {1,3,5,7},
        {10,11,16,20},
        {23,30,34,60},
    }, 3)); // true

    System.out.println(new Solution().searchMatrix(new int[][]{
        {1,3,5,7},
        {10,11,16,20},
        {23,30,34,60},
    }, 60)); // true

    System.out.println(new Solution().searchMatrix(new int[][]{
        {1,3,5,7},
        {10,11,16,20},
        {23,30,34,60},
    }, 23)); // true

    System.out.println(new Solution().searchMatrix(new int[][]{
        {1,3,5,7},
        {10,11,16,20},
        {23,30,34,60},
    }, 20)); // true

    System.out.println(new Solution().searchMatrix(new int[][]{
        {1,3,5,7},
        {10,11,16,20},
        {23,30,34,60},
    }, 21)); // false

    System.out.println(new Solution().searchMatrix(new int[][]{
        {1},
    }, 1)); // true

    System.out.println(new Solution().searchMatrix(new int[][]{
        {1},
    }, 0)); // false
  }

  static class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

      int left = 0;
      int right = matrix.length - 1;
      int mid;
      while (left <= right) {
        mid = (left + right) >>> 1;

        if (matrix[mid][0] == target) {
          return true;
        }

        if (matrix[mid][0] < target) {
          left = mid + 1;
        } else {
          right = mid - 1;
        }
      }

      int row = Math.max(left - 1, 0);

      int l = 0;
      int r = matrix[row].length - 1;
      while (l <= r) {
        mid = (l + r) >>> 1;

        if (matrix[row][mid] == target) {
          return true;
        }

        if (matrix[row][mid] < target) {
          l = mid + 1;
        } else {
          r = mid - 1;
        }
      }

      return false;


    }
  }
}
