package com.leetcode.problem.dynamicprogramming;

/**
 * <a href="https://leetcode.com/problems/jump-game/">Problem description</a>
 */
public class Solved_Problem55JumpGame {

  public static void main(String[] args) {
    System.out.println(new Solution().canJump(new int[] {2,3,1,1,4})); // true
    System.out.println(new Solution().canJump(new int[] {3,2,1,0,4})); // false
    System.out.println(new Solution().canJump(new int[] {1})); // true
    System.out.println(new Solution().canJump(new int[] {0})); // true
    System.out.println(new Solution().canJump(new int[] {2,0,0})); // true
  }

  static class Solution {
    public boolean canJump(int[] nums) {
      if (nums.length == 1) {
        return true;
      }


      int power = 0;

      for (int i = 0; i < nums.length; i++) {
        power = Math.max(power, nums[i]);
        if (power == 0 && i != nums.length - 1) {
          return false;
        }
        power--;
      }
      return true;
    }
  }
}
