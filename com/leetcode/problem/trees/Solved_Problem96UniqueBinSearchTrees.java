package com.leetcode.problem.trees;

import java.util.HashMap;
import java.util.Map;

public class Solved_Problem96UniqueBinSearchTrees {

  Map<Integer, Integer> cache = new HashMap<>();

  public static void main(String[] args) {

    System.out.println(new Solved_Problem96UniqueBinSearchTrees().numTrees(3)); // 5
    System.out.println(new Solved_Problem96UniqueBinSearchTrees().numTrees(1)); // 1
    System.out.println(new Solved_Problem96UniqueBinSearchTrees().numTrees(4)); // 14
    System.out.println(new Solved_Problem96UniqueBinSearchTrees().numTrees(5)); // 42
    System.out.println(new Solved_Problem96UniqueBinSearchTrees().numTrees(8)); // 1430
  }

  public int numTrees(int n) {

    if (cache.containsKey(n)) {
      return cache.get(n);
    }

    if (n <= 1) {
      cache.put(n, 1);
      return 1;
    }

    if (n == 2) {
      cache.put(n, 2);
      return 2;
    }

    int sum = 0;

    int limit = n / 2;

    if (n % 2 != 0) {
      limit++;
    }

    for (int i = 0; i < limit; i++) {
      int currentVal = numTrees(i) * numTrees(n - i - 1);
      if (i != n - i - 1) {
        currentVal *= 2;
      }
      sum += currentVal;
    }

    cache.put(n, sum);

    return sum;
  }

}
