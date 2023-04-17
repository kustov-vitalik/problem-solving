package com.leetcode.problem.dynamicprogramming;

/**
 * <a href="https://leetcode.com/problems/unique-paths-ii/">Problem description</a>
 */
public class Solved_Problem63UniquePaths2 {
    public static void main(String[] args) {
        System.out.println(new Solution().uniquePathsWithObstacles(new int[][]{
                {0,0,0},
                {0,1,0},
                {0,0,0},
        })); // 2

        System.out.println(new Solution().uniquePathsWithObstacles(new int[][]{
                {0,1},
                {0,0},
        })); // 1
    }

    private static class Solution {
        public int uniquePathsWithObstacles(int[][] obstacleGrid) {
            int m = obstacleGrid.length;
            int n = obstacleGrid[0].length;

            int[][] dp = new int[m][n];

            for (int i = 0; i < m; i++) {
                if (obstacleGrid[i][0] == 1) {
                    break;
                }
                dp[i][0] = 1;
            }

            for (int i = 0; i < n; i++) {
                if (obstacleGrid[0][i] == 1) {
                    break;
                }
                dp[0][i] = 1;
            }

            for (int i = 1; i < dp.length; i++) {
                for (int j = 1; j < dp[i].length; j++) {

                    if (obstacleGrid[i][j] == 1) {
                        dp[i][j] = 0;
                        continue;
                    }

                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }

            //Utils.printMatrix(dp);

            return dp[dp.length - 1][dp[0].length - 1];
        }
    }
}
