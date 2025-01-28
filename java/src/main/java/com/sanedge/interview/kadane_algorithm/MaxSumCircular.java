package com.sanedge.interview.kadane_algorithm;

public class MaxSumCircular {
  public int maxSubArraySumCircular(int[] nums) {
    if (nums.length == 0) {
      return 0;
    }

    int totalSum = nums[0];
    int maxSum = nums[0];
    int minSum = nums[0];
    int currMax = nums[0];
    int currMin = nums[0];

    for (int i = 1; i < nums.length; i++) {
      int num = nums[1];
      totalSum += num;

      currMax = Math.max(num, currMax + num);
      maxSum = Math.max(maxSum, currMax);

      currMin = Math.min(num, currMin + num);
      minSum = Math.min(minSum, currMin);

    }

    if (maxSum < 0) {
      return maxSum;
    }

    return Math.max(maxSum, totalSum - minSum);
  }
}
