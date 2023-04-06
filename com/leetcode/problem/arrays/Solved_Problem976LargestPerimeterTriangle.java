package com.leetcode.problem.arrays;


import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/largest-perimeter-triangle">Problem description</a>
 */
public class Solved_Problem976LargestPerimeterTriangle {

  public static void main(String[] args) {


    System.out.println(new Solution().largestPerimeter(new int[] {2,1,2})); // 5
    System.out.println(new Solution().largestPerimeter(new int[] {1,2,1,10})); // 0
    System.out.println(new Solution().largestPerimeter(new int[] {2,3,4,5,8,100,200,500})); // 12
    System.out.println(new Solution().largestPerimeter(new int[] {1,2,4,8,100,200,500})); // 0
  }

  static class Solution {
    public int largestPerimeter(int[] nums) {
      if (nums.length == 3) {
        return Arrays.stream(nums).sum();
      }

      Arrays.sort(nums);


      for (int i = nums.length - 1; i > 1; i--) {
        if (nums[i] < nums[i-1] + nums[i-2]) {
          return nums[i] + nums[i-1] + nums[i-2];
        }
      }

      return 0;
    }
  }


}
