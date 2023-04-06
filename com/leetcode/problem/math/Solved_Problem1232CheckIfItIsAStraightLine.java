package com.leetcode.problem.math;

/**
 * <a href="https://leetcode.com/problems/check-if-it-is-a-straight-line/">Problem description</a>
 */
public class Solved_Problem1232CheckIfItIsAStraightLine {

  public static void main(String[] args) {

  }

  static class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
      if (coordinates.length == 2) {
        return true;
      }
      int x0 = coordinates[0][0];
      int y0 = coordinates[0][1];

      int x1 = coordinates[1][0];
      int y1 = coordinates[1][1];

      if (x1 == x0 && y1 == y0) {
        throw new RuntimeException("Duplicate point");
      }

      // line: y = k*x + b

      if (x1 == x0) {
        // k = Inf. => all X are equal.
        for (int[] coordinate : coordinates) {
          if (coordinate[0] != x0) {
            return false;
          }
        }

        return true;
      } else {
        double eps = 1e-8;
        double k = 1.0*(y1 - y0)/(x1 - x0);
        double b = y0 - k*x0;

        for (int[] coordinate : coordinates) {
          // can't compare double using == operator
          if (Math.abs(coordinate[1] - k * coordinate[0] - b) > eps) {
            return false;
          }
        }

        return true;
      }
    }
  }
}
