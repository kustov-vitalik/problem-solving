package com.leetcode.problem.dynamicprogramming;

/**
 * <a href="https://leetcode.com/problems/arithmetic-slices/">Problem description</a>
 */
public class Solved_Problem413ArithmeticSlices {
    public static void main(String[] args) {
        System.out.println(new Solution().numberOfArithmeticSlices(new int[] {1,2,3,4})); // 3 ([1,2,3], [2,3,4], [1,2,3,4])
        System.out.println(new Solution().numberOfArithmeticSlices(new int[] {1})); // 0
        System.out.println(new Solution().numberOfArithmeticSlices(new int[] {1,2,3,4,2,0,-2,-4})); // 9
        System.out.println(new Solution().numberOfArithmeticSlices(new int[] {1,2,3,8,9,10})); // 2 ([1,2,3], [8,9,10])
    }

    private static class Solution {
        public int numberOfArithmeticSlices(int[] nums) {
            if (nums.length < 3) {
                return 0;
            }

            int delta = nums[1] - nums[0], prevDelta;
            int counter = 2;
            int answer = 0;
            for (int i = 2; i < nums.length; i++) {
                prevDelta = delta;
                delta = nums[i] - nums[i - 1];
                if (delta == prevDelta) {
                    counter++;
                } else {
                    answer += countSlicesForLen(counter);
                    counter = 2;
                }
            }

            answer += countSlicesForLen(counter);

            return answer;
        }

        private int countSlicesForLen(int len) {
            return (len-1)*(len-2)/2;
        }
    }
}
