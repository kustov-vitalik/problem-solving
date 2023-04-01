package com.leetcode.problem.arrays;

import java.util.Arrays;

public class Problem152MaximumProductSubarray {

  public static void main(String[] args) {
    System.out.println(new Solution().maxProduct(new int[] {2,3,-2,4})); // 6
    System.out.println(new Solution().maxProduct(new int[] {-2,0,-1})); // 0
  }

  static class Solution {
    public int maxProduct(int[] nums) {
      if (nums.length == 1) {
        return nums[0];
      }

      return 0;
    }
  }

}
