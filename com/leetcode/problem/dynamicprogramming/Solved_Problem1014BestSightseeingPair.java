package com.leetcode.problem.dynamicprogramming;

/**
 * <a href="https://leetcode.com/problems/best-sightseeing-pair/">Problem description</a>
 */
public class Solved_Problem1014BestSightseeingPair {

    public static void main(String[] args) {
        System.out.println(new Solution().maxScoreSightseeingPair(new int[] {8,1,5,2,6})); // 11: i = 0, j = 2, values[i] + values[j] + i - j = 8 + 5 + 0 - 2 = 11
        System.out.println(new Solution().maxScoreSightseeingPair(new int[] {1,2})); // 2
        System.out.println(new Solution().maxScoreSightseeingPair(new int[] {2,2,2})); // 3
        System.out.println(new Solution().maxScoreSightseeingPair(new int[] {10,4,6,4,10})); // 16
        System.out.println(new Solution().maxScoreSightseeingPair(new int[] {6,9,10,5,9,10,4,5})); // 18
        System.out.println(new Solution().maxScoreSightseeingPair(new int[] {1,1,1,1,1,1,1,1,1,1})); // 1
        System.out.println(new Solution().maxScoreSightseeingPair(new int[] {30,13,28,32,16,8,11,78,83,5,22,93,61,60,100,8,6,48,87,43,41,86,93,5,19,29,59,31,7,51,99,47,40,24,20,98,41,42,81,92,55,85,51,92,84,21,84,92,1,73,93,51,44,27,23,54,32,57,60,9,69,14,28,86,15,92,47,63,12,99,54,6,16,52,28,86,38,73,16,52,37,30,84,81,46,97,84,17,21,14,52,19,74,20,20,56,89,7,34,21})); // 192
    }

    static class Solution {
        public int maxScoreSightseeingPair(int[] values) {
            return findMaxScoreSightseeingPair(values);
        }

        private int findMaxScoreSightseeingPair(int[] values) {
            int[] iValues = new int[values.length];
            int[] jValues = new int[values.length];

            for (int i = 0; i < values.length; i++) {
                iValues[i] = values[i] + i;
                jValues[i] = values[i] - i;
            }

            int jMax = Integer.MIN_VALUE;
            int max = Integer.MIN_VALUE;
            for (int i = iValues.length - 2; i >= 0; i--) {
                jMax = Math.max(jMax, jValues[i + 1]);
                max = Math.max(max, iValues[i] + jMax);
            }

            return max;
        }

        private int bruteForceNSquareTimeComplexity(int[] values) {
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < values.length - 1; i++) {
                for (int j = i + 1; j < values.length; j++) {
                    if (values[i] + values[j] + i - j > max) {
                        max = values[i] + values[j] + i - j;
                    }
                }
            }

            return max;
        }
    }
}
