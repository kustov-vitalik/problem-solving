package com.leetcode.problem.math;

/**
 * <a href="https://leetcode.com/problems/sign-of-the-product-of-an-array">Problem description</a>
 */
public class Solved_Problem1822SignOfTheProductOfAnArray {

  static class Solution {
    public int arraySign(int[] nums) {

      int negativesCount = 0;
      for (int num : nums) {
        if (num < 0) {
          negativesCount++;
        } else if (num == 0) {
          return 0;
        }
      }

      return negativesCount % 2 == 0 ? 1 : -1;
    }
  }

}
