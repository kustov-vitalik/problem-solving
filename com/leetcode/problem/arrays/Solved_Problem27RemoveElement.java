package com.leetcode.problem.arrays;

public class Solved_Problem27RemoveElement {

  public static void main(String[] args) {
    System.out.println(new Solution().removeElement(new int[] {3,2,2,3}, 3) == 2);
    System.out.println(new Solution().removeElement(new int[] {0,1,2,2,3,0,4,2}, 2) == 5);
    System.out.println(new Solution().removeElement(new int[] {0,1,2}, 5) == 3);
    System.out.println(new Solution().removeElement(new int[] {2}, 5) == 1);
    System.out.println(new Solution().removeElement(new int[] {}, 5) == 0);
    System.out.println(new Solution().removeElement(new int[] {1}, 1) == 0);
    System.out.println(new Solution().removeElement(new int[] {0,4,4,0,4,4,4,0,2}, 4) == 4);
    System.out.println(new Solution().removeElement(new int[] {2,2,3}, 2) == 1);
    System.out.println(new Solution().removeElement(new int[] {2,2,2,2,2,3}, 2) == 1);
  }

  static class Solution {
    public int removeElement(int[] nums, int val) {
      if (nums.length == 0) {
        return 0;
      }

      int left = 0;
      int right = nums.length - 1;
      while (left <= right) {

        while (nums[right] == val && left < right) {
          right--;
        }

        if (nums[left] == val) {
          nums[left] = nums[right];
          right--;
        }

        left++;
      }

      return right + 1;
    }
  }

}
