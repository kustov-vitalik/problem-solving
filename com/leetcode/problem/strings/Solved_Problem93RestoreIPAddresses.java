package com.leetcode.problem.strings;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solved_Problem93RestoreIPAddresses {

  public static void main(String[] args) {
    System.out.println(new Solution().restoreIpAddresses("0000")); // ["0.0.0.0"]
    System.out.println(new Solution().restoreIpAddresses("25525511135")); // ["255.255.11.135","255.255.111.35"]
    System.out.println(new Solution().restoreIpAddresses("101023")); // ["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
  }

  static class Solution {

    public List<String> restoreIpAddresses(String s) {
      if (s.length() < 4 || s.length() > 12) {
        return new ArrayList<>();
      }

      Set<String> addresses = new HashSet<>();

      String s1 = "", s2 = "", s3 = "", s4 = "";

      for (int i = 1; i <= 3; i++) {
        s1 = s.substring(0, i);
        if (isValidNum(s1)) {

          for (int j = 1; j <= 3; j++) {
            if (i + j >= s.length()) {
              break;
            }
            s2 = s.substring(i, i + j);
            if (isValidNum(s2)) {

              for (int k = 1; k <= 3; k++) {
                if (i + j + k >= s.length()) {
                  break;
                }
                s3 = s.substring(i + j, i + j + k);
                if (isValidNum(s3)) {
                  s4 = s.substring(i + j + k);
                  if (isValidNum(s4)) {

                    addresses.add(new StringBuilder()
                            .append(s1).append(".")
                            .append(s2).append(".")
                            .append(s3).append(".")
                            .append(s4).toString());

                  }
                }
              }
            }
          }
        }
      }

      return new ArrayList<>(addresses);
    }

    private boolean isValidNum(String s) {
      if (s.length() == 1) {
        return true;
      }

      if (s.charAt(0) == '0') {
        return false;
      }

      return Integer.parseInt(s) < 256;
    }
  }

}
