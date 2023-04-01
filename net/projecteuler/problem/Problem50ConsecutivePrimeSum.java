package net.projecteuler.problem;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class Problem50ConsecutivePrimeSum {

  public static void main(String[] args) {

    // for iterating using ids
    List<Integer> primes = getPrimes(1_000_000);

    // for checking prime
    Set<Integer> primeSet = new HashSet<>(primes);

    // for storing max num of terms
    Map<Integer, Integer> lenMap = new TreeMap<>();

    for (int j = 0; j < 10_000; j++) {
      int sum = 0;
      int iteration = 0;
      for (int i = j; i < 10_000; i++) {
        sum += primes.get(i);
        iteration++;
        if (i == j) {
          continue;
        }
        if (primeSet.contains(sum)) {
          if (lenMap.containsKey(sum)) {
            Integer currentLen = lenMap.get(sum);
            if (currentLen < iteration) {
              lenMap.put(sum, iteration);
            }
          } else {
            lenMap.put(sum, iteration);
          }
        }
      }
    }

    int maxLen = 0;
    int neededPrime = 0;
    for (Entry<Integer, Integer> entry : lenMap.entrySet()) {
      if (entry.getValue() > maxLen) {
        maxLen = entry.getValue();
        neededPrime = entry.getKey();
      }
    }

    System.out.println("Result: " + neededPrime); // 997651

  }


  public static List<Integer> getPrimes(int max) {

    List<Integer> primes = new ArrayList<>();
    BigInteger primeSearch = BigInteger.TWO;

    do {
      primes.add(primeSearch.intValue());
      primeSearch = primeSearch.nextProbablePrime();
    } while (primeSearch.intValue() < max);

    return primes;
  }
}
