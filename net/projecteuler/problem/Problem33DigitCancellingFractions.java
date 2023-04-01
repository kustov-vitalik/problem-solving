package net.projecteuler.problem;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Problem33DigitCancellingFractions {

  public static void main(String[] args) {
    solution();
  }

  private static void solution() {

    int numeratorProduct = 1;
    int denominatorProduct = 1;

    for (int i = 10; i < 100; i++) {
      for (int j = i + 1; j < 100; j++) {
        if (isCurious(i, j)) {
          System.out.println(i + "/" + j);
          numeratorProduct *= i;
          denominatorProduct *= j;
        }
      }
    }

    System.out.println(numeratorProduct + "/" + denominatorProduct + " = " + ((double)numeratorProduct)/denominatorProduct);

    int limit = numeratorProduct;
    for (int i = 2; i < limit / 2 + 1; i++) {
      while (numeratorProduct % i == 0 && denominatorProduct % i == 0) {
        numeratorProduct /= i;
        denominatorProduct /= i;
      }
    }


    System.out.println(numeratorProduct + "/" + denominatorProduct + " = " + ((double)numeratorProduct)/denominatorProduct);


  }

  static boolean isCurious(int a, int b) {

    if (a % 10 == 0 && b % 10 == 0) {
      // trivial case
      return false;
    }

    List<Integer> aDigits = digits(a);
    List<Integer> bDigits = digits(b);

    Integer commonDigit = null;
    for (var tA: aDigits) {
      if (bDigits.contains(tA)) {
        commonDigit = tA;
      }
    }

    if (commonDigit == null) {
      return false;
    }

    aDigits.remove(commonDigit);
    bDigits.remove(commonDigit);

    if (aDigits.size() != 1) {
      return false;
    }

    int newA = List.copyOf(aDigits).get(0);
    int newB = List.copyOf(bDigits).get(0);

    return (((double) a)/b) == (((double) newA)/newB);
  }

  static List<Integer> digits(int num) {
    List<Integer> digits = new ArrayList<>();

    do {
      digits.add(num % 10);
      num /= 10;
    } while (num > 0);

    return digits;
  }

}
