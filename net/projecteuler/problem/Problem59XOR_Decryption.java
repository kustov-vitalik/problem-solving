package net.projecteuler.problem;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Problem59XOR_Decryption {

  public static void main(String[] args) throws IOException {

    String data = Files.readString(Path.of("net/projecteuler/problem/p059_cipher.txt"));

    String[] numbersS = data.split(",");
    int[] numbers = new int[numbersS.length];

    for (int i = 0; i < numbersS.length; i++) {
      numbers[i] = Integer.parseInt(numbersS[i]);
    }

    int[] key = new int[]{'e', 'x', 'p'};

    int answer = 0;
    StringBuilder result = new StringBuilder();
    for (int l = 0; l < numbers.length; l++) {
      int code = numbers[l] ^ key[l % key.length];

      answer += code;
      result.append(Character.toString(code));
    }

    if (result.length() > 30) {
      System.out.println(result); // "An extract taken from the introduction of one of Euler..."
      System.out.println("Result: " + answer); // 129448
    }

  }

}
