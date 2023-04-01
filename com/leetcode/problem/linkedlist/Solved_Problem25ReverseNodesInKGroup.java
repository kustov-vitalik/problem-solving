package com.leetcode.problem.linkedlist;

import com.leetcode.common.ListNode;

public class Solved_Problem25ReverseNodesInKGroup {


  public static void main(String[] args) {
    ListNode test = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
    System.out.println(new Solved_Problem25ReverseNodesInKGroup().reverseKGroup(test, 2)); // [2<->1]->[4<->3]->5

    test = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
    System.out.println(new Solved_Problem25ReverseNodesInKGroup().reverseKGroup(test, 3)); // [3<->2<->1]->4->5
  }


  public ListNode reverseKGroup(ListNode head, int k) {
    if (head == null) {
      return null;
    }

    if (k < 2) {
      return head;
    }

    int size = size(head);

    if (size < k) {
      return head;
    }

    int batchesCount = size/k;

    ListNode current = head;
    ListNode currentRef;

    ListNode result = new ListNode(0);
    ListNode resultRef = result;

    for (int i = 0; i < batchesCount; i++) {
      int counter = k;

      currentRef = current;
      while (counter > 0 && current != null) {
        current = current.next;
        counter--;
      }
      result = append(result, reverse(diff(currentRef, current)));
    }

    if (current != null) {
      append(result, current);
    }

    return resultRef.next;
  }

  public ListNode reverse(ListNode node) {
    ListNode prev = null;

    while (node != null) {
      ListNode next = node.next;
      node.next = prev;
      prev = node;
      node = next;
    }

    return prev;
  }

  public int size(ListNode node) {
    ListNode temp = node;
    int len = 0;
    while (temp != null) {
      temp = temp.next;
      len++;
    }
    return len;
  }

  public ListNode diff(ListNode longList, ListNode shortList) {
    ListNode result = longList;
    ListNode resultRef = result;
    ListNode prev = null;
    while (result != shortList) {
      prev = result;
      result = result.next;
    }
    prev.next = null;
    return resultRef;
  }

  public ListNode append(ListNode node, ListNode suffix) {
    ListNode prev = null;
    while (node != null) {
      prev = node;
      node = node.next;
    }

    prev.next = suffix;

    while (suffix != null) {
      prev = suffix;
      suffix = suffix.next;
    }

    return prev;
  }


}
