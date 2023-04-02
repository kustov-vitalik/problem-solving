package com.leetcode.problem.math;

public class Solved_Problem1281SubtractProductAndSumOfDigitsOfInteger {

  public static void main(String[] args) {
    System.out.println(new Solution().subtractProductAndSum(234)); // 15
    System.out.println(new Solution().subtractProductAndSum(4421)); // 21
  }

  static class Solution {
    public int subtractProductAndSum(int n) {

      int sum = 0;
      int prod = 1;
      while (n > 0) {
        int digit = n % 10;
        sum += digit;
        prod *= digit;
        n /= 10;
      }

      return prod - sum;

    }
  }

}
