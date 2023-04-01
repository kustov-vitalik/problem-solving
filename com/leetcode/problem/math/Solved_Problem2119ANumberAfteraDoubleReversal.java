package com.leetcode.problem.math;

public class Solved_Problem2119ANumberAfteraDoubleReversal {

  static class Solution {
    public boolean isSameAfterReversals(int num) {
      return !(num > 0 && num % 10 == 0);
    }
  }

}
