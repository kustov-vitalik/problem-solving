package com.leetcode.problem.arrays;

import java.util.Arrays;

public class Solved_Problem238ProductOfArrayExceptSelf {

  public static void main(String[] args) {
    System.out.println(Arrays.toString(new Solution().productExceptSelf(new int[] {1,2,3,4}))); // [24, 12, 8, 6]
    System.out.println(Arrays.toString(new Solution().productExceptSelf(new int[] {-1,1,0,-3,-3}))); // [0,0,9,0,0]
  }

  static class Solution {
    public int[] productExceptSelf(int[] nums) {

      int[] output = new int[nums.length];

      output[0] = 1;
      for (int i = 0; i < nums.length - 1; i++) {
        output[i + 1] = output[i] * nums[i];
      }

      int rightProd = 1;
      for (int i = nums.length - 1; i >= 0; i--) {
        output[i] *= rightProd;
        rightProd *= nums[i];
      }

      return output;

    }
  }

}
