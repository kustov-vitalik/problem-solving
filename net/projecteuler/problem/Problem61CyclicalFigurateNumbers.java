package net.projecteuler.problem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import net.projecteuler.problem.lib.Lib;

public class Problem61CyclicalFigurateNumbers {

  public static void main(String[] args) {

    solution();

//    System.out.println(isCyclic(new int[]{1234, 3456, 3457, 5734, 5612}));
//    System.out.println(isCyclic(new int[]{2640, 3010, 1540, 4030, 1024, 2415}));
//    System.out.println(isCyclic(new int[]{1281, 2512, 8128, 2882, 5625, 8256}));

  }

  static void solution() {

    Comparator<Integer> comparator = (o1, o2) -> {
      int sum1 = Arrays.stream(Lib.digits(o1)).sum();
      int sum2 = Arrays.stream(Lib.digits(o2)).sum();
      return Integer.compare(sum1, sum2);
    };

    List<Integer> octagonals = new ArrayList<>();
    List<Integer> heptagonals = new ArrayList<>();
    List<Integer> hexagonals = new ArrayList<>();
    List<Integer> pentagonals = new ArrayList<>();
    List<Integer> squares = new ArrayList<>();
    List<Integer> triangulars = new ArrayList<>();

    for (int i = 1; i < 150; i++) {
      int num = (int) Lib.octagonal(i);
      if (checkNum(num)) {
        octagonals.add(num);
      }

      num = (int) Lib.heptagonal(i);
      if (checkNum(num)) {
        heptagonals.add(num);
      }

      num = (int) Lib.hexagonal(i);
      if (checkNum(num)) {
        hexagonals.add(num);
      }

      num = (int) Lib.pentagonal(i);
      if (checkNum(num)) {
        pentagonals.add(num);
      }

      num = (int) Lib.square(i);
      if (checkNum(num)) {
        squares.add(num);
      }

      num = (int) Lib.triangular(i);
      if (checkNum(num)) {
        triangulars.add(num);
      }
    }

    Collections.sort(octagonals, comparator);
    Collections.sort(heptagonals, comparator);
    Collections.sort(hexagonals, comparator);
    Collections.sort(pentagonals, comparator);
    Collections.sort(squares, comparator);
    Collections.sort(triangulars, comparator);

    System.out.println(octagonals);
    System.out.println(heptagonals);
    System.out.println(hexagonals);
    System.out.println(pentagonals);
    System.out.println(squares);
    System.out.println(triangulars);


    int minValue = 10_000_000;

    int[] num = new int[6];

    for (Integer octagonal : octagonals) {
      System.out.println("orcta: " + octagonal);
      for (Integer heptagonal : heptagonals) {
//        System.out.println("  hepta: " + heptagonal);
        for (Integer hexagonal : hexagonals) {
//          System.out.println("    hexa: " + hexagonal);
          for (Integer pentagonal : pentagonals) {
            for (Integer square : squares) {
              for (Integer triangular : triangulars) {

                Set<Integer> set = new HashSet<>();
                set.add(octagonal);
                set.add(heptagonal);
                set.add(hexagonal);
                set.add(pentagonal);
                set.add(square);
                set.add(triangular);

                if (set.size() != 6) {
                  continue;
                }

                num[0] = octagonal;
                num[1] = heptagonal;
                num[2] = hexagonal;
                num[3] = pentagonal;
                num[4] = square;
                num[5] = triangular;

                if (isCyclic(num)) {
                  int sum = Arrays.stream(num).sum();
                  System.out.println("List: " + Arrays.toString(num) + ", Sum: " + sum);
                  if (sum < minValue) {
                    minValue = sum;

                    // List: [1281, 2512, 8128, 2882, 5625, 8256], Sum: 28684
                  }
                }
              }
            }
          }
        }
      }
    }

    System.out.println("Result: " + minValue);
  }

  static boolean checkNum(int num) {

    if (num < 1000 || num > 10000) {
      return false;
    }

    if (num % 100 == 0) {
      return false;
    }

    if (Lib.digits(num)[2] == 0) {
      return false;
    }

    return true;
  }

  public static boolean isCyclic(int[] nums) {
    List<List<Integer>> cycles = new ArrayList<>();
    findCycles(nums, 0, new ArrayList<>(), cycles);
    for (List<Integer> cycle : cycles) {
      if (cycle.size() == nums.length + 1 && cycle.get(0).equals(cycle.get(cycle.size() - 1))) {
        return true;
      }
    }

    return false;
  }

  static void findCycles(int[] nums, int idx, List<Integer> cycle, List<List<Integer>> cycles) {

    if (!cycle.isEmpty() && cycle.contains(idx)) {
      cycle.add(idx);
      cycles.add(cycle);
      return;
    }
    cycle.add(idx);
    for (int i = 0; i < nums.length; i++) {
      if (i == idx) {
        continue;
      }

      if (nums[i] / 100 == nums[idx] % 100) {
        findCycles(nums, i, new ArrayList<>(cycle), cycles);
      }
    }
  }

}
