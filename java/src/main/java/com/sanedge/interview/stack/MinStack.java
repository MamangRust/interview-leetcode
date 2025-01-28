package com.sanedge.interview.stack;

import java.util.Stack;

public class MinStack {
  private Stack<Integer> stack;
  private Stack<Integer> minStack;

  public MinStack() {
    stack = new Stack<>();
    minStack = new Stack<>();
  }

  public void push(int x) {
    stack.push(x);

    if (minStack.isEmpty() || x <= minStack.peek()) {
      minStack.push(x);
    }
  }

  public int top() {
    if (stack.isEmpty()) {
      throw new IllegalStateException("stack is empty");
    }

    return stack.peek();
  }

  public int getMin() {
    if (minStack.isEmpty()) {
      throw new IllegalStateException("Minstack  is empty");
    }

    return minStack.peek();
  }

}
