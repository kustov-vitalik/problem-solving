package com.leetcode.problem.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *
 */
public class Solved_Problem417PacificAtlanticWaterFlow {

  public static void main(String[] args) {
    System.out.println(new Solution().pacificAtlantic(new int[][]{
        {1, 2, 2, 3, 5},
        {3, 2, 3, 4, 4},
        {2, 4, 5, 3, 1},
        {6, 7, 1, 4, 5},
        {5, 1, 1, 2, 4}
    })); // [[0,4],[1,3],[1,4],[2,2],[3,0],[3,1],[4,0]]


    System.out.println(new Solution().pacificAtlantic(new int[][]{
        {1, 2, 2},
        {8, 9, 4},
        {7, 6, 5}
    })); // [[0,2],[1,0],[1,1],[1,2],[2,0],[2,1],[2,2]]
  }

  static class Solution {

    public List<List<Integer>> pacificAtlantic(int[][] heights) {

      var dp = oceanMap(heights, 0,0);
      var dp2 = oceanMap(heights, heights.length - 1,heights[0].length - 1);

      List<List<Integer>> output = new ArrayList<>();
      for (int i = 0; i < dp.length; i++) {
        for (int j = 0; j < dp[i].length; j++) {
          if (dp[i][j] == 1 && dp2[i][j] == 1) {
            output.add(List.of(i, j));
          }
        }
      }

//      Utils.printMatrix(dp);
//      System.out.println("");
//      Utils.printMatrix(dp2);

      return output;
    }

    static class Pair<K, V> {
      K x;
      V y;

      public Pair(K key, V value) {
        this.x = key;
        this.y = value;
      }

      @Override
      public String toString() {
        return "{" +x +
            ", " + y +'}';
      }
    }

    static Pair<Integer, Integer>[] directions = new Pair[] {new Pair<>(-1, 0), new Pair<>(1, 0), new Pair(0, -1), new Pair(0, 1)};

    private int[][] oceanMap(int[][] heights, int startX, int startY) {

      int[][] dp = new int[heights.length][heights[0].length];
      Queue<Pair<Integer, Integer>> queue = new LinkedList<>();

      for (int i = 0; i < dp.length; i++) {
        for (int j = 0; j < dp[i].length; j++) {
          if (i == startX || j == startY) {
            queue.add(new Pair<>(i, j));
            dp[i][j] = 1;
          }
        }
      }

      //System.out.println(queue);

      while (!queue.isEmpty()) {
        int size = queue.size();
        while (size-- > 0) {
          var current = queue.poll();

          dp[current.x][current.y] = 1;

          for (var direction: directions) {
            var next = new Pair<>(current.x + direction.x, current.y + direction.y);

            if (next.x >= 0 && next.x < dp.length && next.y >= 0 && next.y < dp[0].length
                && heights[next.x][next.y] >= heights[current.x][current.y] && dp[next.x][next.y] == 0) {
              queue.offer(next);
            }
          }
        }
      }

      return dp;
    }
  }
}
