package com.leetcode.problem.arrays;

/**
 * <a href="https://leetcode.com/problems/majority-element/description/">Problem description</a>
 */
public class Solved_Problem169MajorityElement {
    public static void main(String[] args) {

    }

    private static class Solution {
        public int majorityElement(int[] nums) {
            int count = 0;
            Integer candidate = null;

            for (int num : nums) {
                if (count == 0) {
                    candidate = num;
                }

                count += num == candidate ? 1 : -1;
            }

            return candidate;
        }
    }
}
