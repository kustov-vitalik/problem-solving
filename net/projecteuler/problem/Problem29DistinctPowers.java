package net.projecteuler.problem;

import java.util.HashSet;
import java.util.Set;

public class Problem29DistinctPowers {

  public static void main(String[] args) {

    int limit = 100;

    Set<Double> numbers = new HashSet<>();

    for (int i = 2; i <= limit; i++) {
      for (int j = 2; j <= limit; j++) {

        double pow = Math.pow(i, j);
        numbers.add(pow);
        System.out.println(i + "^" + j + " = " + pow);

      }
    }

    System.out.println("Result: " + numbers.size());

  }

}
