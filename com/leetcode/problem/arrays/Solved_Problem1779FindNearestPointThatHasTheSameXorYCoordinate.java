package com.leetcode.problem.arrays;

/**
 * <a href="https://leetcode.com/problems/find-nearest-point-that-has-the-same-x-or-y-coordinate">Problem description</a>
 */
public class Solved_Problem1779FindNearestPointThatHasTheSameXorYCoordinate {

  public static void main(String[] args) {
    System.out.println(new Solution().nearestValidPoint(3,4, new int[][]{
        {1,2},{3,1},{2,4},{2,3},{4,4}
    }));
  }

  static class Solution {
    public int nearestValidPoint(int x, int y, int[][] points) {

      int minDistance = Integer.MAX_VALUE;
      int index = -1;

      for (int i = 0; i < points.length; i++) {
        int[] point = points[i];
        if (x == point[0] || y == point[1]) {
          int distance = Math.abs(x - point[0]) + Math.abs(y - point[1]);
          if (distance < minDistance) {
            minDistance = distance;
            index = i;
          }
        }
      }

      return index;
    }
  }

}
