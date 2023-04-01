package net.projecteuler.problem;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Problem67MaximumPathSum2 {

  public static void main(String[] args) throws IOException {

    List<String> strings = Files.readAllLines(Path.of("p067_triangle.txt"));


    int[][] matrix = new int[strings.size()][strings.size()];

    for (int i = 0; i < strings.size(); i++) {
      String row = strings.get(i);

      int col = 0;
      for (String s : row.split(" ")) {
        matrix[i][col] = Integer.parseInt(s);
        col++;
      }
    }



    for (int i = matrix.length - 1; i > 0; i--) {
      for (int j = 0; j < matrix[i].length - 1; j++) {
        matrix[i - 1][j] += Math.max(matrix[i][j], matrix[i][j + 1]);
      }
    }

    System.out.println("Result - " + matrix[0][0]);

  }

}
