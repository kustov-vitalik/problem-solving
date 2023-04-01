package net.projecteuler.problem;

import java.util.Arrays;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicInteger;
import net.projecteuler.problem.lib.Lib;

public class Problem62CubicPermutations {

  public static void main(String[] args) {

    Map<Integer, Long> cubes = new TreeMap<>();

    for (int i = 1; i < 10_000; i++) {
      cubes.put(i, Lib.cube(i));
    }

    for (Entry<Integer, Long> entry : cubes.entrySet()) {
      Integer i = entry.getKey();
      Long cube = entry.getValue();
      AtomicInteger counter = new AtomicInteger();
      cubes.forEach((num, cubeVal) -> {
        if (cubeVal < cube) {
          return;
        }

        if (isPermutations(cube, cubeVal)) {
          counter.getAndIncrement();
        }
      });

      if (counter.get() == 5) {
        //Cube: 5027 :: 127035954683, counter: 5
        System.out.println("Cube: " + i + " :: " + cube + ", counter: " + counter);
        return;
      }
    }

  }

  static boolean isPermutations(long a, long b) {
    int[] digitsA = Lib.digits(a);
    int[] digitsB = Lib.digits(b);
    if (digitsA.length != digitsB.length) {
      return false;
    }
    Arrays.sort(digitsA);
    Arrays.sort(digitsB);

    for (int i = 0; i < digitsA.length; i++) {
      if (digitsA[i] != digitsB[i]) {
        return false;
      }
    }

    return true;

  }


}
