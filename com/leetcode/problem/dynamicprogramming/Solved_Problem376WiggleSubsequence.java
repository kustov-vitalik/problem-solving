package com.leetcode.problem.dynamicprogramming;

/**
 * <a href="https://leetcode.com/problems/wiggle-subsequence/">Problem description</a>
 */
public class Solved_Problem376WiggleSubsequence {
    public static void main(String[] args) {
        System.out.println(new Solution().wiggleMaxLength(new int[]{1, 7, 4, 9, 2, 5})); // 6
        System.out.println(new Solution().wiggleMaxLength(new int[]{1, 17, 5, 10, 13, 15, 10, 5, 16, 8})); // 7
        System.out.println(new Solution().wiggleMaxLength(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9})); // 2
    }

    private static class Solution {
        public int wiggleMaxLength(int[] nums) {
            if (nums.length < 2) {
                return nums.length;
            }
            int down = 1;
            int up = 1;
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] > nums[i - 1]) {
                    up = down + 1;
                } else if (nums[i] < nums[i - 1]) {
                    down = up + 1;
                }
            }
            return Math.max(down, up);
        }
    }
}
