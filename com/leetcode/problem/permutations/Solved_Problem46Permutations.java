package com.leetcode.problem.permutations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Solved_Problem46Permutations {

  public static void main(String[] args) {
    System.out.println(new Solution().permute(new int[] {1,2,3}));
  }

  static class Solution {
    public List<List<Integer>> permute(int[] nums) {
      List<List<Integer>> permutations = new ArrayList<>();

      generatePermutations(permutations, nums, 0);

      return permutations;

    }

    private void generatePermutations(List<List<Integer>> permutations, int[] nums, int start) {
      if (start == nums.length) {
        permutations.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
      }

      for (int i = start; i < nums.length; i++) {
        swap(nums, start, i);
        generatePermutations(permutations, nums, start + 1);
        swap(nums, start, i);
      }
    }

    private void swap(int[] nums, int i, int j) {
      int tmp = nums[i];
      nums[i] = nums[j];
      nums[j] = tmp;
    }
  }

}
