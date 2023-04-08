package com.leetcode.problem.dynamicprogramming;

/**
 * <a href="https://leetcode.com/problems/maximum-length-of-subarray-with-positive-product/">Problem description</a>
 */
public class Solved_Problem1567MaximumLengthOfSubarrayWithPositiveProduct {

  public static void main(String[] args) {
    System.out.println(new Solution().getMaxLen(new int[] {1,-2,-3,4})); // 4
    System.out.println(new Solution().getMaxLen(new int[] {0,1,-2,-3,-4})); // 3
    System.out.println(new Solution().getMaxLen(new int[] {-1,-2,-3,0,1})); // 2
    System.out.println(new Solution().getMaxLen(new int[] {0})); // 0
    System.out.println(new Solution().getMaxLen(new int[] {3})); // 1
    System.out.println(new Solution().getMaxLen(new int[] {-3})); // 0
    System.out.println(new Solution().getMaxLen(new int[] {-3,3})); // 1
    System.out.println(new Solution().getMaxLen(new int[] {-3,-3})); // 2
    System.out.println(new Solution().getMaxLen(new int[] {1000000000,1000000000})); // 2
  }

  static class Solution {
    public int getMaxLen(int[] nums) {
      if (nums.length == 1) {
        return nums[0] > 0 ? 1 : 0;
      }

      int maxLenLeftCurrent = 0;
      int maxLenLeft = 0;

      int maxLenRightCurrent = 0;
      int maxLenRight = 0;

      int rightProduct = 1;
      int leftProduct = 1;

      int number;

      for (int i = 0; i < nums.length; i++) {

        if (nums[i] > 0) {
          number = 1;
        } else if (nums[i] == 0) {
          number = 0;
        } else {
          number = -1;
        }

        leftProduct = (leftProduct == 0 ? 1 : leftProduct) * number;
        if (leftProduct != 0) {
          maxLenLeftCurrent++;
          if (leftProduct > 0) {
            maxLenLeft = Math.max(maxLenLeft, maxLenLeftCurrent);
          }
        } else {
          maxLenLeftCurrent = 0;
        }

        if (nums[nums.length - 1 - i] > 0) {
          number = 1;
        } else if (nums[nums.length - 1 - i] == 0) {
          number = 0;
        } else {
          number = -1;
        }


        rightProduct = (rightProduct == 0 ? 1 : rightProduct) * number;
        if (rightProduct != 0) {
          maxLenRightCurrent++;
          if (rightProduct > 0) {
            maxLenRight = Math.max(maxLenRight, maxLenRightCurrent);
          }
        } else {
          maxLenRightCurrent = 0;
        }
      }

      return Math.max(maxLenLeft, maxLenRight);
    }
  }
}
