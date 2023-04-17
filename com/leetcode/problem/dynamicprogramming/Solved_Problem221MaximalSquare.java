package com.leetcode.problem.dynamicprogramming;

/**
 * <a href="https://leetcode.com/problems/maximal-square/">Problem description</a>
 */
public class Solved_Problem221MaximalSquare {
    public static void main(String[] args) {
        System.out.println(new Solution().maximalSquare(new char[][]{
                {'0', '1'},
                {'1', '0'},
        })); // 1

        System.out.println(new Solution().maximalSquare(new char[][]{
                {'1','0','1','0','0'},
                {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','0','1','0'},
        })); // 4


    }

    private static class Solution {
        public int maximalSquare(char[][] matrix) {
            int[][] dp = new int[matrix.length][matrix[0].length];
            int max = 0;
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    dp[i][j] = Integer.parseInt("" + matrix[i][j]);
                    if (dp[i][j] == 1) {
                        max = 1;
                    }
                }
            }

            for (int i = 1; i < dp.length; i++) {
                for (int j = 1; j < dp[i].length; j++) {
                    if (dp[i][j] == 1) {
                        dp[i][j] = Math.min(dp[i-1][j], Math.min(dp[i-1][j-1], dp[i][j-1])) + 1;
                        max = Math.max(max, dp[i][j]);
                    }
                }
            }

            return max * max;
        }
    }
}
