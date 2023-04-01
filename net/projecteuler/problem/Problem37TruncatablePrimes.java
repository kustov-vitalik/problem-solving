package net.projecteuler.problem;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Problem37TruncatablePrimes {

  public static void main(String[] args) {
    Set<Integer> primes = getPrimes();

    int counter = 0;
    int sum = 0;

    for (Integer prime : primes) {
      if (prime < 8) {
        continue;
      }

      if (isTruncatable(prime, primes)) {
        counter++;
        sum += prime;
        System.out.println("Truncatable: " + prime);

        if (counter == 11) {
          break;
        }
      }
    }


    System.out.println("Result: " + sum + ", count of nums: " + counter); // Result: 748317, count of nums: 11

  }

  private static boolean isTruncatable(Integer prime, Set<Integer> primes) {

    int[] digits = digits(prime);

    for (int i = 1; i < digits.length; i++) {
      int[] copy = Arrays.copyOf(digits, i);
      if (!primes.contains(numFromDigits(copy))) {
        return false;
      }
    }

    swap(digits);
    for (int i = 1; i < digits.length; i++) {
      int[] copy = Arrays.copyOf(digits, i);
      swap(copy);
      if (!primes.contains(numFromDigits(copy))) {
        return false;
      }
    }

    return true;
  }

  static void swap(int[] digits) {
    for (int i = 0; i < digits.length / 2; i++) {
      int tmp = digits[i];
      digits[i] = digits[digits.length - 1 - i];
      digits[digits.length - 1 - i] = tmp;
    }
  }

  static int numFromDigits(int[] digits) {
    int num = 0;
    for (int i = 0; i < digits.length; i++) {
      num += ( digits[digits.length - i - 1] * Math.pow(10, i) );
    }
    return num;
  }

  static int[] digits(int num) {
    List<Integer> digits = new ArrayList<>();

    do {
      digits.add(num % 10);
      num /= 10;
    } while (num > 0);

    int[] result = new int[digits.size()];
    for (int i = 0; i < result.length; i++) {
      result[i] = digits.get(result.length - i - 1);
    }
    return result;
  }

  static Set<Integer> getPrimes() {
    Set<Integer> primes = new TreeSet<>();
    var primeSearch = BigInteger.TWO;
    while (primeSearch.compareTo(BigInteger.valueOf(10_000_000)) < 0) {
      primes.add(primeSearch.intValue());
      primeSearch = primeSearch.nextProbablePrime();
    }
    return primes;
  }
}
