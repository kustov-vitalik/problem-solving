package net.projecteuler.problem.lib;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Lib {

  public static List<Integer> getPrimes(int setSize) {

    List<Integer> primes = new ArrayList<>(setSize);
    BigInteger primeSearch = BigInteger.TWO;
    do {
      primes.add(primeSearch.intValue());
      primeSearch = primeSearch.nextProbablePrime();
    } while (primes.size() < setSize);

    return primes;
  }

  public static List<Integer> getPrimesTo(int maxNum) {

    List<Integer> primes = new ArrayList<>();
    BigInteger primeSearch = BigInteger.TWO;
    do {
      primes.add(primeSearch.intValue());
      primeSearch = primeSearch.nextProbablePrime();
    } while (primeSearch.intValue() < maxNum);

    return primes;
  }

  public static long digitsToNum(int[] digits) {
    long num = 0;
    for (int i = 0; i < digits.length; i++) {
      num += digits[i] * ((long) Math.pow(10, digits.length - i - 1));
    }
    return num;
  }

  public static BigInteger digitsToBigNum(int[] digits) {
    BigInteger num = BigInteger.ZERO;
    for (int i = 0; i < digits.length; i++) {
      num = num.add(
          BigInteger.TEN.pow(digits.length - i - 1).multiply(BigInteger.valueOf(digits[i])));
    }
    return num;
  }

  public static boolean isCompositeNumber(int n) {
    for (int i = 2; i * i < n; i++) {
      if (n % i == 0) {
        return true;
      }
    }
    return false;
  }

  public static int[] digits(long num) {
    String[] digitStr = String.valueOf(num).split("");
    int[] result = new int[digitStr.length];
    for (int i = 0; i < result.length; i++) {
      result[i] = Integer.parseInt(digitStr[i]);
    }
    return result;
  }

  public static int[] digits(String num) {
    List<Integer> digits = new ArrayList<>();

    for (int i = 0; i < num.length(); i++) {
      digits.add(Integer.parseInt(num, i, i + 1, 10));
    }

    int[] result = new int[digits.size()];
    for (int i = 0; i < result.length; i++) {
      result[i] = digits.get(result.length - i - 1);
    }
    return result;
  }

  public static void swap(int[] array, int a, int b) {
    int tmp = array[a];
    array[a] = array[b];
    array[b] = tmp;
  }

  public static void swap(int[] array) {
    for (int i = 0; i < array.length / 2; i++) {
      swap(array, i, array.length - 1 - i);
    }
  }

  public static int[] digitsBase2(int num) {

    List<Integer> digits = new ArrayList<>();

    do {
      digits.add(num % 2);
      num /= 2;
    } while (num > 0);

    int[] result = new int[digits.size()];
    for (int i = 0; i < result.length; i++) {
      result[i] = digits.get(result.length - i - 1);
    }
    return result;
  }

  public static int factorial(int n) {
    if (n < 1) {
      return 1;
    }

    return n * factorial(n - 1);
  }

  static int fibonacci(int idx) {

    int[] cache = new int[idx];
    if (idx > 0) {
      cache[1] = 1;
    }

    if (idx > 1) {
      cache[2] = 2;
    }

    if (cache[idx] != 0) {
      return cache[idx];
    }

    for (int i = 3; i <= idx; i++) {
      cache[i] = cache[i - 1] + cache[i - 2];
    }

    return cache[idx];

  }

  public static boolean isPalindrome(long number) {

    List<Integer> digits = new ArrayList<>();

    while (number > 0) {
      digits.add((int) (number % 10));
      number /= 10;
    }

    for (int i = 0; i < digits.size() / 2; i++) {
      if (!digits.get(i).equals(digits.get(digits.size() - 1 - i))) {
        return false;
      }
    }

    return true;
  }

  public static boolean isPalindrome(String number) {

    for (int i = 0; i < number.length() / 2; i++) {
      if (number.charAt(i) != number.charAt(number.length() - 1 - i)) {
        return false;
      }
    }

    return true;
  }

  public static BigInteger factorial(BigInteger num) {

    if (num.compareTo(BigInteger.ONE) == 0) {
      return BigInteger.ONE;
    }

    if (num.compareTo(BigInteger.TWO) == 0) {
      return BigInteger.TWO;
    }

    return num.multiply(factorial(num.subtract(BigInteger.ONE)));
  }

  public static boolean isPrime(long num) {

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


  public static long triangular(int n) {
    return (long) n * (n + 1) / 2L;
  }

  public static long square(int n) {
    return (long) n * n;
  }

  public static long pentagonal(int n) {
    return n * (3L * n - 1) / 2L;
  }

  public static long hexagonal(int n) {
    return n * (2L * n - 1);
  }

  public static long heptagonal(int n) {
    return n * (5L * n - 3L) / 2;
  }

  public static long octagonal(int n) {
    return n * (3L * n - 2L);
  }

  public static long cube(long n) {
    return n * n * n;
  }

  public static List<List<Integer>> subsets(List<Integer> set) {

    List<List<Integer>> allsubsets = new ArrayList<>();
    int max = 1 << set.size(); //there are 2 power n different subsets

    for (int i = 0; i < max; i++) {
      ArrayList<Integer> subset = new ArrayList<>();
      for (int j = 0; j < set.size(); j++) {
        if (((i >> j) & 1) == 1) {
          subset.add(set.get(j));
        }
      }
      allsubsets.add(subset);
    }
    return allsubsets;
  }
}
