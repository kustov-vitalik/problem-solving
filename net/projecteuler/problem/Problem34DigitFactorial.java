package net.projecteuler.problem;

import java.util.ArrayList;
import java.util.List;

public class Problem34DigitFactorial {

  public static void main(String[] args) {

    int sum = 0;

    for (int i = 3; i < 1000_000; i++) {

      if (digits(i).stream()
          .map(Problem34DigitFactorial::factorial)
          .mapToInt(num -> num)
          .sum() == i) {
        System.out.println("Num: " + i);
        sum+= i;
      }

    }
    System.out.println("Result: " + sum);

  }

  static int factorial(int n) {
    int result = 1;
    for (int i = 2; i <= n; i++) {
      result *= i;
    }
    return result;
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
