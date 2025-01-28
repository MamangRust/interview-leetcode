package com.sanedge.interview.hashmap;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class UniqueNumberOfOccurences {
  public static boolean uniqueOccurences(int[] arr) {
    Map<Integer, Integer> freqMap = new HashMap<>();

    for (int num : arr) {
      freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);

    }

    Set<Integer> freqSet = new HashSet<>();

    for (int freq : freqMap.values()) {
      if (freqSet.contains(freq)) {
        return false;
      }

      freqSet.add(freq);
    }

    return true;
  }
}
