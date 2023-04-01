package net.projecteuler.problem;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Problem16PowerDigitSum {

  public static void main(String[] args) {

    final String bignumber = BigInteger.valueOf(2).pow(1000).toString(10);
    long result = 0;
    for (int i = 0; i < bignumber.length(); i++) {
      result += Integer.parseInt(String.valueOf(bignumber.charAt(i)));
    }
    System.out.println("result: " + result);

  }
}
