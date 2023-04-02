package com.leetcode.problem.binarysearcg;

public class Problem852PeakIndexInMountainArray {

  public static void main(String[] args) {

    Solution problem = new Solution();
    System.out.println(problem.peakIndexInMountainArray(new int[]{0, 1, 0})); // 1
    System.out.println(problem.peakIndexInMountainArray(new int[]{0, 2, 1, 0})); // 1
    System.out.println(problem.peakIndexInMountainArray(new int[]{0, 10, 5, 2})); // 1
    System.out.println(problem.peakIndexInMountainArray(new int[]{0, 1, 2, 3, 2, 1, 0})); // 3

  }

  static class Solution {

    public int peakIndexInMountainArray(int[] arr) {

      int left = 0;
      int right = arr.length - 1;

      while (left <= right) {
        int mid = (left + right) >>> 1;

        if (mid > 0 && mid < arr.length + 1 && arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) {
          return mid;
        }

        if (mid < arr.length + 1 && arr[mid + 1] < arr[mid]) {
          right = mid - 1;
        } else {
          left = mid + 1;
        }
      }

      return -1;

    }
  }

}
