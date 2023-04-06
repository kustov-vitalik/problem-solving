package com.leetcode.problem.dynamicprogramming;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/delete-and-earn/">Problem description</a>
 */
public class Solved_Problem740DeleteAndEarn {

  public static void main(String[] args) {
    System.out.println(new Solution().deleteAndEarn(new int[] {3,4,2})); // 6
    System.out.println(new Solution().deleteAndEarn(new int[] {2,2,3,3,3,4})); // 9
  }

  static class Solution {

    public int deleteAndEarn(int[] nums) {
      if (nums.length == 1) {
        return nums[0];
      }

      int[] data = new int[10_001];
      for (int num : nums) {
        data[num] += num;
      }

      int[] dp = new int[data.length];
      dp[0] = data[0];
      dp[1] = Math.max(data[1], dp[0]);

      for (int i = 2; i < dp.length; i++) {
        dp[i] = Math.max(dp[i-1], dp[i-2] + data[i]);
        dp[i-1] = Math.max(dp[i-1], dp[i-2]);
      }

      System.out.println(Arrays.toString(data));
      System.out.println(Arrays.toString(dp));


      return dp[dp.length - 1];
    }
  }

}
