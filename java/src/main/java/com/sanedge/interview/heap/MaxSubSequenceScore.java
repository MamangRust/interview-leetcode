package com.sanedge.interview.heap;

import java.util.Arrays;

public class MaxSubSequenceScore {
  public static long maxScore(int[] nums1, int[] nums2, int k) {
    int n = nums1.length;

    int[][] pairs = new int[n][2];

    for (int i = 0; i < n; i++) {
      pairs[i][0] = nums1[i];
      pairs[i][1] = nums2[i];
    }

    Arrays.sort(pairs, (a, b) -> Integer.compare(b[1], a[1]));

    long sum = 0;

    int[] nums1Values = new int[k];

    for (int i = 0; i < k; i++) {
      sum += pairs[i][0];
      nums1Values[i] = pairs[i][0];

    }

    Arrays.sort(nums1Values);

    long result = sum * pairs[k - 1][1];

    for (int i = k; i < n; i++) {
      if (pairs[i][0] > nums1Values[0]) {
        sum = sum - nums1Values[0] + pairs[i][0];
        nums1Values[0] = pairs[i][0];

        Arrays.sort(nums1Values);

        long newResult = sum * pairs[i][1];

        if (newResult > result) {
          result = newResult;
        }
      }
    }

    return result;
  }

}
