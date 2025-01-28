package com.sanedge.interview.stack;

import java.util.Stack;

public class RemovingStarsFromAString {
  public String removeStars(String s) {
    Stack<Character> stack = new Stack<>();

    for (char ch : s.toCharArray()) {
      if (ch == '*') {
        if (!stack.isEmpty()) {
          stack.pop();
        }
      } else {
        stack.push(ch);
      }
    }

    StringBuilder result = new StringBuilder();
    for (char ch : stack) {
      result.append(ch);
    }

    return result.toString();
  }

}
