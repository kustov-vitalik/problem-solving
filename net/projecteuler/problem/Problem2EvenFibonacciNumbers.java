package net.projecteuler.problem;

public class Problem2EvenFibonacciNumbers {

  static int[] cache = new int[100_000];

  static {
    cache[1] = 1;
    cache[2] = 2;
  }

  public static void main(String[] args) {

    int num = 2;
    int fib = fib(num);
    long sum = 0;
    do {
      System.out.print(fib + " ");
      if (fib % 2 == 0) {
        sum += fib;
      }

      num++;
      fib = fib(num);
    } while (fib < 4_000_000);

    System.out.println(sum);

  }

  static int fib(int idx) {

    int[] cache = new int[100_000];
    cache[1] = 1;
    cache[2] = 2;

    if (cache[idx] != 0) {
      return cache[idx];
    }

    for (int i = 3; i <= idx; i++) {
      cache[i] = cache[i - 1] + cache[i - 2];
    }

    return cache[idx];

  }

}
