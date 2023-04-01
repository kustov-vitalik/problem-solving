package com.leetcode.problem.linkedlist;

import com.leetcode.common.ListNode;

public class Solved_Problem148SortList {

  public static void main(String[] args) {

    System.out.println(new Solved_Problem148SortList().sortList(new ListNode(4, new ListNode(3, new ListNode(2, new ListNode(1))))));
    System.out.println(new Solved_Problem148SortList().sortList(new ListNode(1, new ListNode(1))));
    System.out.println(new Solved_Problem148SortList().sortList(new ListNode(1)));
    System.out.println(new Solved_Problem148SortList().sortList(new ListNode(2, new ListNode(1))));

  }

  public ListNode sortList(ListNode head) {
    if (head == null) {
      return null;
    }

    if (head.next == null) {
      return head;
    }

    if (head.next.next == null) {
      if (head.val <= head.next.val) {
        return head;
      } else {
        ListNode next = head.next;
        head.next = null;
        next.next = head;
        return next;
      }
    }

    ListNode[] partitions = getPartitions(head);

    return merge(sortList(partitions[0]), sortList(partitions[1]));

  }

  private ListNode merge(ListNode leftPartition, ListNode rightPartition) {

    ListNode head = new ListNode();
    ListNode ref = head;

    while (leftPartition != null && rightPartition != null) {

      if (leftPartition.val <= rightPartition.val) {
        head.next = leftPartition;
        leftPartition = leftPartition.next;
      } else {
        head.next = rightPartition;
        rightPartition = rightPartition.next;
      }

      head = head.next;
    }

    while (leftPartition != null) {
      head.next = leftPartition;
      leftPartition = leftPartition.next;
      head = head.next;
    }

    while (rightPartition != null) {
      head.next = rightPartition;
      rightPartition = rightPartition.next;
      head = head.next;
    }

    return ref.next;
  }

  private ListNode[] getPartitions(ListNode head) {

    ListNode ref = head;
    ListNode fast = head;
    ListNode slow = head;
    ListNode slowPrev = null;

    while (fast != null && fast.next != null) {
      fast = fast.next.next;
      slowPrev = slow;
      slow = slow.next;
    }

    if (slowPrev != null) {
      slowPrev.next = null;
    }

    return new ListNode[] {ref, slow};
  }

}
