package com.leetcode.problem.arrays;

import java.util.Arrays;

public class Solved_Problem16_3SumClosest {

  public static void main(String[] args) {
    System.out.println(new Solution().threeSumClosest(new int[] {-1,2,1,-4}, 1)); // 2
    System.out.println(new Solution().threeSumClosest(new int[] {0,0,0}, 1)); // 0
  }

  static class Solution {
    public int threeSumClosest(int[] nums, int target) {
      Arrays.sort(nums);

      int closestSum = Integer.MAX_VALUE;
      int minDiff = Integer.MAX_VALUE;
      int sum;
      int diff;
      for (int i = 0; i < nums.length - 2; i++) {

        int left = i + 1;
        int right = nums.length - 1;

        while (left < right) {

          sum = nums[left] + nums[right] + nums[i];

          diff = Math.abs(target - sum);
          if (diff < minDiff) {
            minDiff = diff;
            closestSum = sum;
          }

          if (sum == target) {
            return sum;
          } else if (sum > target) {
            right--;
          } else {
            left++;
          }
        }
      }

      return closestSum;
    }

  }

}
