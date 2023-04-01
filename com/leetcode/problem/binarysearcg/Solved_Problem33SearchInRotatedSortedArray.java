package com.leetcode.problem.binarysearcg;

public class Solved_Problem33SearchInRotatedSortedArray {

  public static void main(String[] args) {
    System.out.println(new Solution().search(new int[] {4,5,6,7,0,1,2}, 0)); // 4
    System.out.println(new Solution().search(new int[] {4,5,6,7,0,1,2}, 3)); // -1
    System.out.println(new Solution().search(new int[] {1}, 3)); // -1
    System.out.println(new Solution().search(new int[] {1}, 1)); // 0
    System.out.println(new Solution().search(new int[] {2,1}, 1)); // 1
    System.out.println(new Solution().search(new int[] {1,2}, 1)); // 0
    System.out.println(new Solution().search(new int[] {1,2}, 2)); // 1
    System.out.println(new Solution().search(new int[] {8,9,2,3,4}, 9)); // 1
  }

  static class Solution {
    public int search(int[] nums, int target) {

      if (nums[0] <= nums[nums.length - 1]) {
        // sorted array
        return binarySearch(nums, target, 0, nums.length - 1);
      }

      int pointer = indexOfPointer(nums);


//      System.out.println("LO: " + pointer);

      if (target <= nums[nums.length - 1]) {
        // bin-search inside the suffix
        return binarySearch(nums, target, pointer, nums.length - 1);
      } else {
        return binarySearch(nums, target, 0, pointer - 1);
      }
    }

    private int indexOfPointer(int[] nums) {
      int lo = 0;
      int hi = nums.length - 1;

      // find position of 0-element before rotation
      while (lo <= hi) {
        int mid = (lo + hi) >>> 1;
        int value = nums[mid];

        if (mid > 0 && value < nums[mid-1]) {
          return mid;
        }

        if (value > nums[0]) {
          lo = mid + 1;
        } else if (value < nums[0]) {
          hi = mid - 1;
        } else {
          lo++;
          break;
        }
      }

      return lo;
    }

    private int binarySearch(int[] nums, int key, int lo, int hi) {
      while (lo <= hi) {
        int mid = (lo + hi) >>> 1;

        if (nums[mid] > key) {
          hi = mid - 1;
        } else if (nums[mid] < key) {
          lo = mid + 1;
        } else if (nums[mid] == key) {
          return mid;
        }
      }
      return -1;
    }
  }

}
