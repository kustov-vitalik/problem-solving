package com.leetcode.problem.dynamicprogramming;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/coin-change-ii/">Problem description</a>
 */
public class Problem518CoinChange2 {
    public static void main(String[] args) {
        System.out.println(new Solution().change(5, new int[]{1, 2, 5})); // 4
        System.out.println(new Solution().change(3, new int[]{2})); // 0
        System.out.println(new Solution().change(10, new int[]{10})); // 1
        System.out.println(new Solution().change(0, new int[]{7})); // 1
        System.out.println(new Solution().change(500, new int[]{3,5,7,8,9,10,11})); // 35502874
    }

    private static class Solution {

        int counter;

        public int change(int amount, int[] coins) {
            return dpApproach(amount, coins);
        }

        private static int dpApproach(int amount, int[] coins) {
            int arr[] = new int[amount +1];
            Arrays.fill(arr, 0);
            arr[0] = 1;
            for(int c : coins) {
                for(int i = c; i <= amount; i++) {
                    arr[i] += arr[i-c];
                }
            }
            return arr[amount];
        }

        private int recursionSlowApproach(int amount, int[] coins) {
            if (amount == 0) {
                return 1;
            }
            counter = 0;
            Arrays.sort(coins);
            runDFS(amount, coins, 0);
            return counter;
        }

        private void runDFS(int amount, int[] coins, int from) {

            for (int i = from; i < coins.length; i++) {
                int coin = coins[i];

                if (coins[i] == amount) {
                    //System.out.println("   ".repeat(lastCoin) + "Match coin: " + coin + ", amount: " + amount);
                    counter++;
                    break;
                } else if (amount < coins[i]) {
                    continue;
                }

                //System.out.println("   ".repeat(lastCoin) + "Call coin: " + coin + ", amount: " + amount);
                runDFS(amount - coin, coins, i);
            }

        }
    }
}
