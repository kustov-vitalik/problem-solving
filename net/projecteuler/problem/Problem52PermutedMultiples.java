package net.projecteuler.problem;

import java.util.Arrays;
import net.projecteuler.problem.lib.Lib;

public class Problem52PermutedMultiples {

  public static void main(String[] args) {

    for (int i = 100_000; i < 1_000_000; i++) {
      if (sameDigits(i, 2*i)) {
        if (sameDigits(i, 3*i)) {
          if (sameDigits(i, 4*i)) {
            if (sameDigits(i, 5*i)) {
              if (sameDigits(i, 6*i)) {
                System.out.println(i + ", 2: " + 2*i + ", 3: " + 3*i + ", 4: " + 4*i + ", 5: " + 5*i + ", 6: " + 6*i);
                // 142857
              }
            }
          }
        }
      }
    }

  }

  private static boolean sameDigits(int a, int b) {
    int[] digitsA = Lib.digits(a);
    Arrays.sort(digitsA);
    int[] digitsB = Lib.digits(b);
    Arrays.sort(digitsB);
    return Arrays.equals(digitsA, digitsB);
  }

}
