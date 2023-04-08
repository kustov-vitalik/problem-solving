package com.leetcode.problem.arrays;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/richest-customer-wealth">Problem description</a>
 */
public class Solved_Problem1672RichestCustomerWealth {

  static class Solution {
    public int maximumWealth(int[][] accounts) {

      int max = Integer.MIN_VALUE;
      for (int[] account : accounts) {
        max = Math.max(max, Arrays.stream(account).sum());
      }
      return max;
    }
  }

}
