package com.sanedge.interview.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses {
  public boolean isValid(String s) {
    Stack<Character> stack = new Stack<>();

    Map<Character, Character> mapping = new HashMap<>();

    mapping.put(')', '(');
    mapping.put('}', '{');
    mapping.put('[', ']');

    for (char ch : s.toCharArray()) {
      if (mapping.containsKey(ch)) {
        char topElement = stack.isEmpty() ? '#' : stack.pop();

        if (topElement != mapping.get(ch)) {
          return false;
        }
      } else {
        stack.push(ch);
      }
    }

    return stack.isEmpty();
  }

}
