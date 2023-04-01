package net.projecteuler.problem;

public class Problem28NumberSpiralDiagonals {

  public static void main(String[] args) {
    long sum = 1;

    int size = 1001;

    for (int i = 3; i <= size; i+=2) {
      int base = i * i;
      int side = i - 1;
      sum += base + (base - side) + (base - 2 * side) + (base - 3 * side);
    }

    System.out.println("Result: " + sum);
  }

}
