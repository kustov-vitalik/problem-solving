package net.projecteuler.problem;

public class Problem27QuadraticPrimes {

  public static void main(String[] args) {

    long product = 0;
    int maxNumOfPrimes = 0;
    int numOfPrimes;

    long aRange = 999, bRange = 1000;

    for (long i = -aRange; i <= aRange; i++) {
      for (long j = -bRange; j <= bRange; j++) {

        numOfPrimes = 0;
        while (isPrime(f(i, j, numOfPrimes))) {
          numOfPrimes++;
        }

        if (maxNumOfPrimes < numOfPrimes) {
          maxNumOfPrimes = numOfPrimes;
          product = i*j;
          System.out.println("a=" + i + ", b=" + j + ", primes=" + numOfPrimes + ", product=" + product);
        }
      }
    }

    System.out.println("Primes count: " + maxNumOfPrimes);
    System.out.println("Result: " + product);

  }

  static long f(long a, long b, long x) {
    return x*x + a*x + b;
  }


  static boolean isPrime(long num) {

    if (num < 0) {
      return false;
    }

    for (long i = 2; i * i <= num; i++) {
      if (num % i == 0) {
        return false;
      }
    }

    return true;
  }

}
