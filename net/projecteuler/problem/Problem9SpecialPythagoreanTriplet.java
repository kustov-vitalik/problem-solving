package net.projecteuler.problem;

public class Problem9SpecialPythagoreanTriplet {

  public static void main(String[] args) {

    System.out.println(product());

  }

  static int product() {
    for (int i = 3; i < 1000; i++) {
      for (int j = i + 1; j < 1000; j++) {
        for (int k = j + 1; k < 1000; k++) {
          if (i + j + k == 1000 && i*i + j*j == k*k) {
            return i*j*k;
          }
        }
      }
    }
    return -1;
  }

}
