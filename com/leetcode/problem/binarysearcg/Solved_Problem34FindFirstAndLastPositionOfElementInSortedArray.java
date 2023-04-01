package com.leetcode.problem.binarysearcg;

import java.util.Arrays;

public class Solved_Problem34FindFirstAndLastPositionOfElementInSortedArray {

  public static void main(String[] args) {
    System.out.println(Arrays.toString(new Solution().searchRange(new int[] {5,7,7,8,8,10}, 8))); // [3,4]
    System.out.println(Arrays.toString(new Solution().searchRange(new int[] {5,7,7,8,8,10}, 6))); // [-1, -1]
    System.out.println(Arrays.toString(new Solution().searchRange(new int[] {}, 6))); // [-1, -1]
    System.out.println(Arrays.toString(new Solution().searchRange(new int[] {1}, 0))); // [-1, -1]
    System.out.println(Arrays.toString(new Solution().searchRange(new int[] {1}, 1))); // [0, 0]
    System.out.println(Arrays.toString(new Solution().searchRange(new int[] {1,1}, 1))); // [0, 1]
    System.out.println(Arrays.toString(new Solution().searchRange(new int[] {2,2}, 1))); // [-1, -1]
  }

  static class Solution {
    public int[] searchRange(int[] nums, int target) {
      if (nums.length == 0) {
        return
            new int[] {-1, -1};
      }

      if (nums.length == 1) {
        if (nums[0] == target) {
          return new int[] {0,0};
        } else {
          return new int[] {-1,-1};
        }
      }

      return new int[] {binarySearchLeft(nums, target), binarySearchRight(nums, target)};
    }

    private int binarySearchLeft(int[] nums, int target) {
      int left = 0;
      int right = nums.length - 1;

      while (left <= right) {
        int mid = (left + right) >>> 1;

        if (target == nums[mid] && (mid - 1 < 0 || (nums[mid] > nums[mid - 1]))) {
            return mid;
        }

        if (target > nums[mid]) {
          left = mid + 1;
        } else {
          right = mid - 1;
        }
      }

      return -1;
    }
    private int binarySearchRight(int[] nums, int target) {
      int left = 0;
      int right = nums.length - 1;

      while (left <= right) {
        int mid = (left + right) >>> 1;

        if (target == nums[mid] && ((mid + 1 > nums.length - 1) || (nums[mid] < nums[mid + 1]))) {
            return mid;
        }

        if (target < nums[mid]) {
          right = mid - 1;
        } else {
          left = mid + 1;
        }
      }

      return -1;
    }
  }

}
