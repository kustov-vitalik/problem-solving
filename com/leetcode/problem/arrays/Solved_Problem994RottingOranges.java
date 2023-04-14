package com.leetcode.problem.arrays;

import com.leetcode.common.Utils;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <a href="https://leetcode.com/problems/rotting-oranges/submissions/933263919/">Problem description</a>
 */
public class Solved_Problem994RottingOranges {
    public static void main(String[] args) {
        System.out.println(new Solution().orangesRotting(new int[][]{
                {2,1,1},
                {1,1,0},
                {0,1,1},
        })); // 4
    }

    static class Solution {
        public int orangesRotting(int[][] grid) {

            int[][] directions = new int[][] {{1,0}, {-1,0}, {0, 1}, {0, -1}};

            Queue<Point> queue = new LinkedList<>();
            boolean hasOnes = false;
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length; j++) {
                    if (grid[i][j] == 2) {
                        queue.offer(new Point(i, j));
                    }

                    if (grid[i][j] == 1) {
                        hasOnes = true;
                    }
                }
            }

            if (!hasOnes) {
                return 0;
            }

            int days = 0;
            while (!queue.isEmpty()) {
                int size = queue.size();
                while (size-- > 0) {
                    Point point = queue.poll();

                    for (int[] direction : directions) {
                        Point toPoint = new Point(point.x + direction[0], point.y + direction[1]);

                        if (toPoint.x < 0 || toPoint.x >= grid.length
                                || toPoint.y < 0 || toPoint.y >= grid[toPoint.x].length) {
                            continue;
                        }

                        if (grid[toPoint.x][toPoint.y] == 1) {
                            grid[toPoint.x][toPoint.y] = 2;
                            queue.offer(toPoint);
                        }
                    }
                }

                Utils.printMatrix(grid);
                System.out.println("---");

                days++;
            }

            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length; j++) {
                    if (grid[i][j] == 1) {
                        return -1;
                    }
                }
            }

            return days - 1;
        }

        static class Point {
            int x;
            int y;

            public Point(int x, int y) {
                this.x = x;
                this.y = y;
            }
        }
    }
}
