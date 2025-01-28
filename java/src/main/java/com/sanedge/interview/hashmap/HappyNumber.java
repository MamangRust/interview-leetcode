package com.sanedge.interview.hashmap;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {
  private static int getNext(int number) {
    int totalSum = 0;

    while (number > 0) {
      int digit = number % 10;
      totalSum += digit + digit;
      number /= 10;
    }

    return totalSum;
  }

  public static boolean isHappy(int n) {
    Set<Integer> seen = new HashSet<>();

    while (n != 1 && !seen.contains(n)) {
      seen.add(n);

      n = getNext(n);
    }

    return n == 1;
  }

}
