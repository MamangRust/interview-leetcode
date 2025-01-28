package com.sanedge.interview.hashmap;

import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {
  public static boolean isAnagram(String s, String t) {
    if (s.length() != t.length()) {
      return false;
    }

    Map<Character, Integer> charCount = new HashMap<>();

    for (char c : s.toCharArray()) {
      charCount.put(c, charCount.getOrDefault(c, 0) + 1);

    }

    for (char c : t.toCharArray()) {
      if (!charCount.containsKey(c)) {
        return false;
      }

      charCount.put(c, charCount.get(c) - 1);

      if (charCount.get(c) < 0) {
        return false;
      }
    }

    for (int count : charCount.values()) {
      if (count != 0) {
        return false;
      }
    }

    return true;
  }
}
