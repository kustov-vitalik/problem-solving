package com.leetcode.problem;

public class RemoveDuplicatesFromSortedArray {

  public static void main(String[] args) {

  }

  public int removeDuplicates(int[] nums) {
    // 1 2 2 3 3
    // 1
    int p = 0;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] != nums[p]) {
        p++;
        nums[p] = nums[i];
      }
    }

    return p + 1;
  }



}
