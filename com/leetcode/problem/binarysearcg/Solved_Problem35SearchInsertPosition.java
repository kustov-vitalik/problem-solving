package com.leetcode.problem.binarysearcg;

public class Solved_Problem35SearchInsertPosition {

  public static void main(String[] args) {
    System.out.println(new Solved_Problem35SearchInsertPosition().searchInsert(new int[] {1,3,5,6}, 5)); // 2
    System.out.println(new Solved_Problem35SearchInsertPosition().searchInsert(new int[] {1,3,5,6}, 2)); // 1
    System.out.println(new Solved_Problem35SearchInsertPosition().searchInsert(new int[] {1,3,5,6}, 7)); // 4
  }

  public int searchInsert(int[] nums, int target) {

    int left = 0, right = nums.length - 1;
    int idx;

    while (left <= right) {

      idx = left + (right - left)/2;

      if (nums[idx] == target) {
        return idx;
      } else if (nums[idx] < target) {
        left = idx + 1;
      } else {
        right = idx - 1;
      }

    }

    return right + 1;

  }
}
