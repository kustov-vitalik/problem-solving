package com.leetcode.problem.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/all-paths-from-source-to-target/">Problem description</a>
 */
public class Solved_Problem797AllPathsFromSourceToTarget {
    public static void main(String[] args) {
        System.out.println(new Solution().allPathsSourceTarget(new int[][]{{1, 2}, {3}, {3}, {}}));
    }

    private static class Solution {
        public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
            List<List<Integer>> output = new ArrayList<>();

            List<Integer> first = new ArrayList<>();
            first.add(0);
            fillPaths(output, first, 0, graph);
            return output;
        }

        private void fillPaths(List<List<Integer>> output, List<Integer> current, int position, int[][] graph) {

            if (position == graph.length - 1) {
                output.add(current);
                return;
            }

            for (final int idx : graph[position]) {
                List<Integer> next = new ArrayList<>(current);
                next.add(idx);
                fillPaths(output, next, idx, graph);
            }
        }
    }
}
