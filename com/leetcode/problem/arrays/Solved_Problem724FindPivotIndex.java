package com.leetcode.problem.arrays;

public class Solved_Problem724FindPivotIndex {

  public static void main(String[] args) {
    System.out.println(new Solution().pivotIndex(new int[] {1,7,3,6,5,6})); // 3
  }

  static class Solution {
    public int pivotIndex(int[] nums) {

      int[] rightSum = new int[nums.length + 1];

      int sum = 0;
      rightSum[nums.length] = 0;
      for (int i = nums.length - 1; i >= 0; i--) {
        sum += nums[i];
        rightSum[i] = sum;
      }

      sum = 0;
      for (int i = 0; i < nums.length; i++) {
        sum += nums[i];
        if (sum == rightSum[i]) {
          return i;
        }
      }

      return -1;
    }
  }

}
