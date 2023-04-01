package net.projecteuler.problem;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Problem38PandigitalMultiples {

  public static void main(String[] args) {

    String candidate = "";
    Set<Integer> pandigitals = new TreeSet<>();

    for (int i = 1; i < 10_000; i++) {

      int maxN = 2;
      candidate = "";

      while (candidate.length() < 10) {

        candidate = "";
        for (int j = 1; j < maxN; j++) {
          candidate += String.valueOf(i * j);
        }

        maxN++;

        if (candidate.length() == 9 && !candidate.contains("0")) {
          int num = Integer.parseInt(candidate);

          if (isPandigital(num)) {
            pandigitals.add(num);
          }
        }
      }
    }

    int result = pandigitals.stream().mapToInt(n -> n).max().orElse(-1);

    System.out.println("Result: " + result); // 932718654

  }

  static boolean isPandigital(int num) {

    List<Integer> digits = digits(num);
    return digits.size() == 9 && new HashSet<>(digits).size() == 9;
  }

  static List<Integer> digits(int num) {
    List<Integer> digits = new ArrayList<>();

    do {
      digits.add(num % 10);
      num /= 10;
    } while (num > 0);

    return digits;
  }

}
