package net.projecteuler.problem;

import java.util.HashSet;
import java.util.Set;

public class Problem45TriangularPentagonalHexagonal {

  public static void main(String[] args) {

    Set<Long> hex = new HashSet<>();
    Set<Long> penta = new HashSet<>();
    Set<Long> triang = new HashSet<>();
    for (int i = 140; i < 1000_000; i++) {
      hex.add(hexagonal(i));
      penta.add(pentagonal(i));
      triang.add(triangular(i));
    }

    for (var h : hex) {
      if (penta.contains(h) && triang.contains(h)) {
        System.out.println("Wow: " + h); // 1533776805
      }
    }

  }

  static long triangular(int n) {
    return (long) n * (n + 1) / 2L;
  }

  static long pentagonal(int n) {
    return n * (3L * n - 1) / 2L;
  }

  static long hexagonal(int n) {
    return n * (2L * n - 1);
  }

}
