package com.leetcode.problem.dynamicprogramming;

/**
 * <a href="https://leetcode.com/problems/house-robber-ii/">Problem description</a>
 */
public class Solved_Problem213HouseRobber2 {

  public static void main(String[] args) {
    System.out.println(new Solution().rob(new int[]{2, 3, 2}) == 3); // 3
    System.out.println(new Solution().rob(new int[]{1, 2, 3, 1}) == 4); // 4
    System.out.println(new Solution().rob(new int[]{1, 2, 3}) == 3); // 3
    System.out.println(new Solution().rob(new int[]{1}) == 1); // 1
    System.out.println(new Solution().rob(new int[]{1, 2, 1, 1}) == 3); // 3
    System.out.println(new Solution().rob(new int[]{1, 1, 1, 2}) == 3); // 3
    System.out.println(new Solution().rob(new int[]{1, 3, 1, 3, 100}) == 103); // 103
    System.out.println(new Solution().rob(new int[]{2, 7, 9, 3, 1}) == 11); // 11
    System.out.println(new Solution().rob(new int[]{2, 2, 4, 3, 2, 5}) == 10); // 10
    System.out.println(new Solution().rob(new int[]{4, 1, 2, 7, 5, 3, 1}) == 14); // 14
    System.out.println(new Solution().rob(new int[]{2, 1, 1, 2}) == 3); // 3
    System.out.println(new Solution().rob(
        new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}) == 0); // 0
  }

  static class Solution {

    public int rob(int[] nums) {
      if (nums.length == 1) {
        return nums[0];
      }
      if (nums.length == 2) {
        return Math.max(nums[0], nums[1]);
      }

      int[] dpInclFirst = new int[nums.length];
      dpInclFirst[0] = nums[0];
      dpInclFirst[1] = Math.max(nums[1], nums[0]);

      int[] dpExclFirst = new int[nums.length];
      dpExclFirst[0] = 0;
      dpExclFirst[1] = nums[1];
      for (int i = 2; i < dpExclFirst.length; i++) {
        dpInclFirst[i] = Math.max(dpInclFirst[i - 1], dpInclFirst[i - 2] + nums[i]);
        dpExclFirst[i] = Math.max(dpExclFirst[i - 1], dpExclFirst[i - 2] + nums[i]);
      }

      return Math.max(dpInclFirst[dpInclFirst.length - 2], dpExclFirst[dpExclFirst.length - 1]);
    }


    private int deepSearchMaxSum(int[] nums, int currentPosition, boolean includeFirst,
        int[] cache) {
      if (currentPosition == 0) {
        return cache[currentPosition] = includeFirst ? nums[0] : 0;
      }

      if (currentPosition == 1) {
        return cache[currentPosition] = Math.max(nums[1],
            deepSearchMaxSum(nums, 0, includeFirst, cache));
      }

      if (cache[currentPosition] > 0) {
        return cache[currentPosition];
      }

      cache[currentPosition] = Math.max(
          nums[currentPosition] + deepSearchMaxSum(nums, currentPosition - 2, includeFirst, cache),
          deepSearchMaxSum(nums, currentPosition - 1, includeFirst, cache)
      );

      return cache[currentPosition];
    }

  }

}
