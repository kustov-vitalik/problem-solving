package com.leetcode.problem.linkedlist;

import com.leetcode.common.ListNode;

public class Solved_Problem2095DeleteTheMiddleNodeOfLinkedList {


  public static void main(String[] args) {
    System.out.println(new Solved_Problem2095DeleteTheMiddleNodeOfLinkedList().deleteMiddle(
        new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))))))); // 1->2->[--3]->4->5
    System.out.println(new Solved_Problem2095DeleteTheMiddleNodeOfLinkedList().deleteMiddle(
        new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6)))))))); // 1->2->3->[--4]->5->6
    System.out.println(new Solved_Problem2095DeleteTheMiddleNodeOfLinkedList().deleteMiddle(
        new ListNode(2, new ListNode(1)))); // 2
    System.out.println(new Solved_Problem2095DeleteTheMiddleNodeOfLinkedList().deleteMiddle(
        new ListNode(2))); // 2

  }


  public ListNode deleteMiddle(ListNode head) {
    var orig = head;

    ListNode slow = head;
    ListNode fast = head;
    ListNode leftTail = null;

    while (fast != null && fast.next != null) {
      fast = fast.next.next;
      leftTail = slow;
      slow = slow.next;
    }

    if (leftTail == null) {
      return null;
    }
    leftTail.next = slow.next;

    return orig;
  }

}
