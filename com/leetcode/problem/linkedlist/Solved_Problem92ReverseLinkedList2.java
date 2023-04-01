package com.leetcode.problem.linkedlist;

import com.leetcode.common.ListNode;

public class Solved_Problem92ReverseLinkedList2 {

  public static void main(String[] args) {
    System.out.println(new Solution().reverseBetween(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))))), 2, 4));
    System.out.println(new Solution().reverseBetween(new ListNode(5), 1, 1));
    System.out.println(new Solution().reverseBetween(new ListNode(3, new ListNode(5)), 1, 2));
  }

  static class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
      if (head == null || head.next == null || left == right) {
        return head;
      }

      int counter = 1;

      ListNode prefixRef = head;
      ListNode prefix = prefixRef;
      if (left > 1) {

        while (counter < left - 1) {
          prefix = prefix.next;
          head = head.next;
          counter++;
        }

        head = prefix.next;
        prefix.next = null;

      } else {
        prefixRef = null;
      }

      ListNode fromNode = head;
      ListNode fromNodeRef = fromNode;

      counter = 0;
      while (counter < right - left) {
        head = head.next;
        fromNode = fromNode.next;
        counter++;
      }

      ListNode suffix = fromNode.next;
      fromNode.next = null;

      return append(append(prefixRef, reverseList(fromNodeRef)), suffix);
    }

    public ListNode append(ListNode l1, ListNode l2) {
      if (l1 == null && l2 == null) {
        return null;
      }

      if (l1 == null) {
        return l2;
      }

      if (l2 == null) {
        return l1;
      }

      ListNode ref = l1;
      while (l1.next != null) {
        l1 = l1.next;
      }

      l1.next = l2;

      return ref;
    }

    public ListNode reverseList(ListNode head) {
      ListNode prev = null;
      while (head != null) {
        ListNode next = head.next;
        head.next = prev;
        prev = head;
        head = next;
      }
      return prev;
    }
  }

}
