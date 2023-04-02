package com.leetcode.problem.arrays;

import java.util.Arrays;

public class Solved_Problem977SquaresOfSortedArray {

  public static void main(String[] args) {

    int[] sortedSquares = new Solution().sortedSquares(new int[]{-4, -1, 0, 3, 10});
    System.out.println(Arrays.toString(sortedSquares));

    sortedSquares = new Solution().sortedSquares(new int[]{-4, -1});
    System.out.println(Arrays.toString(sortedSquares));

  }

  static class Solution {

    public int[] sortedSquares(int[] nums) {
      if (nums.length == 1) {
        return new int[]{nums[0] * nums[0]};
      }

      int[] result = new int[nums.length];

      int min = Integer.MAX_VALUE;
      int minPosition = -1;

      for (int i = 0; i < nums.length; i++) {
        nums[i] = nums[i] * nums[i];
        if (nums[i] < min) {
          min = nums[i];
          minPosition = i;
        }
      }

      int left;
      int right;
      if (minPosition == 0) {
        left = minPosition;
        right = minPosition + 1;
      } else {
        left = minPosition - 1;
        right = minPosition;
      }

      int pointer = 0;
      while (left >= 0 && right < nums.length) {
        var l = nums[left];
        var r = nums[right];
        if (l < r) {
          result[pointer] = l;
          left--;
        } else {
          result[pointer] = r;
          right++;
        }
        pointer++;
      }

      while (left >= 0) {
        var l = nums[left];
        result[pointer] = l;
        left--;
        pointer++;
      }

      while (right < nums.length) {
        var r = nums[right];
        result[pointer] = r;
        right++;
        pointer++;
      }

      return result;
    }
  }

}
