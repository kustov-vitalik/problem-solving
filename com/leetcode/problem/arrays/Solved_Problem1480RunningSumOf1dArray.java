package com.leetcode.problem.arrays;

public class Solved_Problem1480RunningSumOf1dArray {

  public static void main(String[] args) {

  }

  static class Solution {
    public int[] runningSum(int[] nums) {

      if (nums.length == 0) {
        return new int[0];
      }

      int[] runningSum = new int[nums.length];

      int sum = 0;

      for (int i = 0; i < nums.length; i++) {
        sum += nums[i];
        runningSum[i] = sum;
      }

      return runningSum;

    }
  }

}
