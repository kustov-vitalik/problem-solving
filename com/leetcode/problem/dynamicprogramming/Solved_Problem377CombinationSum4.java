package com.leetcode.problem.dynamicprogramming;

/**
 * <a href="https://leetcode.com/problems/combination-sum-iv/">Problem description</a>
 */
public class Solved_Problem377CombinationSum4 {
    public static void main(String[] args) {
        System.out.println(new Solution().combinationSum4(new int[] {1,2,3}, 4)); // 7
    }

    private static class Solution {
        public int combinationSum4(int[] nums, int target) {
            int[] comb = new int[target + 1];
            comb[0] = 1;
            for (int i = 1; i < comb.length; i++) {
                for (int j = 0; j < nums.length; j++) {
                    if (i - nums[j] >= 0) {
                        comb[i] += comb[i - nums[j]];
                    }
                }
            }
            return comb[target];
        }
    }
}
