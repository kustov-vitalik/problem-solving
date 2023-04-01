package net.projecteuler.problem;

import java.util.Arrays;

public class Problem15LatticePaths {

  public static void main(String[] args) {
    System.out.println(paths(2));
    System.out.println(paths(20));
  }

  static long paths(int num) {
    long[][] matrix = new long[num + 1][num + 1];
    for (int i = 0; i < matrix.length; i++) {
      matrix[i][0] = matrix[0][i] = 1;
    }
    matrix[0][0] = 0;

    for (int i = 0; i < matrix.length; i++) {
      System.out.println(Arrays.toString(matrix[i]));
    }

    System.out.println("---");

    System.out.println(Arrays.toString(matrix[0]));
    for (int i = 1; i < matrix.length; i++) {
      for (int j = 1; j < matrix[i].length; j++) {
        matrix[i][j] = matrix[i][j - 1] + matrix[i - 1][j];
      }
      System.out.println(Arrays.toString(matrix[i]));
    }

    return matrix[matrix.length - 1][matrix.length - 1];
  }

}
