package com.leetcode.problem.math;

public class Problem1137NthTribonacciNumber {

  public static void main(String[] args) {
    System.out.println(new Solution().tribonacci(4)); // 4
    System.out.println(new Solution().tribonacci(25)); // 1389537
  }

  static class Solution {
    public int tribonacci(int n) {
      int t0 = 0;
      int t1 = 1;
      int t2 = 1;

      if (n == 0) {
        return t0;
      }
      if (n == 1) {
        return t1;
      }
      if (n == 2) {
        return 1;
      }

      int result = 0;
      while (n > 2) {

        result = t0 + t1 + t2;

        t0 = t1;
        t1 = t2;
        t2 = result;

        n--;

      }

      return result;
    }
  }

}
