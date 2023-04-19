package com.leetcode.problem.arrays;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/longest-increasing-subsequence/">Problem description</a>
 */
public class Solved_Problem300LongestIncreasingSubsequence {

    public static void main(String[] args) {

        System.out.println(new Solution().lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18})); //4
        System.out.println(new Solution().lengthOfLIS(new int[]{0, 1, 0, 3, 2, 3})); //4
        System.out.println(new Solution().lengthOfLIS(new int[]{7, 7, 7, 7, 7, 7, 7})); //1

    }

    private static class Solution {
        public int lengthOfLIS(int[] nums) {

            return lisNLogN(nums);
        }

        public int lisN2Complexity(int[] nums) {
            // fill maxLen
            int[] maxLen = new int[nums.length];
            maxLen[0] = 1;
            for (int i = 1; i < maxLen.length; i++) {
                maxLen[i] = 1;
                for (int j = 0; j < i; j++) {
                    if (nums[i] > nums[j] && maxLen[i] < maxLen[j] + 1) {
                        maxLen[i] = maxLen[j] + 1;
                    }
                }
            }

            // find max
            return Arrays.stream(maxLen).max().getAsInt();
        }

        public int lisNLogN(int nums[]) {
            if (nums.length == 0) {
                // boundary case
                return 0;
            }

            int[] tail = new int[nums.length];
            int length = 1; // always points empty slot in tail
            tail[0] = nums[0];

            for (int i = 1; i < nums.length; i++) {

                if (nums[i] > tail[length - 1]) {
                    // nums[i] extends the largest subsequence
                    tail[length++] = nums[i];
                } else {
                    // nums[i] will extend a subsequence and
                    // discard older subsequence

                    // find the largest value just smaller than
                    // nums[i] in tail

                    // to find that value do binary search for
                    // the nums[i] in the range from begin to 0 + length
                    int idx = Arrays.binarySearch(tail, 0, length - 1, nums[i]);

                    // binarySearch in java returns negative
                    // value if searched element is not found in
                    // array

                    // this negative value stores the
                    // appropriate place where the element is
                    // supposed to be stored
                    if (idx < 0) {
                        idx = -1 * idx - 1;
                    }

                    // replacing the existing subsequence with
                    // new end value
                    tail[idx] = nums[i];
                }
            }
            return length;
        }
    }

}
