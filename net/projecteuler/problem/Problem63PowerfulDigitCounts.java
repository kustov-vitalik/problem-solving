package net.projecteuler.problem;

import java.math.BigInteger;
import net.projecteuler.problem.lib.Lib;

public class Problem63PowerfulDigitCounts {

  public static void main(String[] args) {

    int counter = 0;

    for (BigInteger i = BigInteger.ONE; i.compareTo(BigInteger.valueOf(100)) < 0;
        i = i.add(BigInteger.ONE)) {
      for (int j = 1; j < 100; j++) {
        var pow = i.pow(j);
        int length = Lib.digits(pow.toString()).length;

        if (j != length) {
          continue;
        }

        counter++;
      }
    }

    System.out.println("Result: " + counter); // 49

  }

}
