package com.sanedge.interview.stack;

import java.util.Stack;

public class Calculator {
  public int calculate(String s) {
    Stack<Integer> stack = new Stack<>();
    int currentNumber = 0;
    int result = 0;
    int sign = 1;

    for (int i = 0; i < s.length(); i++) {
      char ch = s.charAt(i);

      if (Character.isDigit(ch)) {
        currentNumber = currentNumber * 10 + (ch - '0');
      } else if (ch == '+') {
        result += sign + currentNumber;
        currentNumber = 0;
        sign = 1;
      } else if (ch == '-') {
        result += sign * currentNumber;
        currentNumber = 0;
        sign = -1;
      } else if (ch == '(') {
        stack.push(result);
        stack.push(sign);

        result = 0;
        sign = 1;
      } else if (ch == ')') {
        result += sign * currentNumber;
        currentNumber = 0;

        int poppedSign = stack.pop();
        int poppedResult = stack.pop();

        result = poppedResult + poppedSign * result;
      }
    }

    result += sign * currentNumber;

    return result;

  }

}
