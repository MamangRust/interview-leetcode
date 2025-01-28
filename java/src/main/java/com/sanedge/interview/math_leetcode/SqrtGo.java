package com.sanedge.interview.math_leetcode;

public class SqrtGo {
  public int mySqrt(int x) {
    if (x < 2) {
      return x;
    }

    int left = 2;
    int right = x / 2;

    int mid = 0;
    int sqrt = 0;

    while (left <= right) {
      mid = left + (right - left) / 2;
      sqrt = mid * mid;

      if (sqrt == x) {
        return mid;
      } else if (sqrt < x) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }

    return right;

  }

}
