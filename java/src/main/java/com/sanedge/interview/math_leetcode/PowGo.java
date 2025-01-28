package com.sanedge.interview.math_leetcode;

public class PowGo {
  public float myPow(float x, int n) {
    if (n == 0) {
      return 1;
    }

    if (n < 0) {
      x = 1 / x;
      n = -n;
    }

    return quickPow(x, n);
  }

  private float quickPow(float x, int n) {
    if (n == 0) {
      return 1;
    }

    float half = quickPow(x, n / 2);

    if (n % 2 == 0) {
      return half * half;
    } else {
      return half * half * x;
    }
  }

}
