package com.leetcode.problem.arrays;

public class Solved_Problem26RemoveDuplicatesFromSortedArray {

  public static void main(String[] args) {
    System.out.println(new Solved_Problem26RemoveDuplicatesFromSortedArray().removeDuplicates(
        new int[]{1, 1, 2, 2, 2, 2, 2, 4, 4, 4})); // 2
  }

  public int removeDuplicates(int[] nums) {

    if (nums.length == 1) {
      return 1;
    }

    int pointer = 0;

    for (int i = 0; i < nums.length - 1; i++) {

      if (nums[i] == nums[i + 1]) {

      } else {
        pointer++;
        nums[pointer] = nums[i + 1];
      }

    }

    return pointer + 1;

  }

}
