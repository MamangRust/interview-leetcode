package com.sanedge.interview.stack;

import java.util.Stack;

public class EvalRPN {
  public int evalRPN(String[] tokens) {
    Stack<Integer> stack = new Stack<>();

    for (String token : tokens) {
      switch (token) {
        case "+":
          int b = stack.pop();
          int a = stack.pop();

          stack.push(a + b);
        case "-":
          b = stack.pop();
          a = stack.pop();

          stack.push(a - b);
          break;
        case "*":
          b = stack.pop();
          a = stack.pop();

          stack.push(a * b);
          break;
        case "/":
          b = stack.pop();
          a = stack.pop();

          stack.push(a / b);

          break;
        default:
          stack.push(Integer.parseInt(token));
          break;

      }
    }

    return stack.pop();
  }

}
