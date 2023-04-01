package net.projecteuler.problem;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

public class Problem4LargestPalindromeProduct {

  public static void main(String[] args) {
    System.out.println(isPalindrome(10231));
    System.out.println(isPalindrome(1001));

    int maxPalindrome = 0;
    for (int i = 100; i < 1000; i++) {
      for (int j = 100; j < 1000; j++) {
        int number = i * j;
        if (number > maxPalindrome && isPalindrome(number)) {
          maxPalindrome = number;
        }
      }
    }

    System.out.println(maxPalindrome);

  }

  static boolean isPalindrome(int number) {

    List<Integer> digits = new ArrayList<>();

    while (number > 0) {
      digits.add(number % 10);
      number /= 10;
    }

    for (int i = 0; i < digits.size() / 2; i++) {
      if (!digits.get(i).equals(digits.get(digits.size() - 1 - i))) {
        return false;
      }
    }

    return true;
  }

}
