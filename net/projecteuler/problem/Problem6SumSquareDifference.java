package net.projecteuler.problem;

import java.util.List;
import java.util.stream.Stream;

public class Problem6SumSquareDifference {

  public static void main(String[] args) {
    System.out.println(sumOfSquaresMinusSquareOfSum(10));
    System.out.println(sumOfSquaresMinusSquareOfSum(100));
  }

  static int sumOfSquaresMinusSquareOfSum(int num) {
    return squareOfSum(num) - sumOfSquares(num);
  }

  static int sumOfSquares(int num) {
    int sum = 0;
    for (int i = 1; i <= num; i++) {
      sum += i*i;
    }
    return sum;
  }

  static int squareOfSum(int num) {
    return (int) Math.pow((1 + num) * num/2, 2);
  }

}
