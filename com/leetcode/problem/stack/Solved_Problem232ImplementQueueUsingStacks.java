package com.leetcode.problem.stack;

import java.util.Stack;

/**
 * <a href="https://leetcode.com/problems/implement-queue-using-stacks/">Problem description</a>
 */
public class Solved_Problem232ImplementQueueUsingStacks {
    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.push(1); // queue is: [1]
        myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
        System.out.println(myQueue.peek()); // return 1
        System.out.println(myQueue.pop()); // return 1, queue is [2]
        System.out.println(myQueue.empty()); // return false
    }

    static class MyQueue {

        Stack<Integer> stackTo;
        Stack<Integer> stackFrom;

        public MyQueue() {
            stackTo = new Stack<>();
            stackFrom = new Stack<>();
        }

        public void push(int x) {
            stackTo.push(x);
        }

        public int pop() {
            if (stackFrom.isEmpty()) {
                while (!stackTo.isEmpty()) {
                    stackFrom.push(stackTo.pop());
                }
            }

            return stackFrom.pop();
        }

        public int peek() {
            if (stackFrom.isEmpty()) {
                while (!stackTo.isEmpty()) {
                    stackFrom.push(stackTo.pop());
                }
            }

            return stackFrom.peek();
        }

        public boolean empty() {
            return stackFrom.isEmpty() && stackTo.isEmpty();
        }
    }
}
