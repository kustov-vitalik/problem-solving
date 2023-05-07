package com.leetcode.problem.dynamicprogramming;

/**
 * <a href="https://leetcode.com/problems/perfect-squares/">Problem description</a>
 */
public class Solved_Problem279PerfectSquares {
    public static void main(String[] args) {
        System.out.println(new Solution().numSquares(12)); // 3
    }

    private static class Solution {
        public int numSquares(int n) {
            return recursionWithMemorizationApproach(n, new int[n + 1]);
        }

        public int recursionWithMemorizationApproach(int n, int[] memo) {
            if (n < 4)
                return n;

            if (memo[n] != 0)
                return memo[n];

            int ans = n;

            for (int i = 1; i * i <= n; i++) {
                int square = i * i;
                ans = Math.min(ans, 1 + recursionWithMemorizationApproach(n - square, memo));
            }

            return memo[n] = ans;
        }

        private static int mathApproach(int n) {
            int sqrt = (int) Math.sqrt(n);

            if (sqrt * sqrt == n) // Perfect square
                return 1;

            while (n % 4 == 0) // 4^a (8b + 7)
                n = n / 4;

            if (n % 8 == 7)
                return 4;

            for (int i = 1; i * i <= n; i++) { // Sum of two perfect squares
                int square = i * i;
                int base = (int) Math.sqrt(n - square);

                if (base * base == n - square)
                    return 2;
            }

            return 3;
        }
    }
}
