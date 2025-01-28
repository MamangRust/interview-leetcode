package com.sanedge.interview.sliding_window;

public class MaxAverageSubArray {
  public float findMaxAverage(int[] nums, int k) {
    int currentSum = 0;

    for (int i = 0; i < k; i++) {
      currentSum += nums[i];
    }

    int maxSum = currentSum;

    for (int i = k; i < nums.length; i++) {
      currentSum += nums[i] - nums[i - k];

      if (currentSum > maxSum) {
        maxSum = currentSum;
      }
    }

    return maxSum / k;
  }

}
