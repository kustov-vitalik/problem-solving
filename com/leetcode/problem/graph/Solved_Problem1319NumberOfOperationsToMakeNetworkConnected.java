package com.leetcode.problem.graph;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/number-of-operations-to-make-network-connected/">Problem description</a>
 */
public class Solved_Problem1319NumberOfOperationsToMakeNetworkConnected {
    public static void main(String[] args) {
        System.out.println(new Solution().makeConnected(4, new int[][]{{0,1}, {0,2}, {1,2}})); // 1
        System.out.println(new Solution().makeConnected(6, new int[][]{{0,1}, {0,2}, {0,3}, {1,2}, {1,3}})); // 2
        System.out.println(new Solution().makeConnected(6, new int[][]{{0,1}, {0,2}, {0,3}, {1,2}})); // -1
    }

    private static class Solution {
        public int makeConnected(int n, int[][] connections) {

            if (n - 1 > connections.length) {
                return -1;
            }

            Map<Integer, Set<Integer>> adj = new HashMap<>();
            for (int[] connection : connections) {
                adj.computeIfAbsent(connection[0], k -> new HashSet<>()).add(connection[1]);
                adj.computeIfAbsent(connection[1], k -> new HashSet<>()).add(connection[0]);
            }

            boolean[] visited = new boolean[n];
            int numOfComponents = 0;
            for (int i = 0; i < n; i++) {
                if (!visited[i]) {
                    numOfComponents++;
                    dfs(i, adj, visited);
                }
            }

            return numOfComponents - 1;
        }

        private void dfs(int node, Map<Integer, Set<Integer>> adj, boolean[] visited) {
            visited[node] = true;
            if (!adj.containsKey(node)) {
                return;
            }
            for (int idx : adj.get(node)) {
                if (!visited[idx]) {
                    visited[idx] = true;
                    dfs(idx, adj, visited);
                }
            }
        }
    }
}
