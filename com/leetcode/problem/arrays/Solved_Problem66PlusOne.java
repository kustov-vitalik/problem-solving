package com.leetcode.problem.arrays;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/plus-one/">Problem description</a>
 */
public class Solved_Problem66PlusOne {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().plusOne(new int[] {1,2,3})));
        System.out.println(Arrays.toString(new Solution().plusOne(new int[] {1,2,9})));
        System.out.println(Arrays.toString(new Solution().plusOne(new int[] {9})));
        System.out.println(Arrays.toString(new Solution().plusOne(new int[] {9,9})));
        System.out.println(Arrays.toString(new Solution().plusOne(new int[] {9,8,9})));
    }

    private static class Solution {
        public int[] plusOne(int[] digits) {
            if (digits[digits.length - 1] < 9) {
                digits[digits.length - 1]++;
                return digits;
            }

            int carry = 1;
            for (int i = digits.length - 1; i >= 0; i--) {
                int digit = (digits[i] + carry) % 10;
                carry = (digits[i] + carry)/10;
                digits[i] = digit;
            }

            if (carry == 0) {
                return digits;
            }

            int[] ints = new int[digits.length + 1];
            ints[0] = 1;
            return ints;
        }
    }
}
