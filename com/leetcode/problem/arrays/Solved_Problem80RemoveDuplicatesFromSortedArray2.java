package com.leetcode.problem.arrays;

public class Solved_Problem80RemoveDuplicatesFromSortedArray2 {

  public static void main(String[] args) {
    System.out.println(new Solved_Problem80RemoveDuplicatesFromSortedArray2().removeDuplicates(
        new int[]{1, 1, 1, 2, 2, 3, 4, 5, 5, 5, 5, 6}));
    System.out.println(new Solved_Problem80RemoveDuplicatesFromSortedArray2().removeDuplicates(
        new int[]{1, 1}));
  }

  public int removeDuplicates(int[] nums) {

    if (nums.length == 1) {
      return 1;
    }

    int aPointer = 0;
    for (int i = 1; i < nums.length - 1; i++) {
      if (nums[i] != nums[i + 1] || (nums[i] == nums[i + 1] && nums[aPointer] != nums[i + 1])) {
        aPointer++;
        nums[aPointer + 1] = nums[i + 1];
      }
    }

    return aPointer + 2;
  }


}
