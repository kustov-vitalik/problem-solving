package com.leetcode.problem.binarysearcg;

public class Solved_Problem278FirstBadVersion {

  public static void main(String[] args) {
    System.out.println(new Solution(4).firstBadVersion(5)); // 4
  }

  static public class VersionControl {

    int badVersion;
    int callCount = 0;

    public VersionControl(int badVersion) {
      this.badVersion = badVersion;
    }

    boolean isBadVersion(int version) {
      callCount++;
      var res = version >= badVersion;
      System.out.println("call isBadVersion(" + version + ") -> " + res);
      return res;
    }
  }

  static public class Solution extends VersionControl {

    public Solution(int badVersion) {
      super(badVersion);
    }

    public int firstBadVersion(int n) {

      int left = 1;
      int right = n;

      while (left <= right) {
        int mid = (left + right) >>> 1;
        boolean isBadVersion = isBadVersion(mid);

        if (isBadVersion) {
          right = mid - 1;
        } else {
          left = mid + 1;
        }
      }

      if (isBadVersion(left)) {
        return left;
      } else {
        return left - 1;
      }
    }
  }

}
