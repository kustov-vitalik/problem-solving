package net.projecteuler.problem;

import java.util.Arrays;

public class Problem7PrimeNumberSearch {

  static final Integer NUMBER_OF_PRIMES = 10_001;
//  static final Integer NUMBER_OF_PRIMES = 10;

  static int lastFound = 5;

  static int candidate = 15; // odd number!!!

  static int[] primes = new int[NUMBER_OF_PRIMES];
  static {
    primes[0] = 2;
    primes[1] = 3;
    primes[2] = 5;
    primes[3] = 7;
    primes[4] = 11;
    primes[5] = 13;
  }

  public static void main(String[] args) {
    fillPrimes();

    System.out.println(primes[NUMBER_OF_PRIMES - 1]);
  }

  private static void fillPrimes() {
    do {

      if (isPrime(candidate)) {
        primes[++lastFound] = candidate;
      }

      candidate += 2;

    } while (lastFound < primes.length - 1);

  }

  static boolean isPrime(int num) {

    int idx = 0;
    while (idx <= lastFound) {
      if (num % primes[idx] == 0) {
        return false;
      }
      idx++;
    }

    return true;
  }

}
