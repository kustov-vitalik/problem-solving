package com.leetcode.problem.dynamicprogramming;

/**
 * <a href="https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/">Problem description</a>
 */
public class Solved_Problem122BestTimeToBuyAndSellStock2 {

    public static void main(String[] args) {
        System.out.println(new Solution().maxProfit(new int[]{7, 1, 5, 3, 6, 4})); // 7
        System.out.println(new Solution().maxProfit(new int[]{1, 2, 3, 4, 5})); // 4
        System.out.println(new Solution().maxProfit(new int[]{7, 6, 4, 3, 1})); // 0
    }

    static class Solution {
        public int maxProfit(int[] prices) {

            if (prices.length == 1) {
                return 0;
            }

            int total = 0;
            boolean ownStock = false;

            for (int i = 0; i < prices.length; i++) {

                if (i == 0) {

                    if (prices[i] < prices[i + 1]) {
                        total -= prices[i];
                        ownStock = true;
                    }

                } else if (i == prices.length - 1) {

                    if ((prices[i] > prices[i - 1]) && ownStock) {
                        total += prices[i];
                        ownStock = false;
                    }

                } else {

                    if (prices[i] > prices[i - 1] && ownStock) {
                        total += prices[i];
                        ownStock = false;
                    }

                    if (prices[i] < prices[i + 1] && !ownStock) {
                        total -= prices[i];
                        ownStock = true;
                    }

                }

            }

            return total;

        }
    }
}
