package com.leetcode.problem.math;

/**
 * <a href="https://leetcode.com/problems/single-number/">Problem description</a>
 */
public class Solved_Problem136SingleNumber {
    public static void main(String[] args) {
        System.out.println(new Solution().singleNumber(new int[] {1,1,2,2,5})); // 5
    }

    static class Solution {
        public int singleNumber(int[] nums) {
            if (nums.length == 1) {
                return nums[0];
            }

            int answer = nums[0];
            for (int i = 1; i < nums.length; i++) {
                answer = answer ^ nums[i];
            }

            return answer;
        }
    }
}
