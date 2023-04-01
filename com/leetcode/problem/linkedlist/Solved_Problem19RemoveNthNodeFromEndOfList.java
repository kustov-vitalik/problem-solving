package com.leetcode.problem.linkedlist;

import com.leetcode.common.ListNode;

public class Solved_Problem19RemoveNthNodeFromEndOfList {

  public static void main(String[] args) {

    ListNode head = new ListNode(1,
        new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));

    System.out.println(new Solved_Problem19RemoveNthNodeFromEndOfList().removeNthFromEnd(
        head,
        2
    )); // 1->2->3->5

    System.out.println(new Solved_Problem19RemoveNthNodeFromEndOfList().removeNthFromEnd(
        new ListNode(1), 1
    )); // null

    System.out.println(new Solved_Problem19RemoveNthNodeFromEndOfList().removeNthFromEnd(
        new ListNode(1, new ListNode(2)), 1
    )); // 1



  }

  public ListNode removeNthFromEnd(ListNode head, int n) {

    head = reverse(head);
    head = removeNthFromBegin(head, n);
    head = reverse(head);

    return head;
  }

  private ListNode removeNthFromBegin(ListNode head, int n) {
    ListNode ref = new ListNode(0, head);
    ListNode iterate = ref;
    ListNode prev = null;

    int counter = 0;

    while (iterate != null) {

      ListNode nextNode = iterate.next;

      if (counter == n) {
        prev.next = nextNode;
      } else {
        prev = iterate;
      }

      iterate = nextNode;

      counter++;
    }

    return ref.next;
  }

  private ListNode reverse(ListNode head) {

    ListNode prev = null;

    while (head != null) {
      ListNode nextNode = head.next;

      head.next = prev;
      prev = head;
      head = nextNode;
    }

    return prev;
  }

}
