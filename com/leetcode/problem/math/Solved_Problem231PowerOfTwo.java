package com.leetcode.problem.math;

/**
 * <a href="https://leetcode.com/problems/power-of-two/">Problem description</a>
 */
public class Solved_Problem231PowerOfTwo {
    public static void main(String[] args) {
        System.out.println(new Solution().isPowerOfTwo(4));
        System.out.println(new Solution().isPowerOfTwo(32));
        System.out.println(new Solution().isPowerOfTwo(31));
    }

    static class Solution {
        public boolean isPowerOfTwo(int n) {
            if (n <= 0) {
                return false;
            }

            String binaryString = Integer.toBinaryString(n);
            if (binaryString.charAt(0) != '1') {
                return false;
            }

            for (int i = 1; i < binaryString.length(); i++) {
                if (binaryString.charAt(i) != '0') {
                    return false;
                }
            }

            return true;
        }
    }
}
