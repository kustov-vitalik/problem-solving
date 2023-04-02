package com.leetcode.problem.permutations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Solved_Problem47Permutations2 {

  public static void main(String[] args) {
    System.out.println(new Solution().permuteUnique(new int[] {1,2,3}));
    System.out.println(new Solution().permuteUnique(new int[] {1,1,2}));
  }

  static class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
      Set<List<Integer>> permutations = new HashSet<>();

      populatePermutations(permutations, nums, 0);

      return new ArrayList<>(permutations);
    }

    private void populatePermutations(Set<List<Integer>> permutations, int[] nums, int start) {
      if (start == nums.length) {
        permutations.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
      }

      for (int i = start; i < nums.length; i++) {
        swap(nums, i, start);
        populatePermutations(permutations, nums, start + 1);
        swap(nums, i, start);
      }
    }

    private void swap(int[] nums, int i, int j) {
      int tmp = nums[i];
      nums[i] = nums[j];
      nums[j] = tmp;
    }
  }

}
