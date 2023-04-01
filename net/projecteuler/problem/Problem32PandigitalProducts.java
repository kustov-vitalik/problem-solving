package net.projecteuler.problem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Problem32PandigitalProducts {

  public static void main(String[] args) {
    solution();
  }

  private static void solution() {
    Set<Integer> pandigitalProducts = new TreeSet<>();

    long result = 0;
    for (int i = 2; i < 10_000; i++) {
      if (!acceptNum(i)) {
        continue;
      }
      for (int j = 2; j < 10_000; j++) {
        if (!acceptNum(j)) {
          continue;
        }

        int product = i * j;
        if (!acceptNum(product)) {
          continue;
        }

        String productS = String.valueOf(product);
        String iS = String.valueOf(i);
        String jS = String.valueOf(j);

        String s = iS + jS + productS;
        int len = s.length();
        if (len > 9) {
          break;
        } else if (len < 9) {
          continue;
        }

        if (len == 9) {

          if (isPandigital(s)) {
            System.out.println(i + " x " + j + " = " + product);
            pandigitalProducts.add(product);
          }


        }
      }
    }

    System.out.println("Result: " + pandigitalProducts.stream().mapToInt(i -> i).sum()); // 45228
  }

  static boolean isPandigital(String s) {

    return new HashSet<>(Arrays.asList(s.split(""))).size() == 9;
  }

  static boolean acceptNum(int num) {

    List<Integer> digits = new ArrayList<>();

    do {
      int digit = num % 10;

      if (digit == 0) {
        return false;
      }

      if (digits.contains(digit)) {
        return false;
      }

      digits.add(digit);

      num /= 10;
    } while (num > 0);

    return digits.size() < 9;

  }

}
