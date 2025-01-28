package com.sanedge.interview.intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {
  public int[][] merge(int[][] intervals) {
    if (intervals.length == 0) {
      return new int[0][0];
    }

    Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

    List<int[]> merged = new ArrayList<>();
    merged.add(intervals[0]);

    for (int i = 0; i < intervals.length; i++) {
      int[] lastMerged = merged.get(merged.size() - 1);
      int[] current = intervals[i];

      if (current[0] <= lastMerged[1]) {
        lastMerged[1] = Math.max(lastMerged[1], current[1]);
      } else {
        merged.add(current);
      }
    }

    return merged.toArray(new int[merged.size()][]);
  }
}
