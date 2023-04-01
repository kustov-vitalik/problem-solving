package com.leetcode.problem.arrays;

import static java.lang.System.out;

import java.util.Arrays;

public class Solved_Problem41FirstMissingPositive {


  public static void main(String[] args) {
    out.println(new Solved_Problem41FirstMissingPositive().firstMissingPositive(new int[]{1, 2, 0})); // 3
    out.println(
        new Solved_Problem41FirstMissingPositive().firstMissingPositive(new int[]{3, 4, -1, 1})); // 2
    out.println(
        new Solved_Problem41FirstMissingPositive().firstMissingPositive(new int[]{4, 5, 6, 7, 8, 9})); // 1
    out.println(new Solved_Problem41FirstMissingPositive().firstMissingPositive(new int[]{1})); // 2
    out.println(new Solved_Problem41FirstMissingPositive().firstMissingPositive(new int[]{1, 1})); // 2
    out.println(new Solved_Problem41FirstMissingPositive().firstMissingPositive(new int[]{2, 1})); // 3
    out.println(new Solved_Problem41FirstMissingPositive().firstMissingPositive(new int[]{0})); // 1
  }

  public int firstMissingPositive(int[] nums) {

    int minPositive = Integer.MAX_VALUE;

    for (int num : nums) {
      if (num > 0) {
        minPositive = Math.min(minPositive, num);
      }
    }

    if (minPositive > 1) {
      return 1;
    } else {

      // clean nums
      for (int i = 0; i < nums.length; i++) {
        int num = nums[i];
        if (!(num >= 1 && num <= nums.length)) {
          nums[i] = 0;
        }
      }

//      out.println("Clean: " + Arrays.toString(nums));

      // sort nums
      for (int i = 0; i < nums.length; i++) {

        int val = nums[i];

        if (val == 0 || val - 1 == i) {
          continue;
        }

        nums[i] = 0;

        int next;
        do {
          next = nums[val - 1];
          nums[val - 1] = val;
          if (next == val) {
            break;
          }
          val = next;

        } while (val != 0);

      }

//      out.println("Sorted: " + Arrays.toString(nums));

      // case [1]
      if (nums.length == 1) {
        return 2;
      }

      // find 1st "0"
      for (int i = 0; i < nums.length; i++) {
        if (nums[i] == 0) {
          return i + 1;
        }
      }

      return nums.length + 1;

    }
  }

}
