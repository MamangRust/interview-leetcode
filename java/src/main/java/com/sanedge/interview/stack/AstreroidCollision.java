package com.sanedge.interview.stack;

import java.util.Stack;

public class AstreroidCollision {
  public int[] asteroidCollision(int[] asteroids) {
    Stack<Integer> stack = new Stack<>();

    for (int asteroid : asteroids) {
      while (!stack.isEmpty() && asteroid < 0 && stack.peek() > 0) {
        if (stack.peek() > -asteroid) {
          asteroid = 0;
          break;
        } else if (stack.peek() < -asteroid) {
          stack.pop();
        } else {
          stack.pop();
          asteroid = 0;
          break;
        }
      }

      if (asteroid != 0) {
        stack.push(asteroid);
      }
    }

    int[] result = new int[stack.size()];
    for (int i = 0; i < result.length; i++) {
      result[i] = stack.get(i);
    }

    return result;
  }

}
