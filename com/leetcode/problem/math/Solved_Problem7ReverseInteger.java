package com.leetcode.problem.math;

public class Solved_Problem7ReverseInteger {

  public static void main(String[] args) {
    System.out.println(new Solution().reverse(123) == 321);
    System.out.println(new Solution().reverse(-123) == -321);
    System.out.println(new Solution().reverse(1534236469) == 0);
    System.out.println(new Solution().reverse(1463847412) == 2147483641);
  }

  static class Solution {

    public int reverse(int x) {

      boolean negative = x < 0;
      if (negative) {
        x = -x;
      }

      int digit;
      int num = 0;
      while (x > 0) {
        digit = x % 10;

        if ((Integer.MAX_VALUE - digit) / 10 >= num) {
          num = 10 * num + digit;
        } else {
          return 0;
        }

        x /= 10;
      }

      return negative ? -num : num;
    }
  }
}
