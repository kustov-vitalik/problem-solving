package net.projecteuler.problem;

import java.math.BigInteger;

public class Problem20FactorialDigitSum {

  public static void main(String[] args) {

    String factorial100 = factorial(BigInteger.valueOf(100)).toString();

    long result = 0;
    for (int i = 0; i < factorial100.length(); i++) {
      result += Integer.parseInt(String.valueOf(factorial100.charAt(i)));
    }
    System.out.println("result: " + result);

  }

  static BigInteger factorial(BigInteger num) {

    if (num.compareTo(BigInteger.ONE) == 0) {
      return BigInteger.ONE;
    }

    if (num.compareTo(BigInteger.TWO) == 0) {
      return BigInteger.TWO;
    }

    return num.multiply(factorial(num.subtract(BigInteger.ONE)));
  }

}
