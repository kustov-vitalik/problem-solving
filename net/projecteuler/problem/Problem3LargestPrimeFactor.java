package net.projecteuler.problem;

import java.util.ArrayList;
import java.util.List;

public class Problem3LargestPrimeFactor {

  public static void main(String[] args) {
    System.out.println(primeFactors(2));
    System.out.println(primeFactors(10));
    System.out.println(primeFactors(13195));
    System.out.println(primeFactors(600851475143L));
  }

  static List<Integer> primeFactors(long num) {
    List<Integer> primeFactors = new ArrayList<>();
    long border = num;
    for (int i = 2; i <= border; i++) {

      if (num % i == 0) {

        do {
          primeFactors.add(i);
          num /= i;
        } while (num % i == 0);

      }

      if (num < i) {
        break;
      }
    }


    return primeFactors;
  }

}
