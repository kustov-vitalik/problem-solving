package com.leetcode.problem.binarysearcg;

/**
 * <a href="https://leetcode.com/problems/valid-perfect-square/">Problem description</a>
 */
public class Solved_Problem367ValidPerfectSquare {

  public static void main(String[] args) {
    System.out.println(new Solution().isPerfectSquare(16)); // true
    System.out.println(new Solution().isPerfectSquare(13)); // false
    System.out.println(new Solution().isPerfectSquare(1)); // true
    System.out.println(new Solution().isPerfectSquare(Integer.MAX_VALUE));
  }

  static class Solution {
    public boolean isPerfectSquare(int num) {

      int left = 1;
      int right = num;
      int med;
      while (left <= right) {
        med = (left + right) >>> 1;

        long square = (long) med * med;
        if (square == num) {
          return true;
        }

        if (square < num) {
          left = med + 1;
        } else {
          right = med - 1;
        }
      }

      return false;
    }
  }

}
