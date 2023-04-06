package com.leetcode.problem.math;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/can-make-arithmetic-progression-from-sequence/">Problem description</a>
 */
public class Solved_Problem1502CanMakeArithmeticProgressionFromSequence {

  public static void main(String[] args) {

  }

  static class Solution {
    public boolean canMakeArithmeticProgression(int[] arr) {
      Arrays.sort(arr);
      int diff = arr[1] - arr[0];

      if (arr[arr.length - 1] != arr[0] + diff * (arr.length - 1)) {
        return false;
      }

      for (int i = 0; i < arr.length - 1; i++) {
        if (arr[i + 1] - arr[i] != diff) {
          return false;
        }
      }

      return true;
    }
  }

}
