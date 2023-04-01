package com.leetcode.problem.arrays;

public class Solved_Problem53MaximumSubarray {

  public static void main(String[] args) {
    System.out.println(new Solution().maxSubArray(new int[] {-2,1,-3,4,-1,2,1,-5,4})); // 6
    System.out.println(new Solution().maxSubArray(new int[] {1})); // 1
    System.out.println(new Solution().maxSubArray(new int[] {5,4,-1,7,8})); // 23
  }

  static class Solution {
    public int maxSubArray(int[] nums) {
      if (nums.length == 1) {
        return nums[0];
      }

      int max = Integer.MIN_VALUE;
      int localMax = 0;
      for (int i = 0; i < nums.length; i++) {
        localMax = Math.max(localMax + nums[i], nums[i]);
        max = Math.max(max, localMax);
      }

      return max;
    }
  }

}
