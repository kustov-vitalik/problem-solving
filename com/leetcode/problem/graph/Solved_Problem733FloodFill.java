package com.leetcode.problem.graph;

import java.util.Arrays;

public class Solved_Problem733FloodFill {

  public static void main(String[] args) {

    int[][] solution = new Solution().floodFill(new int[][]{{1, 1, 1}, {1, 1, 0}, {1, 0, 1}}, 1, 1, 2);
    for (int[] s : solution) {
      System.out.println(Arrays.toString(s));
      /*
      [2,2,2]
      [2,2,0]
      [2,0,1]
       */
    }
  }

  static class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
      int prevColor = image[sr][sc];

      replaceImageColor(image, sr, sc, prevColor, color);

      return image;

    }

    private void replaceImageColor(int[][] image, int i, int j, int prevColor, int newColor) {
      if (i < 0 || i > image.length - 1 || j < 0 || j > image[i].length - 1 || image[i][j] != prevColor || image[i][j] == newColor) {
        return;
      }

      image[i][j] = newColor;
      replaceImageColor(image, i-1, j, prevColor, newColor);
      replaceImageColor(image, i+1, j, prevColor, newColor);
      replaceImageColor(image, i, j-1, prevColor, newColor);
      replaceImageColor(image, i, j+1, prevColor, newColor);
    }
  }

}
