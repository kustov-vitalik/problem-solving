package com.leetcode.problem.dynamicprogramming;

/**
 * <a href="https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/">Problem description</a>
 */
public class Solved_Problem123BestTimeToBuyAndSellStock3 {
    public static void main(String[] args) {
        System.out.println(new Solution().maxProfit(new int[]{3, 3, 5, 0, 0, 3, 1, 4})); // 6
        System.out.println(new Solution().maxProfit(new int[]{1, 2, 3, 4, 5})); // 4
        System.out.println(new Solution().maxProfit(new int[]{1, 2})); // 1
        System.out.println(new Solution().maxProfit(new int[]{1})); // 0
        System.out.println(new Solution().maxProfit(new int[]{3,1})); // 0
        System.out.println(new Solution().maxProfit(new int[]{2,1,2,0,1})); // 2
    }

    private static class Solution {
        public int maxProfit(int[] prices) {

            return trickySolutionLeftToRightAndRightToLeftDP(prices);
        }

        private static int trickySolutionLeftToRightAndRightToLeftDP(int[] prices) {
            if (prices.length == 1) {
                return 0;
            }

            int[] dpRight = new int[prices.length];


            int min = prices[0];
            for (int i = 1; i < prices.length; i++) {
                dpRight[i] = Math.max(dpRight[i - 1], prices[i] - min);
                min = Math.min(min, prices[i]);
            }

            for (int i = 0; i < prices.length/2; i++) {
                int tmp = prices[prices.length - 1 - i];
                prices[prices.length - 1 - i] = prices[i];
                prices[i] = tmp;
            }


            int[] dpLeft = new int[prices.length];
            min = prices[0];
            for (int i = 1; i < prices.length; i++) {
                dpLeft[i] = Math.max(dpLeft[i - 1], min - prices[i]);
                min = Math.max(min, prices[i]);
            }

            int max = 0;
            for (int i = 0; i < dpRight.length; i++) {
                max = Math.max(max, dpRight[i] + dpLeft[dpLeft.length - 1 - i]);
            }
            return max;
        }

        private int bruteForce(int[] prices) {
            if (prices.length == 1) {
                return 0;
            }

            int max = 0;

            for (int i = 0; i < prices.length - 1; i++) {
                max = Math.max(
                        max,
                        maxProfitWithSingleTransaction(prices, 0, i) + maxProfitWithSingleTransaction(prices, i, prices.length)
                );
            }

            return max;
        }

        private int maxProfitWithSingleTransaction(int[] prices, int from, int to) {
            if (to - from < 2) {
                return 0;
            }
            int max = 0;

            int min = prices[from];
            for (int i = from + 1; i < to; i++) {
                max = Math.max(max, prices[i] - min);
                min = Math.min(min, prices[i]);
            }

            return max;
        }
    }
}
