package com.leetcode.problem.dynamicprogramming;

public class Solved_Problem70ClimbingStairs {

  public static void main(String[] args) {
    System.out.println(new Solution().climbStairs(2)); // 2
    System.out.println(new Solution().climbStairs(3)); // 3
  }

  static class Solution {
    public int climbStairs(int n) {
      if (n == 1) {
        return 1;
      } else if (n == 2) {
        return 2;
      }

      int prevPrev = 1;
      int prev = 2;
      int result = 0;

      while (n > 2) {
        result = prev + prevPrev;
        prevPrev = prev;
        prev = result;
        n--;
      }

      return result;
    }
  }

}
