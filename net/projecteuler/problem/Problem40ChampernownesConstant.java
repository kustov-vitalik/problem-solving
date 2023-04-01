package net.projecteuler.problem;

public class Problem40ChampernownesConstant {

  public static void main(String[] args) {

    StringBuilder builder = new StringBuilder();

    for (int i = 1; i < 1_000_000; i++) {
      builder.append(i);
    }

    var s = builder.toString();

    long res = 1;
    for (int j = 0; j <= 6; j++) {
      int position = (int) Math.pow(10, j);
      int nthNumber = getNthNumber(s, position);

      System.out.println(position + ": " + nthNumber);

      res *= nthNumber;
    }

    System.out.println("Answer: " + res);

  }

  static int getNthNumber(String s, int position) {
    return Integer.parseInt(Character.toString(s.charAt(position - 1)));
  }

}
