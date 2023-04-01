package net.projecteuler.problem;

import java.util.Arrays;
import java.util.Collections;

public class Problem24LexicographicPermutations {

  static int counter = 0;

  public static void main(String[] args) {

    Integer[] digits = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
    Arrays.sort(digits);

    printAllOrdered(digits);

  }

  public static void printAllOrdered(Integer[] elements) {

    Arrays.sort(elements);
    boolean hasNext = true;

    while (hasNext) {
      printArray(elements);
      int k = 0, l = 0;
      hasNext = false;
      for (int i = elements.length - 1; i > 0; i--) {
        if (elements[i].compareTo(elements[i - 1]) > 0) {
          k = i - 1;
          hasNext = true;
          break;
        }
      }

      for (int i = elements.length - 1; i > k; i--) {
        if (elements[i].compareTo(elements[k]) > 0) {
          l = i;
          break;
        }
      }

      swap(elements, k, l);
      Collections.reverse(Arrays.asList(elements).subList(k + 1, elements.length));
    }
  }

  private static void swap(Integer[] input, int a, int b) {
    var tmp = input[a];
    input[a] = input[b];
    input[b] = tmp;
  }

  private static void printArray(Integer[] input) {

    if (counter == 999999) {

      System.out.println(Arrays.toString(input)); // [2, 7, 8, 3, 9, 1, 5, 4, 6, 0]
    }

    counter++;
  }

  static int fact(int num) {
    if (num == 1) {
      return 1;
    }

    return num * fact(num - 1);
  }

}
