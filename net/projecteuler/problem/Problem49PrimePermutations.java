package net.projecteuler.problem;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Problem49PrimePermutations {

  public static void main(String[] args) {

    List<Integer> primes = getPrimes(5000).stream()
        .filter(prime -> prime >= 1000 && prime < 10_000)
        .collect(Collectors.toList());

    for (Integer prime : primes) {
      for (Integer prime2 : primes) {
        if (prime2 > prime) {

          if (digits(prime).equals(digits(prime2))) {
            int candidate = prime2 + prime2 - prime;
            if (primes.contains(candidate) && digits(candidate).equals(digits(prime))) {

              // 1: 2969, 2: 6299, 3: 9629
              System.out.println("1: " + prime + ", 2: " + prime2 + ", 3: " + candidate);
            }
          }
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

  public static Set<Integer> digits(int num) {
    Set<Integer> digits = new HashSet<>();

    do {
      digits.add(num % 10);
      num /= 10;
    } while (num > 0);

    return digits;
  }

}
