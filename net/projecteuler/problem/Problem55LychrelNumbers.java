package net.projecteuler.problem;

import java.math.BigInteger;
import java.util.Arrays;
import net.projecteuler.problem.lib.Lib;

public class Problem55LychrelNumbers {

  public static void main(String[] args) {

    int lychrelNumsCounter = 0;
    for (int i = 1; i < 10_000; i++) {
      if (isLychrelNum(BigInteger.valueOf(i), 50 - 1)) {
        lychrelNumsCounter++;
      }
    }

    System.out.println("Result: " + lychrelNumsCounter);

  }

  private static boolean isLychrelNum(BigInteger num, int iterationCount) {

    int[] digits = Lib.digits(num.toString());
    BigInteger revertedNum = Lib.digitsToBigNum(digits);

    var sum = num.add(revertedNum);

    if (Lib.isPalindrome(sum.toString())) {
      return false;
    } else {
      if (iterationCount > 0) {
        return isLychrelNum(sum, iterationCount - 1);
      } else {
        return true;
      }
    }
  }

}
