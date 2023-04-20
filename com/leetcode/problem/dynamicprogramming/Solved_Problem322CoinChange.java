package com.leetcode.problem.dynamicprogramming;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/coin-change/">Problem description</a>
 */
public class Solved_Problem322CoinChange {
    public static void main(String[] args) {
        System.out.println(new Solution().coinChange(new int[]{1, 2, 5}, 11));
        System.out.println(new Solution().coinChange(new int[]{2}, 3));
        System.out.println(new Solution().coinChange(new int[]{1}, 0));
        System.out.println(new Solution().coinChange(new int[]{186, 419, 83, 408}, 6249));
        System.out.println(new Solution().coinChange(new int[]{2, 3, 4}, 9));
    }

    private static class Solution {
        public int coinChange(int[] coins, int amount) {
            int[] dp = new int[amount + 1];
            Arrays.fill(dp, amount + 1);
            dp[0] = 0;
            for (int i = 1; i <= amount; i++) {
                for (int c : coins) {
                    if (i >= c) {
                        dp[i] = Math.min(dp[i], dp[i - c] + 1);
                    }
                }
            }
            return dp[amount] > amount ? -1 : dp[amount];
        }
    }
}
