package com.sanedge.interview.math_leetcode;

public class PalingDrome {
  public boolean isPalingdrome(int x) {
    if (x < 0 || (x != 0 && x % 10 == 0)) {
      return false;
    }

    int reversed = 0;
    int original = x;

    while (x > 0) {
      reversed = reversed * 10 + x % 10;

      x /= 10;
    }

    return original == reversed;
  }

}
