package com.leetcode.problem.dynamicprogramming;

/**
 * <a href="https://leetcode.com/problems/maximum-sum-circular-subarray/">Problem description</a>
 */
public class Solved_Problem918MaximumSumCircularSubarray {

  public static void main(String[] args) {
    System.out.println(new Solution().maxSubarraySumCircular(new int[]{1, -2, 3, -2})); // 3
    System.out.println(new Solution().maxSubarraySumCircular(new int[]{5, -3, 5})); // 10
    System.out.println(new Solution().maxSubarraySumCircular(new int[]{-3, -2, -3})); // -2
    System.out.println(new Solution().maxSubarraySumCircular(new int[]{-100, -101})); // -100
    System.out.println(new Solution().maxSubarraySumCircular(new int[]{3, 3, 4, -3, 3, -5, 3})); // 13
    System.out.println(new Solution().maxSubarraySumCircular(new int[]{-2,-3,-1})); // -1
    System.out.println(new Solution().maxSubarraySumCircular(new int[]{-5,3,5})); // 8
    System.out.println(new Solution().maxSubarraySumCircular(new int[]{2,-2,2,7,8,0})); // 19
  }

  static class Solution {

    public int maxSubarraySumCircular(int[] nums) {
      if (nums.length == 1) {
        return nums[0];
      }

      int minNum = Integer.MAX_VALUE;
      int maxNum = Integer.MIN_VALUE;
      int sum = 0;
      for (int num : nums) {
        minNum = Math.min(minNum, num);
        maxNum = Math.max(maxNum, num);
        sum += num;
      }

      if (minNum >= 0) {
        return sum;
      } else if (maxNum < 0) {
        return maxNum;
      }

      int prev = nums[0];
      int current;
      int min = prev;
      for (int i = 1; i < nums.length; i++) {
        current = Math.min(nums[i], prev + nums[i]);
        min = Math.min(min, current);
        prev = current;
      }

      prev = nums[0];
      int max = prev;
      for (int i = 1; i < nums.length; i++) {
        current = Math.max(nums[i], prev + nums[i]);
        max = Math.max(max, current);
        prev = current;
      }

      return min == sum ? max : Math.max(max, sum - min);
    }

    public int maxSubarraySumCircularForNSquareTime(int[] nums) {
      if (nums.length == 1) {
        return nums[0];
      }

      int minNum = Integer.MAX_VALUE;
      int maxNum = Integer.MIN_VALUE;
      int sum = 0;
      for (int num : nums) {
        minNum = Math.min(minNum, num);
        maxNum = Math.max(maxNum, num);
        sum += num;
      }

      if (minNum >= 0) {
        return sum;
      } else if (maxNum < 0) {
        return maxNum;
      }

      int max = Integer.MIN_VALUE;
      int prev;
      int current;
      for (int start = 0; start < nums.length; start++) {
        prev = nums[start];
        for (int i = 1; i < nums.length; i++) {
          current = Math.max(nums[(start + i) % nums.length],
              prev + nums[(start + i) % nums.length]);
          max = Math.max(max, current);

          prev = current;
        }
      }

      return max;
    }
  }
}
