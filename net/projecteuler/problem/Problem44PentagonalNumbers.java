package net.projecteuler.problem;

import java.util.Set;
import java.util.TreeSet;

public class Problem44PentagonalNumbers {

  public static void main(String[] args) {

    Set<Integer> pentagonalNumbers = new TreeSet<>();
    for (int i = 1; i < 100_000; i++) {
      pentagonalNumbers.add(pentagonal(i));
    }

    for (int i = 1; i < 10_000; i++) {
      for (int j = i + 1; j < 10_000; j++) {
        int fj = pentagonal(j);
        int fi = pentagonal(i);
        int diff = fj - fi;
        int sum = fj + fi;
        if (pentagonalNumbers.contains(diff) && pentagonalNumbers.contains(sum)) {
          System.out.println("Diff: " + diff); // 5482660
        }
      }
    }
  }

  static int pentagonal(int n) {
    return n * (3 * n - 1) / 2;
  }

}
