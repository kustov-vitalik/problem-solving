package com.leetcode.problem.graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <a href="https://leetcode.com/problems/shortest-bridge/">Problem description</a>
 */
public class Solved_Problem934ShortestBridge {
    public static void main(String[] args) {
        System.out.println(new Solution().shortestBridge(new int[][]{
                {0,1},
                {1,0}
        })); // 1

        System.out.println(new Solution().shortestBridge(new int[][]{
                {0,1,0},
                {0,0,0},
                {0,0,1}
        })); // 2

        System.out.println(new Solution().shortestBridge(new int[][]{
                {1,1,1,1,1},
                {1,0,0,0,1},
                {1,0,1,0,1},
                {1,0,0,0,1},
                {1,1,1,1,1}
        })); // 1
    }

    private static class Solution {
        public int shortestBridge(int[][] grid) {

            colorOneIsland(grid);

            Queue<Point> queue = new LinkedList<>();
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length; j++) {
                    if (grid[i][j] == 1) {
                        queue.offer(new Point(i, j, 0));
                    }
                }
            }

            int[][] directions = new int[][] {{-1,0},{1,0},{0,1},{0,-1}};

            while (!queue.isEmpty()) {
                int size = queue.size();

                while (size-- > 0) {
                    var point = queue.poll();

                    for (int[] direction : directions) {
                        var nextPoint = new Point(point.x + direction[0], point.y + direction[1], point.level + 1);

                        if (nextPoint.x < 0 || nextPoint.x > grid.length - 1
                                || nextPoint.y < 0 || nextPoint.y > grid[nextPoint.x].length - 1) {
                            continue;
                        }

                        if (grid[nextPoint.x][nextPoint.y] == 0) {
                            grid[nextPoint.x][nextPoint.y] = 1;
                            queue.offer(nextPoint);
                        } else if (grid[nextPoint.x][nextPoint.y] == 2) {

                            return point.level;
                        }
                    }
                }
            }

            return 0;
        }

        private static class Point {
            int x;
            int y;
            int level;

            public Point(int x, int y, int level) {
                this.x = x;
                this.y = y;
                this.level = level;
            }
        }

        private void colorOneIsland(int[][] grid) {
            int col = -1, row = -1;
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length; j++) {
                    if (grid[i][j] == 1) {
                        row = i;
                        col = j;
                        break;
                    }
                }
                if (row != -1) {
                    break;
                }
            }

            colorTo2(grid, row, col);
        }

        private void colorTo2(int[][] grid, int i, int j) {
            if (i < 0 || i > grid.length - 1 || j < 0 || j > grid[i].length - 1 || grid[i][j] == 0 || grid[i][j] == 2) {
                return;
            }

            grid[i][j] = 2;
            colorTo2(grid, i-1, j);
            colorTo2(grid, i+1, j);
            colorTo2(grid, i, j-1);
            colorTo2(grid, i, j+1);
        }
    }
}
