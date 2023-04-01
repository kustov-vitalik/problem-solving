package net.projecteuler.problem;

import java.math.BigInteger;
import java.util.Arrays;
import net.projecteuler.problem.lib.Lib;

public class Problem56PowerfulDigitSum {

  public static void main(String[] args) {

    int maxSum = 0;
    for (int i = 0; i <= 100; i++) {
      for (int j = 0; j <= 100; j++) {
        int sum = Arrays.stream(Lib.digits(BigInteger.valueOf(i).pow(j).toString())).sum();
        if (sum > maxSum) {
          maxSum = sum;
        }
      }
    }

    System.out.println("Result: " + maxSum);

  }

}
