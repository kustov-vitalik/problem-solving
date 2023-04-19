package com.leetcode.problem.combinations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <a href="https://leetcode.com/problems/subsets/description/">Problem description</a>
 */
public class Solved_Problem78Subsets {
    public static void main(String[] args) {
        System.out.println(new Solution().subsets(new int[] {0,1,2}));
    }

    private static class Solution {

        public List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> output = new ArrayList<>();
            for (int i = 0; i <= nums.length; i++) {
                generateCombinations(nums.length, i, output, nums);
            }
            return output;
        }

        private void generateCombinations(int n, int k, List<List<Integer>> output, int[] nums) {
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
                                .map(i -> nums[i])
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
