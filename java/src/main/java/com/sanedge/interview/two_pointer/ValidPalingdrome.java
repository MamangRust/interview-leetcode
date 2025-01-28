package com.sanedge.interview.two_pointer;

import java.util.ArrayList;
import java.util.List;

public class ValidPalingdrome {
  public boolean isPalingdrome(String s) {
    List<Character> filteredChars = new ArrayList<>();

    for (char ch : s.toCharArray()) {
      if (Character.isLetterOrDigit(ch)) {
        filteredChars.add(Character.toLowerCase(ch));
      }
    }

    int left = 0;
    int right = filteredChars.size() - 1;

    while (left < right) {
      if (!filteredChars.get(left).equals(filteredChars.get(right))) {
        return false;
      }

      left++;
      right--;
    }

    return true;
  }

}
