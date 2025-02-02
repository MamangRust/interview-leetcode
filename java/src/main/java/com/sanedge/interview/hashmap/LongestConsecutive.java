package com.sanedge.interview.hashmap;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutive {
  public static int longestConsecutive(int[] nums) {
    if (nums.length == 0) {
      return 0;
    }

    Set<Integer> numSet = new HashSet<>();

    for (int num : nums) {
      numSet.add(num);
    }

    int longestStreak = 0;

    for (int num : numSet) {
      if (!numSet.contains(num - 1)) {
        int currentNum = num;
        int currentStreak = 1;

        while (numSet.contains(currentNum + 1)) {
          currentNum++;
          currentStreak++;
        }

        if (currentStreak > longestStreak) {
          longestStreak = currentStreak;
        }
      }
    }

    return longestStreak;
  }

}
