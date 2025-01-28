package com.sanedge.interview.sliding_window;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubStringWithConcatenation {
  public List<Integer> findSubstring(String s, String[] words) {
    List<Integer> result = new ArrayList<>();

    if (s == null || s.length() == 0 || words == null || words.length == 0) {
      return result;
    }

    int wordLen = words[0].length();
    int wordCount = words.length;
    int totalLen = wordLen * wordCount;

    Map<String, Integer> wordMap = new HashMap<>();
    for (String word : words) {
      wordMap.put(word, wordMap.getOrDefault(word, 0) + 1);
    }

    for (int i = 0; i < wordLen; i++) {
      int left = i, right = i;
      Map<String, Integer> currMap = new HashMap<>();

      while (right + wordLen <= s.length()) {
        String word = s.substring(right, right + wordLen);
        right += wordLen;

        if (wordMap.containsKey(word)) {
          currMap.put(word, currMap.getOrDefault(word, 0) + 1);
          while (currMap.get(word) > wordMap.get(word)) {
            String leftWord = s.substring(left, left + wordLen);
            currMap.put(leftWord, currMap.get(leftWord) - 1);
            left += wordLen;
          }

          if (right - left == totalLen) {
            result.add(left);
          }
        } else {
          currMap.clear();
          left = right;
        }
      }
    }

    return result;
  }

}
