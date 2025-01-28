package com.sanedge.interview.two_pointer;

import java.util.HashMap;
import java.util.Map;

public class MaxNumberOfKSumPair {
  public int maxOperations(int[] nums, int k) {
    int count = 0;

    Map<Integer, Integer> freqMap = new HashMap<>();

    for (int num : nums) {
      int complement = k - num;

      if (freqMap.getOrDefault(complement, 0) > 0) {
        count++;

        freqMap.put(complement, freqMap.get(complement) - 1);
      } else {
        freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
      }
    }

    return count;
  }

}
