package com.leetcode.problem.math;

public class Solved_Problem509FibonacciNumber {

  public static void main(String[] args) {
    System.out.println(new Solution().fib(2)); // 1
    System.out.println(new Solution().fib(3)); // 2
    System.out.println(new Solution().fib(4)); // 3
  }

  static class Solution {
    public int fib(int n) {
      if (n == 0) {
        return 0;
      }

      if (n == 1) {
        return 1;
      }

      int prevPrev = 0;
      int prev = 1;

      int fib = 0;
      while (n > 1) {

        fib = prevPrev + prev;
        prevPrev = prev;
        prev = fib;

        n--;
      }

      return fib;
    }
  }

}
