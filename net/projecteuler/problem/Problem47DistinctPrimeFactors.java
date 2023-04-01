package net.projecteuler.problem;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Problem47DistinctPrimeFactors {

  public static void main(String[] args) {
    List<Integer> primes = getPrimes(100_000);

    Map<Integer, Integer> mapFactorsCount = new HashMap<>();
    for (int i = 2; i < 1000_000; i++) {
      int factorsCount = primeFactorsCount(i, primes);
      if (factorsCount == 4) {
        mapFactorsCount.put(i, factorsCount);
        if (mapFactorsCount.containsKey(i - 1) && mapFactorsCount.containsKey(i - 2) && mapFactorsCount.containsKey(i - 3)) {
          System.out.println("Result: " + (i - 3));
          return;
        }
      }
    }
  }

  public static List<Integer> getPrimes(int setSize) {

    List<Integer> primes = new ArrayList<>(setSize);
    BigInteger primeSearch = BigInteger.TWO;

    do {
      primes.add(primeSearch.intValue());
      primeSearch = primeSearch.nextProbablePrime();
    } while (primes.size() < setSize);

    return primes;
  }

  public static int primeFactorsCount(int num, List<Integer> primes) {

    Set<Integer> factors = new HashSet<>();
    for (Integer prime : primes) {
      while (num % prime == 0) {
        factors.add(prime);
        num /= prime;
      }
    }

    return factors.size();

  }

}
