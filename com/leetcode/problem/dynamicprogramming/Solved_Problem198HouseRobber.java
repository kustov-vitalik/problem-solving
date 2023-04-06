package com.leetcode.problem.dynamicprogramming;

/**
 * <a href="https://leetcode.com/problems/house-robber/">Problem Description</a>
 */
public class Solved_Problem198HouseRobber {

  public static void main(String[] args) {
    System.out.println(new Solution().rob(new int[] {1,2,3,1})); // 4
    System.out.println(new Solution().rob(new int[] {2,7,9,3,1})); // 12
    System.out.println(new Solution().rob(new int[] {2,1,1,2})); // 4
  }

  static class Solution {
    public int rob(int[] nums) {

      if (nums.length == 1) {
        return nums[0];
      }

      if (nums.length == 2) {
        return Math.max(nums[0], nums[1]);
      }

      int prevPrev = nums[0];
      int prev = nums[1];
      int current = 0;

      for (int i = 2; i < nums.length; i++) {
        current = prevPrev + nums[i];
        prevPrev = Math.max(prev, prevPrev);
        prev = current;
      }

      return Math.max(current, prevPrev);

    }
  }

}
