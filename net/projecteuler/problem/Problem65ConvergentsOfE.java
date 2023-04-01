package net.projecteuler.problem;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import net.projecteuler.problem.lib.Lib;

public class Problem65ConvergentsOfE {

  public static void main(String[] args) {

    int num = 98;
    Ratio sum = new Ratio(BigInteger.valueOf(eDigit(num)), BigInteger.ONE);

    for (int i = num; i >= 0; i--) {
      sum = sum.revert().plus(new Ratio(BigInteger.valueOf(eDigit(i - 1)), BigInteger.ONE));


    }
    System.out.println(sum);

    BigInteger numerator = sum.numerator;

    int sumDigits = Arrays.stream(Lib.digits(numerator.toString())).sum();

    System.out.println("Result: " + sumDigits); //272

  }

  static int eDigit(int position) {

    if (position == -1) {
      return 2;
    }

    if (position % 3 == 0 || position % 3 == 2) {
      return 1;
    }

    return (position/3 + 1) * 2;
  }


  public static double e(int deep) {


    return 2 + 1.0/eDigit(0);

  }



  static class Ratio {
    BigInteger numerator;
    BigInteger denominator;

    public Ratio(BigInteger numerator, BigInteger denominator) {
      this.numerator = numerator;
      this.denominator = denominator;
    }

    public Ratio plus(Ratio ratio) {
      return new Ratio(numerator.multiply(ratio.denominator).add(denominator.multiply(ratio.numerator)), denominator.multiply(ratio.denominator));
    }

    public Ratio revert() {
      return new Ratio(denominator, numerator);
    }

    @Override
    public String toString() {
      return numerator + "/" + denominator;
    }
  }



}
