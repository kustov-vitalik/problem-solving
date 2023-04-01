package net.projecteuler.problem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import net.projecteuler.problem.lib.Lib;

public class Problem51PrimeDigitReplacements {

  public static void main(String[] args) {
    Set<Integer> primes = new TreeSet<>(Lib.getPrimesTo(1000_000));
    List<Integer> primesForIteration = Lib.getPrimesTo(1000_000).stream()
        .filter(integer -> integer > 100_000)
        .collect(Collectors.toList());

    List<Integer> idSets = List.of(0, 1, 2, 3, 4);
    var replacementIdsToReplace = subsets(idSets);
    replacementIdsToReplace.remove(idSets);
    replacementIdsToReplace.remove(Collections.emptyList());


    Map<String, Integer> map = new HashMap<>();

    for (Integer prime : primesForIteration) {
      int[] digits = Lib.digits(prime);

        for (List<Integer> positions : replacementIdsToReplace) {
      for (int j = 0; j < 10; j++) {
          int counter = 0;
          int candidate = replaceDigitsTo(digits, j, positions);
          if (candidate != prime && primes.contains(candidate) && Lib.digits(candidate).length == digits.length) {
            if (prime == 120383) {
              System.out.println(
                  "Prime: " + prime + ", newNum: " + candidate + ", symbols: " + positions
                      + ", digit: " + j);
            }

            counter++;

            String key = prime + ":" + positions;
            if (map.containsKey(key)) {
              map.put(key, map.get(key) + counter);
            } else {
              map.put(key, counter);
            }
          }


        }
      }
    }

    List<String> results = new ArrayList<>();
    for(var entry: map.entrySet()) {
      if (entry.getValue() == 8) {
        results.add(entry.getKey() + "::" + entry.getValue());
      }
    }

    results.sort(Comparator.naturalOrder());

    System.out.println(results);

    /*

    Prime: 120383, newNum: 121313, symbols: [0, 2, 4], digit: 1 -> 121313 is the answer
    Prime: 120383, newNum: 222323, symbols: [0, 2, 4], digit: 2
    Prime: 120383, newNum: 323333, symbols: [0, 2, 4], digit: 3
    Prime: 120383, newNum: 424343, symbols: [0, 2, 4], digit: 4
    Prime: 120383, newNum: 525353, symbols: [0, 2, 4], digit: 5
    Prime: 120383, newNum: 626363, symbols: [0, 2, 4], digit: 6
    Prime: 120383, newNum: 828383, symbols: [0, 2, 4], digit: 8
    Prime: 120383, newNum: 929393, symbols: [0, 2, 4], digit: 9
     */

  }

  static int replaceDigitsTo(int[] digits, int replaceTo, List<Integer> positions) {
    int[] newNumDigits = Arrays.copyOf(digits, digits.length);
    for (Integer position : positions) {
      newNumDigits[position] = replaceTo;
    }
    return (int) Lib.digitsToNum(newNumDigits);
  }

  private static List<List<Integer>> subsets(List<Integer> set) {

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
