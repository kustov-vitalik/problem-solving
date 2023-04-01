package net.projecteuler.problem;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class Problem39IntegerRightTriangles {

  public static void main(String[] args) {
    int maxPerimeter = 1000;
    int p = 0;
    Map<Integer, Integer> mapCount = new TreeMap<>();
    for (int i = 0; i < 1000; i++) {
      for (int j = 0; j < 1000; j++) {
        for (int k = 0; k < 1000; k++) {
          if (i + j + k <= maxPerimeter && i*i + j*j == k*k) {
            p = i + j + k;
            if (mapCount.containsKey(p)) {
              mapCount.put(p, mapCount.get(p) + 1);
            } else {
              mapCount.put(p, 1);
            }
          }
        }
      }
    }

    int result = 0;
    int maxTriangles = 0;

    for (Entry<Integer, Integer> entry : mapCount.entrySet()) {
      if (entry.getValue() > maxTriangles) {
        maxTriangles = entry.getValue();
        result = entry.getKey();
      }
    }

    System.out.println("Result: " + result);

  }

}
