package com.leetcode.problem.graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <a href="https://leetcode.com/problems/as-far-from-land-as-possible/">Problem description</a>
 */
public class Solved_Problem1162AsFarFromLandAsPossible {

  public static void main(String[] args) {
    System.out.println(new Solution().maxDistance(new int[][]{
        {1, 0, 1},
        {0, 0, 0},
        {1, 0, 1},
    })); // 2

    System.out.println(new Solution().maxDistance(new int[][]{
        {1, 0, 0},
        {0, 0, 0},
        {0, 0, 0},
    })); // 4

    System.out.println(new Solution().maxDistance(new int[][]{
        {0, 0, 0},
        {0, 0, 0},
        {0, 0, 0},
    })); // -1

    System.out.println(new Solution().maxDistance(new int[][]{
        {1, 1, 1},
        {1, 1, 1},
        {1, 1, 1},
    })); // -1
  }

  static class Solution {

    // Four directions: Up, Down, Left and Right.
    int[][] direction = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    static class Pair<K, V> {

      K key;
      V value;

      public Pair(K key, V value) {
        this.key = key;
        this.value = value;
      }

      public K getKey() {
        return key;
      }

      public V getValue() {
        return value;
      }
    }

    //copy-paste
    public int maxDistance(int[][] grid) {
      // A copy matrix of the grid to mark water cells as land once visited.
      int[][] visited = new int[grid.length][grid[0].length];

      // Insert all the land cells in the queue.
      Queue<Pair<Integer, Integer>> q = new LinkedList<>();
      for (int i = 0; i < grid.length; i++) {
        for (int j = 0; j < grid[0].length; j++) {
          // Copy grid to the visited matrix.
          visited[i][j] = grid[i][j];
          if (grid[i][j] == 1) {
            q.offer(new Pair(i, j));
          }
        }
      }

      int distance = -1;
      while (!q.isEmpty()) {
        int qSize = q.size();

        // Iterate over all the current cells in the queue.
        while (qSize-- > 0) {
          Pair<Integer, Integer> landCell = q.poll();

          // From the current land cell, traverse to all the four directions
          // and check if it is a water cell. If yes, convert it to land
          // and add it to the queue.
          for (int[] dir : direction) {
            int x = landCell.getKey() + dir[0];
            int y = landCell.getValue() + dir[1];

            if (x >= 0 && y >= 0 && x < grid.length && y < grid[0].length && visited[x][y] == 0) {
              // Marking as 1 to avoid re-iterating it.
              visited[x][y] = 1;
              q.offer(new Pair(x, y));
            }
          }
        }

        // After each iteration of queue elements, increment distance
        // as we covered 1 unit distance from all cells in every direction.
        distance++;
      }

      // If the distance is 0, there is no water cell.
      return distance == 0 ? -1 : distance;
    }
  }
}
