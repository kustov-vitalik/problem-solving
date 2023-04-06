package com.leetcode.problem.binarysearcg;

/**
 * <a href="https://leetcode.com/problems/sqrtx/">Problem description</a>
 */
public class Solved_Problem69SqrtX {

  public static void main(String[] args) {
    System.out.println(new Solution().mySqrt(4)); // 2
    System.out.println(new Solution().mySqrt(8)); // 2
  }

  static class Solution {
    public int mySqrt(int x) {

      int left = 0;
      int right = x;
      int mid;
      while (left <= right) {
        mid = (left + right) >>> 1;

        long square = (long) mid * mid;
        if (square == x) {
          return mid;
        }

        if (square > x) {
          right = mid - 1;
        } else {
          left = mid + 1;
        }
      }

      return left - 1;
    }
  }
}
