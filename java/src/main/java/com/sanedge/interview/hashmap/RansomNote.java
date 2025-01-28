package com.sanedge.interview.hashmap;

import java.util.HashMap;
import java.util.Map;

public class RansomNote {

  public static boolean canConstruct(String ransomNote, String magazine) {
    Map<Character, Integer> charCount = new HashMap<>();

    for (char c : magazine.toCharArray()) {
      charCount.put(c, charCount.getOrDefault(c, 0) + 1);
    }

    for (char c : ransomNote.toCharArray()) {
      if (charCount.getOrDefault(c, 0) == 0) {
        return false;
      }

      charCount.put(c, charCount.get(c) - 1);
    }

    return true;
  }
}
