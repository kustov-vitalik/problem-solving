package com.leetcode.problem.math;

/**
 * <a href="https://leetcode.com/problems/power-of-four/submissions/936563591/">Problem description</a>
 */
public class Solved_Problem342PowerOfFour {

    public static void main(String[] args) {
        System.out.println(new Solution().isPowerOfFour(16));
        System.out.println(new Solution().isPowerOfFour(2));
    }

    private static class Solution {
        public boolean isPowerOfFour(int n) {
            if (n < 1) {
                return false;
            }

            int k = 1;
            int counter = 0;
            while (k < n && counter <= 15) {
                k = k << 2;
                counter++;
                if (k == n) {
                    return true;
                }
            }

            return k == n;
        }
    }
}
