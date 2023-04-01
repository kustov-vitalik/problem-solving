package net.projecteuler.problem;

import java.util.ArrayList;
import java.util.List;

public class Problem64OddPeriodSquareRoots {

  public static void main(String[] args) {

    int oddPeriodsCounter = 0;
    for (int i = 1; i < 10_000; i++) {
      if (oddPeriod(i)) {
        oddPeriodsCounter++;
      }
    }

    System.out.println("Result: " + oddPeriodsCounter);


  }


  static boolean oddPeriod(int value) {
    double sqrt = Math.sqrt(value);

    List<Presentation> presentations = new ArrayList<>();
    int aCurrent = 0;
    int aNext = 0;
    int num = 0;
    int denominator = 0;

    int prevNum;

    for (int i = 0; i < 10_000; i++) {

      if (i == 0) {
        aCurrent = (int) sqrt;
        denominator = value - aCurrent*aCurrent;

        if (denominator == 0) {
          // non-irrational value
          return false;
        }

        for (int j = 0; j < 1000; j++) {
          if (((j * denominator) - aCurrent) > sqrt) {
            aNext = j - 1;
            break;
          } else {
            num = (j * denominator) - aCurrent;
          }
        }

      } else {
        aCurrent = aNext;
        denominator = (value - num*num)/denominator;
        prevNum = num;

        for (int j = 0; j < 1000; j++) {
          if (((j * denominator) - prevNum) > sqrt) {
            aNext = j - 1;
            break;
          } else {
            num = (j * denominator) - prevNum;
          }
        }
      }

      var presentation = new Presentation(aCurrent, aNext, num, denominator);
      if (presentations.contains(presentation)) {
        int period = presentations.size() - presentations.indexOf(presentation);
        return period % 2 != 0;
      } else {
        presentations.add(presentation);
      }
    }

    System.out.println(presentations);

    return true;
  }





  static class Presentation {
    int aCurrent;
    int aNext;
    int num;
    int denominator;

    public Presentation(int aCurrent, int aNext, int num, int denominator) {
      this.aCurrent = aCurrent;
      this.aNext = aNext;
      this.num = num;
      this.denominator = denominator;
    }

    @Override
    public String toString() {
      return "{a=" + aCurrent +", next=" + aNext +
          ", num=" + num +
          ", denominator=" + denominator +
          '}';
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (o == null || getClass() != o.getClass()) {
        return false;
      }

      Presentation that = (Presentation) o;

      if (aCurrent != that.aCurrent) {
        return false;
      }
      if (aNext != that.aNext) {
        return false;
      }
      if (num != that.num) {
        return false;
      }
      return denominator == that.denominator;
    }

    @Override
    public int hashCode() {
      int result = aCurrent;
      result = 31 * result + aNext;
      result = 31 * result + num;
      result = 31 * result + denominator;
      return result;
    }
  }

}
