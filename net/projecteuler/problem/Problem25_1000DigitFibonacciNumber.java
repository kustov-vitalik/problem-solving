package net.projecteuler.problem;

import java.math.BigInteger;

public class Problem25_1000DigitFibonacciNumber {

  static BigInteger pPrev = BigInteger.ONE;
  static BigInteger prev = BigInteger.ONE;

  public static void main(String[] args) {

    BigInteger fib;
    long i = 3;
    boolean lookFor = true;
    do {
      fib = pPrev.add(prev);

      if (countOfDigits(fib) >= 1000) {
        System.out.println("Result: " + i); // 4782
        lookFor = false;
      }

      pPrev = prev;
      prev = fib;
      i++;
    } while (lookFor);

  }

  static int countOfDigits(BigInteger num) {
    return num.toString().length();
  }

}
