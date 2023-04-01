package net.projecteuler.problem;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

public class Problem21AmicableNumbers {

  public static void main(String[] args) {

    Map<Integer, Integer> map = new HashMap<>(10000);
    Set<Integer> amicableNumbers = new TreeSet<>();
    for (int i = 1; i < 10000; i++) {
      map.put(i, sumOfDivisors(i));
    }

    for (var entry: map.entrySet()) {
      for (var entry2: map.entrySet()) {
        if (Objects.equals(entry.getKey(), entry2.getValue())
            && Objects.equals(entry.getValue(), entry2.getKey())
            && !Objects.equals(entry.getKey(), entry2.getKey())
        ) {
          amicableNumbers.add(entry.getKey());
          amicableNumbers.add(entry.getValue());
        }
      }
    }


    System.out.println(amicableNumbers);

    int sum = amicableNumbers.stream().mapToInt(i -> i).sum();
    System.out.println("Result: " + sum);
  }

  static boolean isAmicableNumbers(int a, int b) {
    return a != b && sumOfDivisors(a) == sumOfDivisors(b);
  }

  static int sumOfDivisors(int num) {
    int sum = 0;
    for (int i = 1; i < num; i++) {
      if (num % i == 0) {
        sum += i;
      }
    }
    return sum;
  }
}
