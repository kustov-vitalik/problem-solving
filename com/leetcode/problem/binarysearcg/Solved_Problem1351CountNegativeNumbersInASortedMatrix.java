package com.leetcode.problem.binarysearcg;

/**
 * <a href="https://leetcode.com/problems/count-negative-numbers-in-a-sorted-matrix/">Problem description</a>
 */
public class Solved_Problem1351CountNegativeNumbersInASortedMatrix {
    public static void main(String[] args) {
        System.out.println(new Solution().countNegatives(new int[][]{
                {4,3,2,-1},
                {3,2,1,-1},
                {1,1,-1,-2},
                {-1,-1,-2,-3}
        }));

    }

    private static class Solution {
        public int countNegatives(int[][] grid) {
            int counter = 0;
            for (int[] ints : grid) {
                int firstNegativeElement = findFirstNegativeElement(ints);
                if (firstNegativeElement != -1) {
                    counter += (ints.length - firstNegativeElement);
                }
            }
            return counter;
        }

        private int findFirstNegativeElement(int[] nums) {

            if (nums[0] < 0) {
                return 0;
            }

            int left = 0;
            int right = nums.length - 1;
            int mid;

            while (left <= right) {
                mid = (left + right) >>> 1;

                if (nums[mid] < 0 && mid > 0 && nums[mid - 1] >= 0) {
                    return mid;
                }

                if (nums[mid] >= 0) {
                    left = mid + 1;
                } else if (nums[mid] < 0) {
                    right = mid - 1;
                }
            }

            return -1;
        }
    }
}
