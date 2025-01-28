package com.sanedge.interview.sliding_window;

public class MinSubArray {
  public int minSubArray(int target, int[] nums) {
    int n = nums.length;

    int left = 0;
    int currentSum = 0;
    int minLength = Integer.MAX_VALUE;

    for (int right = 0; right < n; right++) {
      currentSum += nums[right];

      while (currentSum >= target) {
        if (minLength > right - left + 1) {
          minLength = right - left + 1;
        }

        currentSum -= nums[left];

        left++;
      }
    }

    return minLength == Integer.MAX_VALUE ? 0 : minLength;
  }

}
