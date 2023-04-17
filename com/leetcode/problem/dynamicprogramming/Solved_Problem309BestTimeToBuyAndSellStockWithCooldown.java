package com.leetcode.problem.dynamicprogramming;

/**
 * <a href="https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/">Problem description</a>
 */
public class Solved_Problem309BestTimeToBuyAndSellStockWithCooldown {
    public static void main(String[] args) {
        System.out.println(new Solution().maxProfit(new int[] {1,2,3,0,2})); // 3
        System.out.println(new Solution().maxProfit(new int[] {1})); // 0
        System.out.println(new Solution().maxProfit(new int[] {1,2,4})); // 3
        System.out.println(new Solution().maxProfit(new int[] {4,1,2})); // 1
        System.out.println(new Solution().maxProfit(new int[] {1,4,2})); // 3
    }

    private static class Solution {
        public int maxProfit(int[] prices) {

            int sell = 0;
            int prevSell = 0;
            int buy = Integer.MIN_VALUE;
            int prevBuy;
            for (int price : prices) {
                prevBuy = buy;
                buy = Math.max(prevSell - price, prevBuy);
                prevSell = sell;
                sell = Math.max(prevBuy + price, prevSell);
            }
            return sell;
        }
    }
}
