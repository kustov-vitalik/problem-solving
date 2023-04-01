package net.projecteuler.problem;

public class Problem1MultipliesOf3And5 {

  public static void main(String[] args) {
    assert sumOfAllProblem1MultipliesOf3And5WhichLessThan(10) == 23;
    System.out.println(sumOfAllProblem1MultipliesOf3And5WhichLessThan(10));
    System.out.println(sumOfAllProblem1MultipliesOf3And5WhichLessThan(1000));
  }

  static long sumOfAllProblem1MultipliesOf3And5WhichLessThan(int number) {
    long sum = 0;
    for (int i = 0; i < number; i++) {
      if (i % 3 == 0 || i % 5 == 0) {
        sum += i;
      }
    }
    return sum;
  }

}
