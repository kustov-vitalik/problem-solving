package com.leetcode.problem.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentSkipListSet;

public class Problem2492MinimumScoreOfPathBetweenTwoCities {

  public static void main(String[] args) {
    System.out.println(new Problem2492MinimumScoreOfPathBetweenTwoCities().minScore(4, new int[][] {
        {1,2,9}, {2,3,6}, {2,4,5}, {1,4,7}
    })); // 5

    System.out.println(new Problem2492MinimumScoreOfPathBetweenTwoCities().minScore(4, new int[][] {
        {1,2,2}, {1,3,4}, {3,4,7}
    })); // 2
  }

  public int minScore(int n, int[][] roads) {

    if (n == 2) {
      return roads[n - 2][2];
    }

    int min = 100_000;

    int city;

    Queue<Integer> queue = new LinkedList<>();
    queue.add(1);

    Set<Integer> visitedCities = new HashSet<>();

    do {
      city = queue.poll();


      for (int i = 0; i < roads.length; i++) {
        if (roads[i][0] == city) {
          min = Math.min(min, roads[i][2]);

          if (!visitedCities.contains(roads[i][1])) {
            queue.add(roads[i][1]);
          }

        } else if (roads[i][1] == city) {
          min = Math.min(min, roads[i][2]);

          if (!visitedCities.contains(roads[i][0])) {
            queue.add(roads[i][0]);
          }

        }
      }

      visitedCities.add(city);

    } while (!queue.isEmpty());

    return min;

  }

  private int min(int[][] roads) {
    return Arrays.stream(roads).map(row -> row[2]).mapToInt(Integer::intValue).min().orElse(Integer.MAX_VALUE);
  }

}
