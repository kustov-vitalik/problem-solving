package com.leetcode.problem.arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * <a href="https://leetcode.com/problems/intersection-of-two-arrays/">Problem description</a>
 */
public class Solved_Problem349IntersectionOfTwoArrays {
    public static void main(String[] args) {

    }

    private static class Solution {
        public int[] intersection(int[] nums1, int[] nums2) {
            Set<Integer> intersection = new HashSet<>();
            Set<Integer> set = Arrays.stream(nums1).boxed().collect(Collectors.toSet());
            for (int num : nums2) {
                if (set.contains(num)) {
                    intersection.add(num);
                }
            }

            return intersection.stream().mapToInt(i -> i).toArray();
        }
    }
}
