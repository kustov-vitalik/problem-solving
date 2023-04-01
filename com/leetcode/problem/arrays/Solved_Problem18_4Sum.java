package com.leetcode.problem.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solved_Problem18_4Sum {

  public static void main(String[] args) {
    System.out.println(new Solved_Problem18_4Sum().fourSum(new int[] {1,0,-1,0,-2,2}, 0)); // [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
    System.out.println(new Solved_Problem18_4Sum().fourSum(new int[] {2,2,2,2,2}, 8)); // [2,2,2,2]
    System.out.println(new Solved_Problem18_4Sum().fourSum(new int[] {1000000000,1000000000,1000000000,1000000000}, -294967296)); // []
    System.out.println(new Solved_Problem18_4Sum().fourSum(new int[] {1,-2,-5,-4,-3,3,3,5}, -11)); // [[-5,-4,-3,1]]
  }

  public List<List<Integer>> fourSum(int[] nums, int target) {
    if (nums.length == 0) {
      return new ArrayList<>();
    }

    Set<List<Integer>> set = new HashSet<>();

    Arrays.sort(nums);
    if (nums[0] > 0 && target < 0 || nums[nums.length - 1] < 0 && target > 0) {
      return new ArrayList<>();
    }

    for (int i = 0; i < nums.length - 3; i++) {
      for (int j = i + 1; j < nums.length - 2; j++) {

        int left = j + 1;
        int right = nums.length - 1;

        while (left < right) {

          int sum = nums[i] + nums[j] + nums[left] + nums[right];

          if (sum == target) {
            set.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
            left++;
            right--;
          } else if (sum > target) {
            right--;
          } else {
            left++;
          }
        }
      }
    }

    return new ArrayList<>(set);
  }

  public int search(int[] nums, int fromIncl, int toExcl, int key) {

    int low = fromIncl;
    int high = toExcl + 1;

    while (low < high) {
      int mid = (low + high) >>> 1;
      int val = nums[mid];

      if (val < key) {
        high = mid - 1;
      } else if (val < key) {
        low = mid + 1;
      } else  {
        return mid;
      }
    }

    return -(low + 1);  // key not found.
  }

}
