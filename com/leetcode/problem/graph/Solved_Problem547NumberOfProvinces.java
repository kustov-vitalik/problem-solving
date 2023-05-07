package com.leetcode.problem.graph;

/**
 * <a href="https://leetcode.com/problems/number-of-provinces/">Problem description</a>
 */
public class Solved_Problem547NumberOfProvinces {
    public static void main(String[] args) {
        System.out.println(new Solution().findCircleNum(new int[][]{{1,1,0}, {1,1,0}, {0,0,1}})); // 2
    }

    private static class Solution {
        public int findCircleNum(int[][] isConnected) {
            boolean[] visited = new boolean[isConnected.length];
            int n = isConnected.length;

            int circleNum = 0;

            for (int i = 0; i < n; i++) {
                if (!visited[i]) {
                    circleNum++;
                    dfs(i, isConnected, visited);
                }
            }

            return circleNum;
        }

        private void dfs(int node, int[][] isConnected, boolean[] visited) {
            visited[node] = true;
            for (int i = 0; i < isConnected.length; i++) {
                if (isConnected[node][i] == 1 && !visited[i]) {
                    dfs(i, isConnected, visited);
                }
            }
        }
    }
}
