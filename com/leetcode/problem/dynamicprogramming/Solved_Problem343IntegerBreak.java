package com.leetcode.problem.dynamicprogramming;

/**
 * <a href="https://leetcode.com/problems/integer-break/">Problem description</a>
 */
public class Solved_Problem343IntegerBreak {
    public static void main(String[] args) {
        System.out.println(new Solution().integerBreak(2)); // 1
        System.out.println(new Solution().integerBreak(3)); // 2
        System.out.println(new Solution().integerBreak(4)); // 4
        System.out.println(new Solution().integerBreak(10)); // 36
    }

    private static class Solution {
        public int integerBreak(int n) {

            return mathSolution(n);
        }

        private int mathSolution(int n) {
            if (n == 2) return 1;
            if (n == 3) return 2;
            int product = 1;
            while (n > 4) {
                product *= 3;
                n -= 3;
            }
            product *= n;

            return product;
        }

        private int dpSolution(int n) {
            int[] dp = new int[n + 1];
            dp[1] = 1;
            for (int i = 2; i <= n; i++) {
                for (int j = 1; j < i; j++) {
                    dp[i] = Math.max(dp[i], (Math.max(j, dp[j])) * (Math.max(i - j, dp[i - j])));
                }
            }
            return dp[n];
        }
    }
}
