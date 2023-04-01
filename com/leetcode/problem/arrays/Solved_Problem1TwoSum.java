package com.leetcode.problem.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solved_Problem1TwoSum {

  public static void main(String[] args) {
    System.out.println(Arrays.toString(new Solved_Problem1TwoSum().twoSum(new int[]{2, 7, 11, 15}, 9)));
    System.out.println(Arrays.toString(new Solved_Problem1TwoSum().twoSum(new int[]{3,2,4}, 6)));

    System.out.println(Arrays.toString(new Solved_Problem1TwoSum().twoSumFast(new int[]{2, 7, 11, 15}, 9)));
    System.out.println(Arrays.toString(new Solved_Problem1TwoSum().twoSumFast(new int[]{3,2,4}, 6)));
  }

  public int[] twoSum(int[] nums, int target) {

    for (int i = 0; i < nums.length; i++) {

      for (int j = i + 1; j < nums.length; j++) {
        if (nums[i] + nums[j] == target) {
          return new int[] {i, j};
        }
      }

    }

    return nums;

  }

  public int[] twoSumFast(int[] nums, int target) {

    Map<Integer, Integer> map = new HashMap<>();

    for (int i = 0; i < nums.length; i++) {

      int num = nums[i];

      if (map.containsKey(num)) {
        return new int[] {i, map.get(num)};
      }

      int key = target - num;
      map.put(key, i);

    }

    return nums;

  }

}
