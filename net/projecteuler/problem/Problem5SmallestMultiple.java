package net.projecteuler.problem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Problem5SmallestMultiple {

  public static void main(String[] args) {

    System.out.println(smallestMultiple(10));
    System.out.println(smallestMultiple(20));


  }

  static int smallestMultiple(int maxFactor) {

    final int[] smallest = {1};

    Map<Integer, Integer> smallestFactors = new HashMap<>();

    for (int i = 2; i < maxFactor; i++) {

      Map<Integer, Integer> primeFactors = primeFactors(primeFactors(i));
      primeFactors.forEach((num, count) -> {
        if (smallestFactors.containsKey(num)) {
          if (smallestFactors.get(num) < count) {
            smallestFactors.put(num, count);
          }
        } else {
          smallestFactors.put(num, count);
        }
      });
    }

    smallestFactors.forEach((num, power) -> smallest[0] *= Math.pow(num, power));

    return smallest[0];

  }

  static List<Integer> primeFactors(long num) {
    List<Integer> primeFactors = new ArrayList<>();
    long border = num;
    for (int i = 2; i <= border; i++) {

      if (num % i == 0) {

        do {
          primeFactors.add(i);
          num /= i;
        } while (num % i == 0);

      }

      if (num < i) {
        break;
      }
    }


    return primeFactors;
  }

  static Map<Integer, Integer> primeFactors(List<Integer> primeFactors) {
    Map<Integer, Integer> smallestFactors = new HashMap<>();
    for (var el: primeFactors) {
      if (smallestFactors.containsKey(el)) {
        smallestFactors.put(el, smallestFactors.get(el) + 1);
      } else {
        smallestFactors.put(el, 1);
      }
    }

    return smallestFactors;
  }

}
