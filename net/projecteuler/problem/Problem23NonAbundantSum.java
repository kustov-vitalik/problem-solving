package net.projecteuler.problem;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Problem23NonAbundantSum {

  public static void main(String[] args) {
    int limit = 28123;

    Set<Integer> abundantNumbers = new TreeSet<>();

    for (int i = 1; i < limit; i++) {
      if (isAbundant(i)) {
        abundantNumbers.add(i);
      }
    }

    Set<Integer> allNums = new HashSet<>();

    for (var n: abundantNumbers) {
      for (var p: abundantNumbers) {
        allNums.add(n+p);
      }
    }

    long sum = 0;
    for (int i = 1; i <= limit; i++) {
      if (!allNums.contains(i)) {
        sum += i;
      }
    }

    System.out.println("Result: " + sum); //Result: 4179871
  }

  static boolean isAbundant(int num) {
    int sum = 0;
    for (int i = 1; i <= num / 2; i++) {
      if (num % i == 0) {
        sum += i;
      }
    }
    return sum > num;
  }

}
