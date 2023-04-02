package com.leetcode.problem.arrays;

import java.util.Arrays;

public class Solved_Problem189RotateArray {

  public static void main(String[] args) {
    var array = new int[] {1,2,3,4,5,6,7};
    new Solution().rotate(array, 1);

    System.out.println(Arrays.toString(array)); // [5,6,7,1,2,3,4]
  }

  static class Solution {
    public void rotate(int[] nums, int k) {

      k = k % nums.length;

      //approach1(nums, k);
      approach2(nums, k);

    }

    /**
     * To mirror nums.
     * Then mirror 1st subarray [0, k-1]
     * Then mirror 1st subarray [k, len]
     */
    private void approach2(int[] nums, int k) {

      mirror(nums, 0, nums.length - 1);
      mirror(nums, 0, k - 1);
      mirror(nums, k, nums.length - 1);

    }

    private void mirror(int[] nums, int left, int right) {
      while (left < right) {
        var tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;

        left++;
        right--;
      }
    }

    /**
     * Idea: create array.len = k to store k tail values.
     * Move each element from (0, len-k) to the end of the array nums.
     * Copy array to the beginning of nums.
     */
    private void approach1(int[] nums, int k) {

    }
  }

}
