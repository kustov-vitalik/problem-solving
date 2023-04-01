package net.projecteuler.problem;

import java.util.ArrayList;
import java.util.List;

public class Problem30DigitFifthPowers {

  public static void main(String[] args) {

    System.out.println(f(1010));

    long sum = 0;
    for (int i = 2; i < 100_000_000; i++) {
      if (f(i)) {
        sum+=i;
      }
    }

    System.out.println("Result: " + sum);

  }

  static boolean f(long num) {

    List<Long> digits = new ArrayList<>();

    long original = num;

    do {
      digits.add(num % 10);
      num /= 10;
    } while (num > 0);

    return original == digits.stream()
        .map(i -> i*i*i*i*i)
        .mapToLong(i -> i)
        .sum();
  }

}
