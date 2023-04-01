package net.projecteuler.problem;

import java.util.ArrayList;
import java.util.List;

public class Problem26ReciprocalCycles {

  public static void main(String[] args) {

    int maxPeriod = 0, maxPeriodNumber = 0;
    for (int i = 2; i < 1000; i++) {
      Integer period = divide(1, i, 10000);
      if (maxPeriod < period) {
        maxPeriod = period;
        maxPeriodNumber = i;
      }
      System.out.println("1/" + i + " = " + period);
      System.out.println("");
    }

    System.out.println("Number: " + maxPeriodNumber + ", period: " + maxPeriod);

    // 33333... -> (3) -> 1
    // 23232... -> (23) -> 2
    // 123123.. -> (123) -> 3



  }

  static Integer divide(int a, int b, int maxLen) {
    List<Integer> digits = new ArrayList<>();

    int periodLen = -1;

    List<OpNode> ops = new ArrayList<>();
    do {

      OpNode node = new OpNode(a, b);
      if (ops.contains(node)) {
        // cycle
        periodLen = ops.size() - ops.indexOf(node);
        return periodLen;
      } else {
        ops.add(node);
      }

      a *= 10;
      digits.add(a / b);
      a %= b;
    } while (a != 0 && ops.size() < maxLen);

    return periodLen;
  }

  static class OpNode {
    Integer a;
    Integer b;

    public OpNode(Integer a, Integer b) {
      this.a = a;
      this.b = b;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (o == null || getClass() != o.getClass()) {
        return false;
      }

      OpNode opNode = (OpNode) o;

      if (a != null ? !a.equals(opNode.a) : opNode.a != null) {
        return false;
      }
      return b != null ? b.equals(opNode.b) : opNode.b == null;
    }

    @Override
    public int hashCode() {
      int result = a != null ? a.hashCode() : 0;
      result = 31 * result + (b != null ? b.hashCode() : 0);
      return result;
    }

    @Override
    public String toString() {
      return "OpNode{" +
          "a=" + a +
          ", b=" + b +
          '}';
    }
  }

}
