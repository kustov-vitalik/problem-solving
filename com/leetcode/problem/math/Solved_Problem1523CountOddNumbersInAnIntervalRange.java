package com.leetcode.problem.math;

public class Solved_Problem1523CountOddNumbersInAnIntervalRange {

  public static void main(String[] args) {
    System.out.println(new Solution().countOdds(21, 22));
  }

  static class Solution {
    public int countOdds(int low, int high) {
      if (low == high) {
        return low%2;
      }

      int len = (high - low + 1);

      if (len%2==0) {
        return len/2;
      }

      return len/2 + low%2;

    }
  }

}
