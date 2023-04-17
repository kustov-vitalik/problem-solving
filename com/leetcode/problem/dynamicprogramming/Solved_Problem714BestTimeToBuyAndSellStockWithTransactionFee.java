package com.leetcode.problem.dynamicprogramming;

/**
 * <a href="https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/">Problem description</a>
 */
public class Solved_Problem714BestTimeToBuyAndSellStockWithTransactionFee {
    public static void main(String[] args) {
        System.out.println(new Solution().maxProfit(new int[] {1,3,2,8,4,9}, 2)); // 8
        System.out.println(new Solution().maxProfit(new int[] {1,3,7,5,10,3}, 3)); // 6
    }

    private static class Solution {
        public int maxProfit(int[] prices, int fee) {

            int cash = 0, hold = -prices[0];
            for (int i = 1; i < prices.length; i++) {
                cash = Math.max(cash, hold + prices[i] - fee);
                hold = Math.max(hold, cash - prices[i]);
            }
            return cash;

        }
    }
}
