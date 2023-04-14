package com.leetcode.problem.dynamicprogramming;

import java.util.List;

/**
 * <a href="https://leetcode.com/problems/triangle/">Problem description</a>
 */
public class Solved_Problem120Triangle {

    public static void main(String[] args) {
        System.out.println(new Solution().minimumTotal(List.of(
                List.of(2),
                List.of(3,4),
                List.of(6,5,7),
                List.of(4,1,8,3)
        ))); // 11 (2 + 3 + 5 + 1)
    }

    static class Solution {
        public int minimumTotal(List<List<Integer>> triangle) {

            int[] dp = new int[triangle.size()];
            List<Integer> lastRow = triangle.get(triangle.size() - 1);
            for (int i = 0; i < dp.length; i++) {
                dp[i] = lastRow.get(i);
            }

            for (int i = triangle.size() - 2; i >= 0; i--) {
                List<Integer> row = triangle.get(i);
                for (int j = 0; j < row.size(); j++) {
                    dp[j] = Math.min(dp[j] + row.get(j), dp[j+1] + row.get(j));
                }
            }

            return dp[0];
        }
    }
}
