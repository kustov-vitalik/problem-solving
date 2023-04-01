package net.projecteuler.problem;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problem35CircularPrimes {

  public static void main(String[] args) {
    Set<Integer> primes = new HashSet<>();
    var primeSearch = BigInteger.TWO;
    while (primeSearch.compareTo(BigInteger.valueOf(1000_000)) < 0) {
      primes.add(primeSearch.intValue());
      primeSearch = primeSearch.nextProbablePrime();
    }

    int circularCounter = 0;
    for (var prime : primes) {
      int[] digits = digits(prime);
      int[] rotations = rotations(digits);

      boolean circular = true;

      for (int rotation : rotations) {
        if (!primes.contains(rotation)) {
          circular = false;
          break;
        }
      }

      if (circular) {
        circularCounter++;
      }
    }

    System.out.println("Total circulars: " + circularCounter); //Total circulars: 55

  }

  static int[] digits(int num) {
    List<Integer> digits = new ArrayList<>();

    do {
      digits.add(num % 10);
      num /= 10;
    } while (num > 0);

    int[] result = new int[digits.size()];
    for (int i = 0; i < digits.size(); i++) {
      result[i] = digits.get(i);
    }
    return result;
  }

  static int[] rotations(int[] nums) {
    int[] rotations = new int[nums.length];

    for (int i = 0; i < nums.length; i++) {
      for (int j = 0; j < nums.length; j++) {
        rotations[i] += (nums[(j + i) % nums.length]) * Math.pow(10, j);
      }
    }

    return rotations;
  }

  static int fact(int n) {
    if (n < 1) {
      return 1;
    }

    return n * fact(n - 1);
  }

}
