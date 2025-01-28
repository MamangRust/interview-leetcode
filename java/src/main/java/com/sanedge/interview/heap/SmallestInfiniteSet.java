package com.sanedge.interview.heap;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class SmallestInfiniteSet {
  private PriorityQueue<Integer> heap;
  private Set<Integer> extractedSet;
  private int nextNum;

  public SmallestInfiniteSet() {
    heap = new PriorityQueue<>();
    extractedSet = new HashSet<>();
    nextNum = 1;
  }

  public int popSmallest() {
    if (!heap.isEmpty()) {
      int smallest = heap.poll();
      extractedSet.remove(smallest);

      return smallest;
    }

    int result = nextNum;
    nextNum++;

    return result;
  }

  private void addBack(int num) {
    if (num < nextNum && !extractedSet.contains(num)) {
      heap.offer(num);

      extractedSet.add(num);
    }
  }

}
