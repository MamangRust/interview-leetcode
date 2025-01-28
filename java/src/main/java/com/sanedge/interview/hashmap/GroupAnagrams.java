package com.sanedge.interview.hashmap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {
  public static List<List<String>> groupAnagrams(String[] strs) {
    Map<String, List<String>> anagrams = new HashMap<>();

    for (String word : strs) {
      char[] chars = word.toCharArray();
      Arrays.sort(chars);

      String sortedWord = new String(chars);

      if (!anagrams.containsKey(sortedWord)) {
        anagrams.put(sortedWord, new ArrayList<>());
      }
      anagrams.get(sortedWord).add(word);
    }

    return new ArrayList<>(anagrams.values());
  }

}
