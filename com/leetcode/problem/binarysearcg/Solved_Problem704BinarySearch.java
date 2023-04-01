package com.leetcode.problem.binarysearcg;

public class Solved_Problem704BinarySearch {

  public static void main(String[] args) {
    System.out.println(new Solution().search(new int[] {-1,0,3,5,9,12}, 9)); // 4
    System.out.println(new Solution().search(new int[] {5}, 5)); // 0
    System.out.println(new Solution().search(new int[] {1,2,3}, 4)); // -1
  }

  static class Solution {
    public int search(int[] nums, int target) {

      int left = 0;
      int right = nums.length - 1;
      int mid;

      while (left <= right) {

        mid = (left + right) >>> 1;

        if (nums[mid] == target) {
          return mid;
        } else if (nums[mid] < target) {
          left = mid + 1;
        } else {
          right = mid - 1;
        }
      }

      return -1;

    }
  }

}
