package com.leetcode.problem.strings;

public class Problem8StringToIntegerAtoi {

  public static void main(String[] args) {
    System.out.println(new Solution().myAtoi("42")); // 42
    System.out.println(new Solution().myAtoi("       -42  ")); // -42
    System.out.println(new Solution().myAtoi("4193 bla bla bla")); // 4193
  }

  static class Solution {
    public int myAtoi(String s) {
      return 0;
    }
  }

}
