package net.projecteuler.problem;

import net.projecteuler.problem.lib.Lib;

public class Problem58SpiralPrimes {

  public static void main(String[] args) {

    long sum = 1;
    long primeSum = 0;
    for (int i = 3; i <= 500_000; i += 2) {
      long diagCounter = 0;
      long primeDiagCounter = 0;
      int base = i * i;
      int side = i - 1;

      for (int j = 0; j < 4; j++) {
        int diagNum = base - j * side;
        if (Lib.isPrime(diagNum)) {
          primeDiagCounter ++;
        }
        diagCounter ++;
      }

      sum += diagCounter;
      primeSum += primeDiagCounter;
      double ratio = 1.0 * primeSum / sum;
      if (ratio < 0.1) {

        System.out.println("Result: " + i); // 26241
        break;
      }
    }



  }

}
