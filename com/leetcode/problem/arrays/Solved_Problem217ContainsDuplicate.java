package com.leetcode.problem.arrays;

import java.util.HashSet;
import java.util.Set;

public class Solved_Problem217ContainsDuplicate {

  public static void main(String[] args) {
    System.out.println(new Solution().containsDuplicate(new int[] {1,1,2})); // true
    System.out.println(new Solution().containsDuplicate(new int[] {1,2,3})); // false
  }

  static class Solution {
    public boolean containsDuplicate(int[] nums) {
      Set<Integer> set = new HashSet<>(nums.length);
      for (int num : nums) {
        set.add(num);
      }
      return set.size() != nums.length;
    }
  }

}
