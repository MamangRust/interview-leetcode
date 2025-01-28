package com.sanedge.interview.hashmap;

import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicate {
  public boolean containsNearbyDuplicate(int[] nums, int k) {
    Map<Integer, Integer> numsIndices = new HashMap<>();

    for (int i = 0; i < nums.length; i++) {
      int num = nums[i];

      if (numsIndices.containsKey(num) && i - numsIndices.get(num) <= k) {
        return true;
      }

      numsIndices.put(num, i);
    }

    return false;
  }
}
