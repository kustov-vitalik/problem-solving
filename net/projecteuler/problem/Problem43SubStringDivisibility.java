package net.projecteuler.problem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problem43SubStringDivisibility {

  public static void main(String[] args) {

    int[] nums = new int[] {0,1,2,3,4,5,6,7,8,9};

    Set<int[]> permutations = permutations(nums);

    long sum = 0;
    for (int[] permutation : permutations) {
      long num = digitsToNum(permutation);
      System.out.println(num);
      sum += num;
    }

    System.out.println("Result: " + sum);
  }

  static Set<int[]> permutations(int[] array) {
    Set<int[]> checkedPermutations = new HashSet<>();
    int k = array.length - 1;
    int n = k;

    if (checkNumber(array)) {
      checkedPermutations.add(Arrays.copyOf(array, array.length));
    }
    while (k > 0) {
      leftShift(array, k);
      if (array[k] != k) {
        if (checkNumber(array)) {
          checkedPermutations.add(Arrays.copyOf(array, array.length));
        }
        k = n;
      } else {
        k--;
      }
    }

    return checkedPermutations;
  }

  static boolean checkNumber(int[] number) {
    if (number[0] == 0) {
      return false;
    }

    if (numFromDigits(number, 1) % 2 != 0) {
      return false;
    }

    if (numFromDigits(number, 2) % 3 != 0) {
      return false;
    }

    if (numFromDigits(number, 3) % 5 != 0) {
      return false;
    }

    if (numFromDigits(number, 4) % 7 != 0) {
      return false;
    }

    if (numFromDigits(number, 5) % 11 != 0) {
      return false;
    }

    if (numFromDigits(number, 6) % 13 != 0) {
      return false;
    }

    if (numFromDigits(number, 7) % 17 != 0) {
      return false;
    }

    return true;

  }

  static long numFromDigits(int[] digits, int startPosition) {
    return digits[startPosition] * 100 + digits[startPosition+1] * 10 + digits[startPosition + 2];
  }

  static long digitsToNum(int[] digits) {
    long num = 0;
    for (int i = 0; i < digits.length; i++) {
      num += digits[i] * ((long)Math.pow(10, digits.length - i - 1));
    }
    return num;
  }

  private static void leftShift(int[] array, int k) {
    int temp = array[0];
    for (int i = 0; i < k; i++) {
      array[i] = array[i + 1];
    }
    array[k] = temp;
  }

  static void swap(int[] array, int a, int b) {
    int tmp = array[a];
    array[a] = array[b];
    array[b] = tmp;
  }

}
