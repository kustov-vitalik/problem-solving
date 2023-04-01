package com.leetcode.problem.stack;

public class Solved_Problem155MinStack {

  public static void main(String[] args) {
    MinStack minStack = new MinStack();
    minStack.push(-2);
    minStack.push(0);
    minStack.push(-3);
    System.out.println(minStack.getMin()); // -3
    minStack.pop();
    System.out.println(minStack.top()); // 0
    System.out.println(minStack.getMin()); // -2
  }

  public static class MinStack {

    private Node head;

    private Node minValue;

    public MinStack() {
    }

    public void push(int val) {

      head = new Node(val, head);

      minValue = new Node(minValue == null ? val : Math.min(minValue.val, val), minValue);

    }

    public void pop() {
      head = head.next;
      minValue = minValue.next;
    }

    public int top() {
      return head.val;
    }

    public int getMin() {
      return minValue.val;
    }

    static class Node {
      Integer val;
      Node next;

      public Node(Integer val, Node next) {
        this.val = val;
        this.next = next;
      }
    }
  }

}
