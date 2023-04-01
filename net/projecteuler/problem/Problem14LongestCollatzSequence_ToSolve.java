package net.projecteuler.problem;

import java.util.HashMap;
import java.util.Map;

public class Problem14LongestCollatzSequence_ToSolve {

  static Map<Integer, Integer> lenMap = new HashMap<>(1_000_000);
  static Map<Integer, Integer> tmp = new HashMap<>(1000);

  static {
    lenMap.put(1, 1);
    lenMap.put(2, 2);
  }

  public static void main(String[] args) {

    int maxLen = 0;
    for (int i = 3; i <= 1000_000; i++) {
      int len = getLen(i);

      lenMap.put(i, len);

      if (maxLen < len) {
        maxLen = len;
      }

      if (i % 1000 == 0) {
        System.out.println(i + ": " + len + ", max : " + maxLen);
      }
    }

    System.out.println("MaxLen: " + maxLen);
  }

  static int getLen(int number) {
    int counter = 0;

    if (!tmp.isEmpty()) {
      tmp.clear();
    }

    do {
      if (number % 2 == 0) {
        number /= 2;
      } else {
        number = 3 * number + 1;
      }
      counter++;

      if (lenMap.containsKey(number)) {
        var count = lenMap.get(number);

        for (var entry: tmp.entrySet()) {
          lenMap.put(entry.getKey(), counter - entry.getValue() + count);
        }

        return counter + count;
      } else {
        tmp.put(number, counter);
      }

    } while (number != 1);

    return counter + 1;
  }

}
