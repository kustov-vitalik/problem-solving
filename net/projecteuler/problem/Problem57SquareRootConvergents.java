package net.projecteuler.problem;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;
import net.projecteuler.problem.lib.Lib;

public class Problem57SquareRootConvergents {

  static Map<Integer, Pair> expansions = new HashMap<>();

  public static void main(String[] args) {

    expansions.put(1, new Pair(BigDecimal.valueOf(3), BigDecimal.valueOf(2)));

    int result = 0;
    for (int i = 1; i <= 1000; i++) {
      if (f(i).numeratorLenExceedsDenominator()) {
        result++;
      }
    }

    System.out.println("Result: " + result); // 153

  }

  static Pair f(int n) {

    if (expansions.containsKey(n)) {
      return expansions.get(n);
    }

    expansions.put(n, new Pair(BigDecimal.ONE, BigDecimal.ONE).plus(new Pair(BigDecimal.ONE, BigDecimal.ONE).div(new Pair(BigDecimal.ONE, BigDecimal.ONE).plus(expansions.get(n - 1)))));

    return expansions.get(n);

  }

  static class Pair {

    BigDecimal numerator;
    BigDecimal denominator;

    public Pair(BigDecimal numerator, BigDecimal denominator) {
      this.numerator = numerator;
      this.denominator = denominator;
    }

    Pair plus(Pair pair) {
      return new Pair(numerator.multiply(pair.denominator).add(denominator.multiply(pair.numerator)),
          denominator.multiply(pair.denominator));
    }

    Pair div(Pair pair) {
      return new Pair(numerator.multiply(pair.denominator), denominator.multiply(pair.numerator));
    }

    boolean numeratorLenExceedsDenominator() {
      return numerator.toString().length() > denominator.toString().length();
    }

    String result() {
      return numerator.divide(denominator, 15, RoundingMode.FLOOR).toString();
    }

    @Override
    public String toString() {
      return "Pair{" +
          "numerator=" + numerator +
          ", denominator=" + denominator +
          '}';
    }
  }

}
