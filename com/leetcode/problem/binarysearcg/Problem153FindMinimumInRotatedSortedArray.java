package com.leetcode.problem.binarysearcg;

/**
 * <a href="https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/">Problem description</a>
 */
public class Problem153FindMinimumInRotatedSortedArray {
    public static void main(String[] args) {
        System.out.println(new Solution().findMin(new int[] {3,4,5,1,2})); // 1
        System.out.println(new Solution().findMin(new int[] {4,5,6,7,0,1,2})); // 0
        System.out.println(new Solution().findMin(new int[] {11,13,15,17})); // 11
        System.out.println(new Solution().findMin(new int[] {1})); // 1
        System.out.println(new Solution().findMin(new int[] {2,1})); // 1
        System.out.println(new Solution().findMin(new int[] {5,1,2,3,4})); // 1
    }

    private static class Solution {
        public int findMin(int[] nums) {

            if (nums.length == 1) {
                return nums[0];
            }

            int left = 0;
            int right = nums.length - 1;
            int mid;

            while (left <= right) {
                mid = (left + right) >>> 1;

                int prevVal = mid > 0 ? nums[mid - 1] : nums[nums.length - 1];
                int nextVal = mid < nums.length - 1 ? nums[mid + 1] : nums[0];
                if (nums[mid] < prevVal && nums[mid] < nextVal) {
                    return nums[mid];
                }

                if (nums[mid] > nums[0]) {
                    left = mid + 1;
                } else if (nums[mid] < nums[0]) {
                    right = mid - 1;
                } else {
                    return nums[mid];
                }
            }

            return nums[0];
        }
    }
}
