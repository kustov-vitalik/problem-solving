package net.projecteuler.problem;

public class Problem31CoinSums {

  public static void main(String[] args) {
    bruteForce();
  }

  static void bruteForce() {
    int counter = 0;

    for (int i = 0; i < 2; i++) {
      for (int j = 0; j < 3; j++) {
        for (int k = 0; k < 5; k++) {
          for (int l = 0; l < 11; l++) {
            for (int m = 0; m < 21; m++) {
              for (int n = 0; n < 41; n++) {
                for (int o = 0; o < 101; o++) {
                  for (int p = 0; p < 201; p++) {
                    if (i * 200 + j * 100 + k * 50 + l * 20 + m * 10 + n * 5 + o * 2 + p == 200) {
                      counter++;
                    }
                  }
                }
              }
            }
          }
        }
      }
    }

    System.out.println("Result: " + counter);
  }

}
