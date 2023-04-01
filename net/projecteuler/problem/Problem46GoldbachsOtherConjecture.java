package net.projecteuler.problem;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Problem46GoldbachsOtherConjecture {

  public static void main(String[] args) {
    solution();
  }

  static void solution() {

    Set<Integer> doubleSquares = new TreeSet<>();
    for (int i = 1; i < 10_000; i++) {
      doubleSquares.add(2 * i * i);
    }

    Set<Integer> primes = getPrimes(100_000);

    int num = 9;
    boolean lookup = true;
    while (lookup) {
      if (isCompositeNumber(num)) {

        if (!maybeSum(num, primes, doubleSquares)) {
          System.out.println("Result: " + num); // 5777
          lookup = false;
        }

      }
      num += 2;
    }




  }

  private static boolean maybeSum(int num, Set<Integer> primes, Set<Integer> doubleSquares) {

    for (Integer prime : primes) {
      for (Integer doubleSquare : doubleSquares) {
        if (prime + doubleSquare == num) {
          return true;
        }
      }
    }

    return false;
  }

  static boolean isCompositeNumber(int n) {

    for (int i = 2; i * i < n; i++) {
      if (n % i == 0) {
        return true;
      }
    }
    return false;
  }

  public static Set<Integer> getPrimes(int setSize) {

    Set<Integer> primes = new TreeSet<>();
    BigInteger primeSearch = BigInteger.TWO;

    do {
      primes.add(primeSearch.intValue());
      primeSearch = primeSearch.nextProbablePrime();
    } while (primes.size() < setSize);

    return primes;
  }

}
