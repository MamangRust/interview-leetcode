package com.sanedge.interview.two_pointer;

import java.util.*;

public class SubSequenceChecker {

  private static Map<Character, List<Integer>> preprocess(String t) {
    Map<Character, List<Integer>> charIndices = new HashMap<>();

    for (int i = 0; i < t.length(); i++) {
      char ch = t.charAt(i);
      charIndices.computeIfAbsent(ch, k -> new ArrayList<>()).add(i);
    }

    return charIndices;
  }

  public static boolean isSubsequenceOptimized(String s, String t) {
    Map<Character, List<Integer>> charIndices = preprocess(t);

    int currentIndex = -1;

    for (int i = 0; i < s.length(); i++) {
      char ch = s.charAt(i);

      if (!charIndices.containsKey(ch)) {
        return false;
      }

      List<Integer> indices = charIndices.get(ch);
      boolean found = false;

      for (int index : indices) {
        if (index > currentIndex) {
          currentIndex = index;
          found = true;
          break;
        }
      }

      if (!found) {
        return false;
      }
    }

    return true;
  }
}
