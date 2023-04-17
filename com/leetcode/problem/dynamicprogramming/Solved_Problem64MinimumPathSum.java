package com.leetcode.problem.dynamicprogramming;

import com.leetcode.common.Utils;

/**
 * <a href="https://leetcode.com/problems/minimum-path-sum/">Problem description</a>
 */
public class Solved_Problem64MinimumPathSum {
    public static void main(String[] args) {
        System.out.println(new Solution().minPathSum(new int[][]{
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1},
        })); // 7

        System.out.println(new Solution().minPathSum(new int[][]{
                {1, 2, 3},
                {4, 5, 6},
        })); // 12

        System.out.println(new Solution().minPathSum(new int[][]{
                {1, 2},
                {1, 1},
        })); // 3
    }

    private static class Solution {
        public int minPathSum(int[][] grid) {

            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length; j++) {
                    int top = i > 0 ? grid[i-1][j] : Integer.MAX_VALUE;
                    int left = j > 0 ? grid[i][j-1] : 0;

                    if (j == 0 && i != 0) {
                        left = top;
                    }

                    grid[i][j] += Math.min(left, top);
                }
            }

            return grid[grid.length - 1][grid[0].length - 1];
        }
    }
}
