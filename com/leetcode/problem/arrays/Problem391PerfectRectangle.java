package com.leetcode.problem.arrays;

/**
 * <a href="https://leetcode.com/problems/perfect-rectangle/">Problem description</a>
 */
public class Problem391PerfectRectangle {

  public static void main(String[] args) {

    System.out.println(new Problem391PerfectRectangle().isRectangleCover(new int[][]{
        {1,1,3,3},{3,1,4,2},{3,2,4,4},{1,3,2,4},{2,3,3,4}
    })); // true

    System.out.println(new Problem391PerfectRectangle().isRectangleCover(new int[][]{
        {1,1,2,3},{1,3,2,4},{3,1,4,2},{3,2,4,4}
    })); // false - doesn't cover

    System.out.println(new Problem391PerfectRectangle().isRectangleCover(new int[][]{
        {1,1,3,3},{3,1,4,2},{1,3,2,4},{2,2,4,4}
    })); // false - intersect

  }

  public boolean isRectangleCover(int[][] rectangles) {
    return false;
  }

}
