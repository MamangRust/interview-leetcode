package com.sanedge.interview.two_pointer;

public class MoveZeroes {
  public void moveZeroes(int[] nums) {
    int lastNonZeroFoundAt = 0;

    for (int current = 0; current < nums.length; current++) {
      if (nums[current] != 0) {
        int temp = nums[lastNonZeroFoundAt];
        nums[lastNonZeroFoundAt] = nums[current];
        nums[current] = temp;

        lastNonZeroFoundAt++;
      }
    }
  }

}
