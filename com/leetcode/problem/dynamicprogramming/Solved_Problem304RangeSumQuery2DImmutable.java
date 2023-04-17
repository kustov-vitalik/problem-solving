package com.leetcode.problem.dynamicprogramming;

/**
 * <a href="https://leetcode.com/problems/range-sum-query-2d-immutable/">Problem description</a>
 */
public class Solved_Problem304RangeSumQuery2DImmutable {
    public static void main(String[] args) {
        var M = new NumMatrix(new int[][]{
                {3, 0, 1, 4, 2},
                {5, 6, 3, 2, 1},
                {1, 2, 0, 1, 5},
                {4, 1, 0, 1, 7},
                {1, 0, 3, 0, 5},
        });

        System.out.println(M.sumRegion(2, 1, 4, 3));
        System.out.println(M.sumRegion(1, 1, 2, 2));
        System.out.println(M.sumRegion(1, 2, 2, 4));
    }

    private static class NumMatrix {

        int[][] sums;

        public NumMatrix(int[][] matrix) {
            sums = new int[matrix.length][matrix[0].length];

            int leftSum;
            for (int i = 0; i < sums.length; i++) {
                leftSum = 0;
                for (int j = 0; j < sums[i].length; j++) {
                    leftSum += (j > 0 ? matrix[i][j - 1] : 0);
                    sums[i][j] = matrix[i][j]
                            + (i > 0 ? sums[i - 1][j] : 0)
                            + leftSum;
                }
            }

        }

        public int sumRegion(int row1, int col1, int row2, int col2) {

            int totalSum = sums[row2][col2];
            int topSum = row1 > 0 ? sums[row1 - 1][col2] : 0;
            int leftSum = col1 > 0 ? sums[row2][col1 - 1] : 0;
            int crossedSum = row1 > 0 && col1 > 0 ? sums[row1 - 1][col1 - 1] : 0;


            return totalSum - topSum - leftSum + crossedSum;
        }
    }
}
