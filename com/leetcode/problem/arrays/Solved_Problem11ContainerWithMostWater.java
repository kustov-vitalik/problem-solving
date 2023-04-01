package com.leetcode.problem.arrays;

import java.util.HashMap;
import java.util.Map;

public class Solved_Problem11ContainerWithMostWater {

  public static void main(String[] args) {

    System.out.println(new Solution().maxArea(new int[] {1,8,6,2,5,4,8,3,7})); //49
    System.out.println(new Solution().maxArea(new int[]{2, 3, 10, 5, 7, 8, 9})); //36
    System.out.println(new Solution().maxArea(new int[]{1,2,3,4,5,6,7,8,9,10})); //25

  }

  static class Solution {

    public int maxArea(int[] height) {

      return fastMethod(height);
    }

    private int fastMethod(int[] height) {

      int max = Integer.MIN_VALUE;

      int left = 0;
      int right = height.length - 1;
      while (left < right) {
        max = Math.max(max, (right - left) * Math.min(height[left], height[right]));
        if (height[left] <= height[right]) {
          left++;
        } else {
          right--;
        }
      }

      return max;
    }

    private int slowMethod(int[] height) {
      if (height.length == 2) {
        return Math.min(height[0], height[1]);
      }

      int max = Integer.MIN_VALUE;

      Map<Integer, Integer> leftMaxes = new HashMap<>();
      leftMaxes.put(0, height[0]);
      int localMax = height[0];
      for (int i = 0; i < height.length - 1; i++) {
        if (height[i + 1] > localMax) {
          localMax = height[i + 1];
          leftMaxes.put(i + 1, height[i + 1]);
        }
      }

      Map<Integer, Integer> rightMaxes = new HashMap<>();
      rightMaxes.put(height.length - 1, height[height.length - 1]);
      localMax = height[height.length - 1];
      for (int i = height.length - 1; i > 0; i--) {
        if (height[i - 1] > localMax) {
          localMax = height[i - 1];
          rightMaxes.put(i - 1, height[i - 1]);
        }
      }

      for (var left: leftMaxes.entrySet()) {
        int indexL = left.getKey();

        for (var right: rightMaxes.entrySet()) {
          int indexR = right.getKey();
          if (indexR > indexL) {
            max = Math.max(max, (indexR - indexL) * Math.min(left.getValue(), right.getValue()));
          }
        }
      }

      return max;
    }
  }

}
