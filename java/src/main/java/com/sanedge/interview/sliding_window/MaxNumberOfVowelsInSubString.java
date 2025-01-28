package com.sanedge.interview.sliding_window;

public class MaxNumberOfVowelsInSubString {
  private boolean isVowel(char c) {
    String vowels = "aeiouAEIOU";
    return vowels.indexOf(c) != -1;
  }

  public int maxVowels(String s, int k) {
    int maxVowelCount = 0;
    int currentVowelCount = 0;

    for (int i = 0; i < k; i++) {
      if (isVowel(s.charAt(i))) {
        currentVowelCount++;
      }
    }

    for (int i = k; i < s.length(); i++) {
      if (isVowel(s.charAt(i))) {
        currentVowelCount++;
      }

      if (isVowel(s.charAt(i - k))) {
        currentVowelCount--;
      }

      if (currentVowelCount > maxVowelCount) {
        maxVowelCount = currentVowelCount;
      }
    }

    return maxVowelCount;
  }

}
