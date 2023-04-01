package com.leetcode.problem.linkedlist;

import com.leetcode.common.ListNode;

public class Solved_Problem23MergeKSortedLists {

  public static void main(String[] args) {
    System.out.println(new Solved_Problem23MergeKSortedLists().mergeKLists(new ListNode[]{
        new ListNode(1, new ListNode(4, new ListNode(5))),
        new ListNode(1, new ListNode(3, new ListNode(4))),
        new ListNode(2, new ListNode(6)),
    })); // 1->1->2->3->4->4->5->6

    System.out.println(
        new Solved_Problem23MergeKSortedLists().mergeKLists(new ListNode[]{})); // null
  }

  public ListNode mergeKLists(ListNode[] lists) {

//    return solution2(lists); // beats 9%

    return solution1(lists); // beats 82%

  }

  public ListNode solution2(ListNode[] lists) {

    ListNode result = null;

    for (ListNode list : lists) {
      result = merge(result, list);
    }

    return result;

  }

  public ListNode solution1(ListNode[] lists) {
    if (lists.length == 0) {
      return null;
    }

    if (lists.length == 1) {
      return lists[0];
    }

    ListNode head = new ListNode();
    ListNode ref = head;
    int min, minValNodeIdx;
    int len = lists.length;
    int prevMin = min = Integer.MAX_VALUE;

    while (true) {

      prevMin = min;
      min = Integer.MAX_VALUE;
      minValNodeIdx = -1;

      for (int i = 0; i < len; i++) {
        if (lists[i] != null && lists[i].val < min) {
          min = lists[i].val;
          minValNodeIdx = i;
          if (min == prevMin + 1) {
            break;
          }
        }
      }

      if (minValNodeIdx == -1) {
        break;
      }

      for (int i = 0; i < len; i++) {
        while (lists[i] != null && lists[i].val == min) {
          head.next = lists[i];
          lists[i] = lists[i].next;
          head = head.next;

          if (lists[i] == null) {
            swap(lists, i, len - 1);
            len--;
          }
        }
      }
    }

    return ref.next;
  }

  public void swap(ListNode[] list, int i, int j) {
    ListNode v = list[i];
    list[i] = list[j];
    list[j] = v;
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

}
