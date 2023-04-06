package com.leetcode.problem.arrays;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/sort-colors/">Problem description</a>
 */
public class Solved_Problem75SortColors {

  public static void main(String[] args) {
    var arr1 = new int[] {2,0,2,1,1,0};
    new Solution().sortColors(arr1);
    System.out.println(Arrays.toString(arr1)); // 0,0,1,1,2,2
    var arr2 = new int[] {2,0,1};
    new Solution().sortColors(arr2);
    System.out.println(Arrays.toString(arr2)); // 0,1,2
  }

  static class Solution {
    public void sortColors(int[] nums) {
      int p1 = 0, p2 = nums.length - 1, index = 0;
      while (index <= p2) {
        if (nums[index] == 0) {
          nums[index] = nums[p1];
          nums[p1] = 0;
          p1++;
        }
        if (nums[index] == 2) {
          nums[index] = nums[p2];
          nums[p2] = 2;
          p2--;
          index--;
        }
        index++;
      }
    }
  }
}
