package com.leetcode.common;

import java.util.Arrays;

public class Utils {
  public static void printMatrix(int[][] m) {
    for (int[] ints : m) {
      System.out.println(Arrays.toString(ints));
    }
  }
  public static void printMatrix(boolean[][] m) {
    for (boolean[] ints : m) {
      System.out.println(Arrays.toString(ints));
    }
  }
}
