package com.sanedge.interview.queue;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfRecentCalls {
  private Queue<Integer> queue;

  public NumberOfRecentCalls() {
    queue = new LinkedList<>();
  }

  public int ping(int t) {
    queue.offer(t);

    while (!queue.isEmpty() && queue.peek() < t - 3000) {
      queue.poll();
    }

    return queue.size();
  }

}
