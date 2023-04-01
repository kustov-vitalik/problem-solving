package net.projecteuler.problem;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import net.projecteuler.problem.lib.Lib;

public class Problem60PrimePairSets {

  public static void main(String[] args) {
    Set<Integer> primes = new TreeSet<>(Lib.getPrimes(2_000));

    for (Integer prime1 : primes) {
      for (Integer prime2 : primes) {
        if (prime2 <= prime1) {
          continue;
        }

        if (Lib.isPrime(mergeNums(prime1.longValue(), prime2.longValue())) && Lib.isPrime(mergeNums(prime2.longValue(), prime1.longValue()))) {
          for (Integer prime3 : primes) {
            if (prime3 <= prime2) {
              continue;
            }

            if (Lib.isPrime(mergeNums(prime1.longValue(), prime3.longValue())) && Lib.isPrime(mergeNums(prime3.longValue(), prime1.longValue()))) {
              if (Lib.isPrime(mergeNums(prime2.longValue(), prime3.longValue())) && Lib.isPrime(mergeNums(prime3.longValue(), prime2.longValue()))) {

                for (Integer prime4 : primes) {
                  if (prime4 < prime3) {
                    continue;
                  }

                  if (Lib.isPrime(mergeNums(prime1.longValue(), prime4.longValue())) && Lib.isPrime(mergeNums(prime4.longValue(), prime1.longValue()))) {
                    if (Lib.isPrime(mergeNums(prime2.longValue(), prime4.longValue())) && Lib.isPrime(mergeNums(prime4.longValue(), prime2.longValue()))) {
                      if (Lib.isPrime(mergeNums(prime4.longValue(), prime3.longValue())) && Lib.isPrime(mergeNums(prime3.longValue(), prime4.longValue()))) {

                        for (Integer prime5 : primes) {
                          if (prime5 < prime4) {
                            continue;
                          }

                          if (Lib.isPrime(mergeNums(prime1.longValue(), prime5.longValue())) && Lib.isPrime(mergeNums(prime5.longValue(), prime1.longValue()))) {
                            if (Lib.isPrime(mergeNums(prime2.longValue(), prime5.longValue())) && Lib.isPrime(mergeNums(prime5.longValue(), prime2.longValue()))) {
                              if (Lib.isPrime(mergeNums(prime3.longValue(), prime5.longValue())) && Lib.isPrime(mergeNums(prime5.longValue(), prime3.longValue()))) {
                                if (Lib.isPrime(mergeNums(prime4.longValue(), prime5.longValue())) && Lib.isPrime(mergeNums(prime5.longValue(), prime4.longValue()))) {
                                  System.out.println(List.of(prime1, prime2, prime3, prime4, prime5));
                                  System.out.println(prime1 + prime2 + prime3 + prime4 + prime5);

                                  /**
                                   * [13, 5197, 5701, 6733, 8389]
                                   * 26033
                                   */

                                }
                              }
                            }
                          }

                        }


                      }
                    }
                  }
                }


              }
            }
          }
        }
      }
    }
  }

  static long mergeNums(Long n1, Long n2) {
    return Long.parseLong(n1.toString() + n2.toString());
  }

}
