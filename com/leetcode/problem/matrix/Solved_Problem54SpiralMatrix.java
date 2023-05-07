package com.leetcode.problem.matrix;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/spiral-matrix/">Problem description</a>
 */
public class Solved_Problem54SpiralMatrix {
    public static void main(String[] args) {
        System.out.println(new Solution().spiralOrder(new int[][]{
                {1,2,3},
                {4,5,6},
                {7,8,9}
        }));

        System.out.println(new Solution().spiralOrder(new int[][]{
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12}
        }));
    }

    private static class Solution {
        public List<Integer> spiralOrder(int[][] matrix) {
            List<Integer> output = new ArrayList<>();
            int top = 0;
            int left = 0;
            int right = matrix[0].length - 1;
            int bottom = matrix.length - 1;

            while (top <= bottom && left <= right) {
                for (int i = left; i <= right && top <= bottom && left <= right; i++) {
                    output.add(matrix[top][i]);
                }
                top++;

                for (int i = top; i <= bottom && top <= bottom && left <= right; i++) {
                    output.add(matrix[i][right]);
                }
                right--;

                for (int i = right; i >= left && top <= bottom && left <= right; i--) {
                    output.add(matrix[bottom][i]);
                }
                bottom--;

                for (int i = bottom; i >= top && top <= bottom && left <= right; i--) {
                    output.add(matrix[i][left]);
                }
                left++;
            }


            return output;
        }
    }
}
