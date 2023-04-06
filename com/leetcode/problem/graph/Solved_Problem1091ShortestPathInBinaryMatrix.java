package com.leetcode.problem.graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <a href="https://leetcode.com/problems/shortest-path-in-binary-matrix">Problem description</a>
 */
public class Solved_Problem1091ShortestPathInBinaryMatrix {

  public static void main(String[] args) {
    System.out.println(new Solution().shortestPathBinaryMatrix(new int[][]{
        {0, 1},
        {1, 0}
    })); // 2

    System.out.println(new Solution().shortestPathBinaryMatrix(new int[][]{
        {0, 0, 0},
        {1, 1, 0},
        {1, 1, 0},
    })); // 4

    System.out.println(new Solution().shortestPathBinaryMatrix(new int[][]{
        {1, 0, 0},
        {1, 1, 0},
        {1, 1, 0},
    })); // -1

    System.out.println(new Solution().shortestPathBinaryMatrix(new int[][]{
        {1, 0, 0},
        {1, 1, 0},
        {1, 1, 0},
    })); // -1

    System.out.println(new Solution().shortestPathBinaryMatrix(new int[][]{
        {0, 0, 0},
        {0, 1, 0},
        {0, 0, 0},
    })); // 4

    System.out.println(new Solution().shortestPathBinaryMatrix(new int[][]{
        {0, 0, 1, 0},
        {0, 0, 1, 0},
        {1, 1, 1, 0},
        {0, 0, 0, 0},
    })); // -1
  }

  static class Solution {

    public int shortestPathBinaryMatrix(int[][] grid) {
      if (grid[0][0] == 1 || grid[grid.length - 1][grid[0].length - 1] == 1) {
        return -1;
      }

      boolean[][] visited = new boolean[grid.length][grid[0].length];
      Queue<Point> queue = new LinkedList<>();
      queue.offer(new Point(0, 0));

      int[][] directions = new int[][]{
          {0, 1},
          {0, -1},
          {1, 0},
          {1, -1},
          {1, 1},
          {-1, 0},
          {-1, 1},
          {-1, -1},
      };

      int distance = 0;
      while (!queue.isEmpty()) {
        int size = queue.size();
        while (size-- > 0) {
          var point = queue.poll();

          if (visited[point.x][point.y]) {
            continue;
          }

          visited[point.x][point.y] = true;

          if (point.x == grid.length - 1 && point.y == grid[0].length - 1) {
            return distance + 1;
          }

          for (int[] direction : directions) {
            var p = new Point(point.x + direction[0], point.y + direction[1]);
            // check bounds
            if (p.x < 0 || p.x > grid.length - 1 ||
                p.y < 0 || p.y > grid[0].length - 1) {
              continue;
            }

            if (visited[p.x][p.y]) {
              continue;
            }

            if (grid[p.x][p.y] == 0) {
              queue.offer(p);
            }
          }
        }
        distance++;
      }

      return -1;
    }

    static class Point {

      int x;
      int y;

      public Point(int x, int y) {
        this.x = x;
        this.y = y;
      }

      @Override
      public String toString() {
        return "{" + x +
            ", " + y +
            '}';
      }
    }
  }
}
