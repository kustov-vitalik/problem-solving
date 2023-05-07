package com.leetcode.problem.graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <a href="https://leetcode.com/problems/nearest-exit-from-entrance-in-maze/">Problem description</a>
 */
public class Solved_Problem1926NearestExitFromEntranceInMaze {
    public static void main(String[] args) {
        System.out.println(new Solution().nearestExit(new char[][]{
                {'+','+','.','+'},
                {'.','.','.','+'},
                {'+','+','+','.'}
        }, new int[]{1,2})); // 1

        System.out.println(new Solution().nearestExit(new char[][]{
                {'+','+','+'},
                {'.','.','.'},
                {'+','+','+'}
        }, new int[]{1,0})); // 2

        System.out.println(new Solution().nearestExit(new char[][]{
                {'.','+'}
        }, new int[]{0,0})); // -1
    }

    private static class Solution {

        static int[][] directions = new int[][]{{-1,0},{1,0},{0,1},{0,-1}};
        public int nearestExit(char[][] maze, int[] entrance) {

            Queue<Point> queue = new LinkedList<>();
            queue.offer(new Point(entrance[0], entrance[1]));
            int steps = 0;
            while (!queue.isEmpty()) {
                int size = queue.size();

                while (size-- > 0) {
                    var point = queue.poll();

                    maze[point.x][point.y] = '+';

                    for (int[] direction : directions) {
                        var nextPoint = new Point(point.x + direction[0], point.y + direction[1]);

                        if (nextPoint.x < 0 || nextPoint.x > maze.length - 1 ||
                                nextPoint.y < 0 || nextPoint.y > maze[nextPoint.x].length - 1) {
                            continue;
                        }

                        if (maze[nextPoint.x][nextPoint.y] == '.') {
                            if (nextPoint.x == 0 || nextPoint.x == maze.length - 1 ||
                                    nextPoint.y == 0 || nextPoint.y == maze[nextPoint.x].length - 1) {
                                return steps + 1;
                            } else {
                                maze[nextPoint.x][nextPoint.y] = '+';
                                queue.offer(nextPoint);
                            }
                        }
                    }
                }
                steps++;
            }

            return -1;
        }

        private static class Point {
            final int x;
            final int y;

            public Point(final int x, final int y) {
                this.x = x;
                this.y = y;
            }
        }
    }
}
