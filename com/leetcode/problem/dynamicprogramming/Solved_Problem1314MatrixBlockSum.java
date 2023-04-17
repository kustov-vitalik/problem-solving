package com.leetcode.problem.dynamicprogramming;

import com.leetcode.common.Utils;

/**
 * <a href="https://leetcode.com/problems/matrix-block-sum/">Problem description</a>
 */
public class Solved_Problem1314MatrixBlockSum {
    public static void main(String[] args) {
        Utils.printMatrix(new Solution().matrixBlockSum(new int[][]{
                {1,2,3},
                {4,5,6},
                {7,8,9},
        }, 1));
    }

    private static class Solution {
        public int[][] matrixBlockSum(int[][] mat, int k) {
            int m = mat.length;
            int n = mat[0].length;

            int[][] ans = new int[m][n];

            int[][] t = new int[m + 1][n + 1];

            for (int i = 1; i < t.length; i++) {
                for (int j = 1; j < t[0].length; j++) {
                    t[i][j] = t[i - 1][j] + t[i][j - 1] + mat[i - 1][j - 1] - t[i - 1][j - 1];
                }
            }

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    int r1 = Math.max(0, i - k) + 1;
                    int c1 = Math.max(0, j - k) + 1;
                    int r2 = Math.min(m, i + k + 1);
                    int c2 = Math.min(n, j + k + 1);
                    ans[i][j] = t[r2][c2] - t[r1 - 1][c2] - t[r2][c1 - 1] + t[r1 - 1][c1 - 1];
                }
            }

            return ans;
        }
    }
}
