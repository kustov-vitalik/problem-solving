package com.leetcode.problem.binarysearcg;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/special-array-with-x-elements-greater-than-or-equal-x/">Problem description</a>
 */
public class Solved_Problem1608SpecialArrayWithXElementsGreaterThanOrEqualX {
    public static void main(String[] args) {
        System.out.println(new Solution().specialArray(new int[]{3, 5})); // 2
        System.out.println(new Solution().specialArray(new int[]{0, 0})); // -1
        System.out.println(new Solution().specialArray(new int[]{0, 4, 3, 0, 4})); // 3
        System.out.println(new Solution().specialArray(new int[]{1, 0, 0, 6, 4, 9})); // 3
    }

    private static class Solution {
        public int specialArray(int[] nums) {
            Arrays.sort(nums);

            for (int i = 0; i < nums.length; i++) {
                int n = nums.length - i;
                boolean cond1 = n <= nums[i];
                boolean cond2 = (i - 1 < 0) || (n > nums[i - 1]);
                if (cond1 && cond2) {
                    return n;
                }
            }
            return -1;
        }
    }
}
