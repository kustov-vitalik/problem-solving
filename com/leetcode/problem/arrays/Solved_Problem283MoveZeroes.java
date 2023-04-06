package com.leetcode.problem.arrays;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/move-zeroes/">Problem description</a>
 */
public class Solved_Problem283MoveZeroes {

  public static void main(String[] args) {
    var nums = new int[] {0,1,0,3,12};
    new Solution().moveZeroes(nums);
    System.out.println(Arrays.toString(nums));

    nums = new int[] {1,1};
    new Solution().moveZeroes(nums);
    System.out.println(Arrays.toString(nums));

  }

  static class Solution {
    public void moveZeroes(int[] nums) {
      if (nums.length == 1) {
        return;
      }

      int pointer = 0;
      int zeroCounter = 0;
      for (int i = 0; i < nums.length; i++) {
        if (nums[i] != 0) {
          if (nums[pointer] != nums[i]) {
            nums[pointer] = nums[i];
          }
          pointer++;
        } else {
          zeroCounter++;
        }
      }

      for (int i = 0; i < zeroCounter; i++) {
        nums[nums.length - 1 - i] = 0;
      }

    }
  }

}
