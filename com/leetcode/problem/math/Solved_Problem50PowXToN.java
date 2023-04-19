package com.leetcode.problem.math;

/**
 * <a href="https://leetcode.com/problems/powx-n/">Problem description</a>
 */
public class Solved_Problem50PowXToN {
    public static void main(String[] args) {
        System.out.println(new Solution().myPow(2.0, 4)); // 16
        System.out.println(new Solution().myPow(2.0, 5)); // 32
    }

    private static class Solution {
        public double myPow(double x, int n) {
            if (n == 0) {
                return x < 0 ? -1 : 1;
            }

            if (n < 0) {
                return 1/pow(x, -1 * (long)n);
            }

            return pow(x, n);
        }

        private double pow(double x, long n) {

            long power = 1;
            double result = x;

            while (power < n) {
                result *= result;
                power += power;
            }

            long a = power - n;
            while (a > 0) {
                result /= x;
                a--;
            }

            return result;
        }
    }
}
