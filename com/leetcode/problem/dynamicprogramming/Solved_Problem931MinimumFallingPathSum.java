package com.leetcode.problem.dynamicprogramming;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/minimum-falling-path-sum/">Problem description</a>
 */
public class Solved_Problem931MinimumFallingPathSum {
    public static void main(String[] args) {
        System.out.println(new Solution().minFallingPathSum(new int[][]{
                {2,1,3},
                {6,5,4},
                {7,8,9},
        })); // 13 (1+5+7 || 1+4+8)

        System.out.println(new Solution().minFallingPathSum(new int[][]{
                {-19,57},
                {-40,-5},
        })); // -59 (-19 + -40)
    }

    private static class Solution {
        public int minFallingPathSum(int[][] matrix) {
            int n = matrix.length;

            for (int i = 1; i < n; i++) {
                for (int j = 0; j < n; j++) {

                    int top = matrix[i-1][j];
                    int left = j == 0 ? top : matrix[i-1][j-1];
                    int right = j == n - 1 ? top : matrix[i-1][j+1];

                    matrix[i][j] += Math.min(top, Math.min(left, right));
                }
            }

            //Utils.printMatrix(matrix);

            return Arrays.stream(matrix[n-1]).min().getAsInt();
        }
    }
}
