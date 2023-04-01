package net.projecteuler.problem;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import net.projecteuler.problem.lib.Lib;

public class Problem53CombinatoricSelections {

  static Map<Integer, BigInteger> factorials = new HashMap<>();

  public static void main(String[] args) {

    for (BigInteger i = BigInteger.ONE; i.compareTo(BigInteger.valueOf(100L)) <= 0; i=i.add(BigInteger.ONE)) {
      factorials.put(i.intValue(), Lib.factorial(i));
    }
    factorials.put(0, BigInteger.ONE);

    int counter = 0;

    for (int n = 1; n <= 100; n++) {
      for (int r = 1; r <= n; r++) {
        if (combinatoricSelections(n, r).compareTo(BigInteger.valueOf(1_000_000L)) > 0) {
          counter++;
        }
      }
    }

    System.out.println("Result: " + counter);
  }

  static BigInteger combinatoricSelections(int n, int r) {

    return factorials.get(n).divide(factorials.get(r).multiply(factorials.get(n-r)));
  }

}
