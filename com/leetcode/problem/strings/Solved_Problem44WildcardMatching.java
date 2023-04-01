package com.leetcode.problem.strings;

import java.util.Arrays;

public class Solved_Problem44WildcardMatching {

  // beats 14%
  public static void main(String[] args) {
    Solved_Problem44WildcardMatching matching = new Solved_Problem44WildcardMatching();
//    System.out.println(matching.isMatch("aa", "a"));// false
//    System.out.println(matching.isMatch("aa", "*"));// true
//    System.out.println(matching.isMatch("cb", "?a"));// false
//    System.out.println(matching.isMatch("ca", "?a"));// true
//    System.out.println(matching.isMatch("cra", "*a"));// true
//    System.out.println(matching.isMatch("cab", "*a"));// false
//    System.out.println(matching.isMatch("abceb", "*a*b"));// true
    System.out.println(matching.isMatch("mississippi", "m??*ss*?i*pi"));// false
//    System.out.println(matching.isMatch("", "*****"));// true
//    System.out.println(matching.isMatch("abc", "***a**b*****c"));// true
//    System.out.println(matching.isMatch("b", "?*?"));// false
    System.out.println(matching.isMatch("abcd", "*?*?*?*?"));// true
  }

  public boolean isMatch(String s, String p) {

    if (s.length() == 0) {
      return p.length() == 0 || p.replaceAll("\\*", "").length() == 0;
    }

    if (p.length() == 0) {
      return false;
    }

    for (int i = 0; i < p.length(); i++) {
      p = p.replaceAll("\\*\\*", "*");
    }

    if (!p.contains("*") && !p.contains("?")) {
      return p.equals(s);
    }

    if (!p.contains("*") && p.contains("?")) {
      if (p.length() != s.length()) {
        return false;
      }

      int m = 0;
      while (m < s.length()) {
        if (s.charAt(m) != p.charAt(m) && p.charAt(m) != '?') {
          return false;
        }
        m++;
      }

      return true;
    }

    if ("*".equals(p)) {
      return true;
    }

    int left = p.indexOf("*");
    String prefix = p.substring(0, left);
    if (s.length() < prefix.length()) {
      return false;
    }

    String substring = s.substring(0, prefix.length());
    if (prefix.length() != 0 && !isMatch(substring, prefix)) {
      return false;
    }

    p = p.substring(prefix.length());
    s = s.substring(prefix.length());

    int right = p.lastIndexOf("*");
    String suffix = p.substring(right + 1);

    if (s.length() < suffix.length()) {
      return false;
    }

    substring = s.substring(s.length() - suffix.length());
    if (suffix.length() != 0 && !isMatch(substring, suffix)) {
      return false;
    }

    p = p.substring(0, p.length() - suffix.length());
    s = s.substring(0, s.length() - suffix.length());

    if ("*".equals(p)) {
      return true;
    }

    String[] patterns = p.split("\\*");

    int searchFrom = 0;
    String substring1 = null;
    for (int i = 1; i < patterns.length; i++) {
      String pattern = patterns[i];

      int len = pattern.length();

      int idx = -1;
      for (int j = searchFrom; j <= s.length() - len; j++) {
        substring1 = s.substring(j, j + len);
        if (isMatch(substring1, pattern)) {
          idx = j;
          break;
        }
      }

      if (idx == -1) {
        return false;
      } else {
        searchFrom = idx + pattern.length();
      }
    }

    return true;
  }


}
