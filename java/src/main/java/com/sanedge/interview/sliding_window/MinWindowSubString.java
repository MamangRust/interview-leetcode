package com.sanedge.interview.sliding_window;

import java.util.HashMap;
import java.util.Map;

public class MinWindowSubString {
  public String minWindow(String s, String t) {
    if (t.length() > s.length()) {
      return "";
    }

    Map<Character, Integer> tCount = new HashMap<>();
    for (char c : t.toCharArray()) {
      tCount.put(c, tCount.getOrDefault(c, 0) + 1);
    }

    int required = tCount.size();
    Map<Character, Integer> windowCount = new HashMap<>();

    int left = 0;
    int right = 0;
    int formed = 0;

    int minLen = Integer.MAX_VALUE;
    int start = 0;
    int end = 0;

    while (right < s.length()) {
      char currentChar = s.charAt(right);

      windowCount.put(currentChar, windowCount.getOrDefault(currentChar, 0) + 1);

      if (tCount.containsKey(currentChar) && windowCount.get(currentChar).equals(tCount.get(currentChar))) {
        formed++;
      }

      while (left <= right && formed == required) {

        if (right - left + 1 < minLen) {
          minLen = right - left + 1;
          start = left;
          end = right;
        }

        char leftChar = s.charAt(left);

        windowCount.put(leftChar, windowCount.get(leftChar) - 1);

        if (tCount.containsKey(leftChar) && windowCount.get(leftChar) < tCount.get(leftChar)) {
          formed--;
        }

        left++;
      }

      right++;
    }

    return minLen == Integer.MAX_VALUE ? "" : s.substring(start, end + 1);
  }

}
