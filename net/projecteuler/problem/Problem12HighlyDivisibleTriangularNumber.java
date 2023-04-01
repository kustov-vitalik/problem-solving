package net.projecteuler.problem;

public class Problem12HighlyDivisibleTriangularNumber {

  public static void main(String[] args) {

    int sum = 49995000;
    for (int i = 10000; i < 100000; i++) {
      sum += i;

      int numberOfFactors = numberOfFactors(sum);
      System.out.println(i + " -- " + sum + ": " + numberOfFactors);
      if (numberOfFactors > 500) {
        // will output "Found: 12375 -- 76576500: 576"
        System.out.println("Found: " + i + " -- " + sum + ": " + numberOfFactors);
        return;
      }

    }


  }

  private static int numberOfFactors(int number) {

    int factorCount = 0;

    for (int i = 1; i <= number; i++) {
      if (number % i == 0) {
        factorCount++;
      }
    }

    return factorCount;

  }

}
