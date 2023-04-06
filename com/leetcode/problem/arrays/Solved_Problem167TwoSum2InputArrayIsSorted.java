package com.leetcode.problem.arrays;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/two-sum-ii-input-array-is-sorted">Problem description</a>
 */
public class Solved_Problem167TwoSum2InputArrayIsSorted {

  public static void main(String[] args) {
    System.out.println(Arrays.toString(new Solution().twoSum(new int[]{2, 7, 11, 15}, 9))); // [1,2]
    System.out.println(Arrays.toString(new Solution().twoSum(new int[]{2, 3, 4}, 6))); // [1,3]
    System.out.println(Arrays.toString(new Solution().twoSum(new int[]{-1, 0}, -1))); // [1,2]
    System.out.println(
        Arrays.toString(new Solution().twoSum(new int[]{1, 2, 3, 4, 4, 9, 56, 90}, 8))); // [4,5]
  }

  static class Solution {

    public int[] twoSum(int[] numbers, int target) {

      if (numbers.length == 2) {
        return new int[]{1, 2};
      }

      int mid;
      int key;
      int left;
      int right;
      for (int i = 0; i < numbers.length - 1; i++) {
        key = target - numbers[i];

        left = i;
        right = numbers.length - 1;

        while (left <= right) {
          mid = (left + right) >>> 1;

          if (numbers[mid] == key && i != mid) {
            return new int[]{i + 1, mid + 1};
          }

          if (numbers[mid] > key) {
            right = mid - 1;
          } else {
            left = mid + 1;
          }
        }

      }

      throw new RuntimeException("Numbers not found");
    }
  }

}
