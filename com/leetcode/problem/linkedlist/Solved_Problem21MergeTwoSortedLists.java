package com.leetcode.problem.linkedlist;

import com.leetcode.common.ListNode;

public class Solved_Problem21MergeTwoSortedLists {

  public static void main(String[] args) {

    System.out.println(new Solved_Problem21MergeTwoSortedLists().mergeTwoLists(
        new ListNode(1, new ListNode(2, new ListNode(4))),
        new ListNode(1, new ListNode(3, new ListNode(4)))
    ));

  }

  public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
    ListNode head = new ListNode();
    ListNode ref = head;

    while (list1 != null && list2 != null) {

      if (list1.val <= list2.val) {
        head.next = list1;
        list1 = list1.next;
      } else {
        head.next = list2;
        list2 = list2.next;
      }

      head = head.next;
    }

    while (list1 != null) {
      head.next = list1;
      list1 = list1.next;
      head = head.next;
    }

    while (list2 != null) {
      head.next = list2;
      list2 = list2.next;
      head = head.next;
    }

    return ref.next;
  }



}
