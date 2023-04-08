package com.leetcode.problem.dynamicprogramming;

/**
 * <a href="https://leetcode.com/problems/maximum-product-subarray/">Problem description</a>
 */
public class Solved_Problem152MaximumProductSubarray {

  public static void main(String[] args) {
    System.out.println(new Solution().maxProduct(new int[]{2})); // 2
    System.out.println(new Solution().maxProduct(new int[]{2, 3, -2, 4})); // 6
    System.out.println(new Solution().maxProduct(new int[]{-2, 0, -1})); // 0
    System.out.println(new Solution().maxProduct(new int[]{1, -3, -1, -2, -4, -5})); // 40
    System.out.println(
        new Solution().maxProduct(new int[]{1, -3, -1, 0, -4, -5, 0, 1, 6, 7})); // 42
    System.out.println(
        new Solution().maxProduct(new int[]{1, -3, -1, 0, -4, -5, 0, 1, 6, 7, 0})); // 42
    System.out.println(
        new Solution().maxProduct(new int[]{1, -3, -1, 0, -4, -5, 0, 1, 6, 7, 0, 0})); // 42
    System.out.println(new Solution().maxProduct(new int[]{0, 2})); // 2
    System.out.println(new Solution().maxProduct(new int[]{0, 0, 0, 0, 2})); // 2
  }

  static class Solution {

    public int maxProduct(int[] nums) {

      int n = nums.length;
      int result = nums[0];
      int leftProduct = 0;
      int rightProfuct = 0;

      for (int i = 0; i < n; i++) {
        leftProduct = (leftProduct == 0 ? 1 : leftProduct) * nums[i];
        rightProfuct = (rightProfuct == 0 ? 1 : rightProfuct) * nums[n - 1 - i];
        result = Math.max(result, Math.max(leftProduct, rightProfuct));
      }
      return result;

    }
  }
}
