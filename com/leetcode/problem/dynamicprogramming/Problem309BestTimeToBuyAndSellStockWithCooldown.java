package com.leetcode.problem.dynamicprogramming;

/**
 * <a href="https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/">Problem description</a>
 */
public class Problem309BestTimeToBuyAndSellStockWithCooldown {
    public static void main(String[] args) {
        System.out.println(new Solution().maxProfit(new int[] {1,2,3,0,2})); // 3
        System.out.println(new Solution().maxProfit(new int[] {1})); // 0
        System.out.println(new Solution().maxProfit(new int[] {1,2,4})); // 3
    }

    static class Solution {
        public int maxProfit(int[] prices) {

            if (prices.length == 1) {
                return 0;
            }

            int total = 0;
            boolean ownStock = false;
            int lock = 0;

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
                        lock = 2;
                    }

                } else {

                    if (prices[i] > prices[i - 1] && prices[i] > prices[i + 1] && ownStock) {
                        total += prices[i];
                        ownStock = false;
                        lock = 2;
                    }

                    if (prices[i] < prices[i + 1] && !ownStock && lock == 0) {
                        total -= prices[i];
                        ownStock = true;
                    }

                }

                lock = Math.max(0, lock - 1);

                System.out.println("Total : " + total);

            }

            return total;

        }
    }
}
