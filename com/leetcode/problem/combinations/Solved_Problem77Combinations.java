package com.leetcode.problem.combinations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <a href="https://leetcode.com/problems/combinations/">Problem description</a>
 */
public class Solved_Problem77Combinations {
    public static void main(String[] args) {
        System.out.println(new Solution().combine(4, 2)); // [[1,2],[1,3],[1,4],[2,3],[2,4],[3,4]]
    }

    static class Solution {
        public List<List<Integer>> combine(int n, int k) {
            List<List<Integer>> output = new ArrayList<>();

            generateCombinations(n, k, output);

            return output;
        }

        private void generateCombinations(int n, int k, List<List<Integer>> output) {
            int[] combinations = new int[k + 2];
            for (int i = 0; i < k; i++) {
                combinations[i] = i;
            }
            combinations[k] = n;
            combinations[k + 1] = 0;

            while (true) {
                // get combination
                output.add(
                        Arrays.stream(Arrays.copyOf(combinations, k))
                                .boxed()
                                .map(i -> i + 1)
                                .collect(Collectors.toList())
                );

                int j = 0;
                while (combinations[j] + 1 == combinations[j + 1]) {
                    combinations[j] = j;
                    j++;
                }

                if (j < k) {
                    combinations[j]++;
                } else {
                    break;
                }
            }
        }
    }
}
