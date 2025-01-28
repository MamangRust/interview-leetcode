package com.sanedge.interview.heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

class Pair {
  int num1, num2, i, j;

  Pair(int num1, int num2, int i, int j) {
    this.num1 = num1;
    this.num2 = num2;
    this.i = i;
    this.j = j;
  }
}

public class FindKPair {
  public static List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
    List<List<Integer>> result = new ArrayList<>();

    if (nums1.length == 0 || nums2.length == 0 || k == 0) {
      return result;
    }

    PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(p -> p.num1 + p.num2));

    for (int i = 0; i < nums1.length && i < k; i++) {
      pq.offer(new Pair(nums1[i], nums2[0], i, 0));
    }

    while (k > 0 && !pq.isEmpty()) {
      Pair pair = pq.poll();

      result.add(Arrays.asList(pair.num1, pair.num2));

      k--;

      if (pair.j + 1 < nums2.length) {
        pq.offer(new Pair(pair.num1, nums2[pair.j + 1], pair.i, pair.j + 1));
      }
    }

    return result;
  }

}
