package com.leetcode.problem.linkedlist;

import com.leetcode.common.ListNode;

/**
 * <a href="https://leetcode.com/problems/middle-of-the-linked-list/">Problem description</a>
 */
public class Solved_Problem876MiddleOfTheLinkedList {

  public static void main(String[] args) {
    System.out.println(new Solution().middleNode(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))))));
    System.out.println(new Solution().middleNode(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6))))))));
    System.out.println(new Solution().middleNode(new ListNode(1)));
  }

  static class Solution {
    public ListNode middleNode(ListNode head) {
      ListNode fast = head;
      ListNode slow = head;

      while (fast != null && fast.next != null) {
        fast = fast.next.next;
        slow = slow.next;
      }

      return slow;
    }
  }
}
