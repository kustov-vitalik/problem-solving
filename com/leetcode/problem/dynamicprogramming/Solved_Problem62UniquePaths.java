package com.leetcode.problem.dynamicprogramming;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/unique-paths/">Problem description</a>
 */
public class Solved_Problem62UniquePaths {
    public static void main(String[] args) {
        System.out.println(new Solution().uniquePaths(3, 7));
        System.out.println(new Solution().uniquePaths(1, 1));
    }

    static class Solution {
        public int uniquePaths(int m, int n) {
            int[][] M = new int[m][n];
            Arrays.fill(M[0], 1);
            for (int i = 0; i < M.length; i++) {
                M[i][0] = 1;
            }

            for (int i = 1; i < M.length; i++) {
                for (int j = 1; j < M[i].length; j++) {
                    M[i][j] = M[i-1][j] + M[i][j-1];
                }
            }

            return M[m - 1][n - 1];
        }
    }
}
