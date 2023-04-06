package com.leetcode.problem.dynamicprogramming;

/**
 * <a href="https://leetcode.com/problems/jump-game-ii/">Problem description</a>
 */
public class Solved_Problem45JumpGame2 {

  public static void main(String[] args) {
    System.out.println(new Solution().jump(new int[] {2,3,1,1,4})); // 2 ([0,1,1])
    System.out.println(new Solution().jump(new int[] {2,3,0,1,4})); // 2
    System.out.println(new Solution().jump(new int[] {1,1,1,1,1,1})); // 5
    System.out.println(new Solution().jump(new int[] {2,1})); // 1
  }

  static class Solution {
    public int jump(int[] nums) {

      if (nums.length == 1) {
        return 0;
      }

      int[] dp = new int[nums.length];
      dp[0] = 0;
      int currentMin;
      int currentPointer;

      for (int i = 0; i < nums.length - 1; i++) {

        currentMin = dp[i] + 1;
        currentPointer = i;
        for (int j = 1; j <= nums[currentPointer] && currentPointer + j < nums.length; j++) {
          if (dp[currentPointer + j] == 0) {
            dp[currentPointer + j] = currentMin;
          } else {
            dp[currentPointer + j] = Math.min(currentMin, dp[currentPointer + j]);
          }
        }
      }

      return dp[dp.length - 1];
    }
  }

}
