package net.projecteuler.problem;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problem41PandigitalPrime {

  public static void main(String[] args) {

    Integer maxPandigitalPrime = 0;
    for (int i = 1; i <= 987654321; i += 2) {
      if (isPrime(i) && isPandigital(i)) {
        System.out.println("pandigital: " + i);
        if (maxPandigitalPrime < i) {
          maxPandigitalPrime = i;
        }
      }
    }
    System.out.println("Result: " + maxPandigitalPrime); // 7652413

  }

  public static boolean isPrime(int num) {

    if (num < 0) {
      return false;
    }

    for (long i = 2; i * i <= num; i++) {
      if (num % i == 0) {
        return false;
      }
    }

    return true;
  }

  public static Set<Integer> getPrimes(int setSize) {

    Set<Integer> primes = new HashSet<>();
    BigInteger primeSearch = BigInteger.TWO;

    do {
      primes.add(primeSearch.intValue());
      primeSearch = primeSearch.nextProbablePrime();
    } while (primes.size() < setSize);

    return primes;
  }

  public static Set<Integer> getPrimesUntil(int max) {

    Set<Integer> primes = new HashSet<>();
    BigInteger primeSearch = BigInteger.TWO;

    do {
      primes.add(primeSearch.intValue());
      primeSearch = primeSearch.nextProbablePrime();
    } while (primeSearch.intValue() <= max);

    return primes;
  }

  public static boolean isPandigital(int number) {
    var digits = digits(number);

    if (digits.contains(0)) {
      return false;
    }

    var len = digits.size();

    for (int i = 1; i <= len; i++) {
      if (!digits.contains(i)) {
        return false;
      }
    }

    return true;
  }

  public static List<Integer> digits(int num) {
    List<Integer> digits = new ArrayList<>();

    do {
      digits.add(num % 10);
      num /= 10;
    } while (num > 0);

    return digits;
  }

}
