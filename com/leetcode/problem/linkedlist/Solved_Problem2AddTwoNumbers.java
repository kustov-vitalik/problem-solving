package com.leetcode.problem.linkedlist;

import com.leetcode.common.ListNode;

public class Solved_Problem2AddTwoNumbers {

  public static void main(String[] args) {
    System.out.println(new Solved_Problem2AddTwoNumbers().addTwoNumbers(
        new ListNode(2, new ListNode(4, new ListNode(3))),
        new ListNode(5, new ListNode(6, new ListNode(4)))
    )); // 7->0->8

    System.out.println(new Solved_Problem2AddTwoNumbers().addTwoNumbers(
        new ListNode(0),
        new ListNode(0)
    )); // 0

    System.out.println(new Solved_Problem2AddTwoNumbers().addTwoNumbers(
        new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9)))),
        new ListNode(9, new ListNode(9))
    )); // 0
  }

  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

    ListNode result = new ListNode(0);
    ListNode ref = result;

    int carry = 0;
    while (l1 != null && l2 != null) {

      int val = l1.val + l2.val + carry;
      if (val > 9) {
        carry = 1;
      } else {
        carry = 0;
      }

      result.next = new ListNode(val % 10);
      result = result.next;

      l1 = l1.next;
      l2 = l2.next;
    }

    while (l1 != null) {

      int val = l1.val + carry;
      if (val > 9) {
        carry = 1;
      } else {
        carry = 0;
      }

      result.next = new ListNode(val % 10);

      result = result.next;
      l1 = l1.next;
    }

    while (l2 != null) {
      int val = l2.val + carry;
      if (val > 9) {
        carry = 1;
      } else {
        carry = 0;
      }

      result.next = new ListNode(val % 10);

      result = result.next;
      l2 = l2.next;
    }

    if (carry == 1) {
      result.next = new ListNode(1);
    }

    return ref.next;
  }

}
