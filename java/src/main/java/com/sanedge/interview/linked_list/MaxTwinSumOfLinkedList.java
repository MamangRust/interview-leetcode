package com.sanedge.interview.linked_list;

import com.sanedge.interview.hashmap.TwoSum;

public class MaxTwinSumOfLinkedList {
  public ListNode reverseList(ListNode head) {
    ListNode prev = null;

    ListNode curr = head;

    while (curr != null) {
      ListNode next = curr.next;

      curr.next = prev;

      prev = curr;

      curr = next;
    }

    return prev;
  }

  public int pairSum(ListNode head) {
    ListNode slow = head;
    ListNode fast = head;

    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }

    ListNode secondHalf = reverseList(slow);

    int maxSum = 0;
    ListNode firstHalf = head;

    while (secondHalf != null) {
      int twinSum = firstHalf.val + secondHalf.val;

      if (twinSum > maxSum) {
        maxSum = twinSum;
      }

      firstHalf = firstHalf.next;
      secondHalf = secondHalf.next;
    }

    return maxSum;

  }

}
