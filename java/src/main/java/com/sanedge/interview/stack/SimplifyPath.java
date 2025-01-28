package com.sanedge.interview.stack;

import java.util.Stack;

public class SimplifyPath {
  public String simplifyPath(String path) {
    Stack<String> stack = new Stack<>();

    String[] parts = path.split("/");

    for (String part : parts) {
      if (part.equals("..")) {
        if (!stack.isEmpty()) {
          stack.pop();
        }
      } else if (!part.isEmpty() && !part.equals(".")) {
        stack.push(part);
      }
    }

    return "/" + String.join("/", stack);
  }

}
