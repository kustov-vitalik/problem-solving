package com.leetcode.problem.arrays;

/**
 * <a href="https://leetcode.com/problems/monotonic-array/">Problem description</a>
 */
public class Solved_Problem896MonotonicArray {
    public static void main(String[] args) {

    }

    private static class Solution {
        public boolean isMonotonic(int[] nums) {
            boolean increasing = true;
            boolean decreasing = true;
            for (int i = 0; i < nums.length - 1; ++i) {
                if (nums[i] > nums[i+1])
                    increasing = false;
                if (nums[i] < nums[i+1])
                    decreasing = false;
            }

            return increasing || decreasing;
        }
    }
}
