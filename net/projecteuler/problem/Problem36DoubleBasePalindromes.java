package net.projecteuler.problem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem36DoubleBasePalindromes {

  public static void main(String[] args) {

    int result = 0;
    for (int i = 1; i < 1_000_000; i++) {
      if (isPalindrome(digits(i)) && isPalindrome(digitsBase2(i))) {
        result += i;
      }
    }

    System.out.println("Result: " + result);

  }

  static boolean isPalindrome(int[] digits) {
    for (int i = 0; i < digits.length/2; i++) {
      if (digits[i] != digits[digits.length - i - 1]) {
        return false;
      }
    }
    return true;
  }

  static int[] digits(int num) {
    List<Integer> digits = new ArrayList<>();

    do {
      digits.add(num % 10);
      num /= 10;
    } while (num > 0);

    int[] result = new int[digits.size()];
    for (int i = 0; i < result.length; i++) {
      result[i] = digits.get(i);
    }
    return result;
  }

  static int[] digitsBase2(int num) {

    List<Integer> digits = new ArrayList<>();

    do {
      digits.add(num % 2);
      num /= 2;
    } while (num > 0);

    int[] result = new int[digits.size()];
    for (int i = 0; i < result.length; i++) {
      result[i] = digits.get(result.length - i - 1);
    }
    return result;
  }

}
