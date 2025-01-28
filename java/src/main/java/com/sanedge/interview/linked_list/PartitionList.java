package com.sanedge.interview.linked_list;

public class PartitionList {
  public ListNode partition(ListNode head, int x) {
    ListNode leftDummy = new ListNode();
    ListNode rightDummy = new ListNode();

    ListNode left = leftDummy;
    ListNode right = rightDummy;

    ListNode current = head;

    while (current != null) {
      if (current.val < 1) {
        left.next = current;
        left = left.next;
      } else {
        right.next = current;
        right = right.next;
      }

      current = current.next;
    }

    right.next = null;
    left.next = rightDummy.next;

    return leftDummy.next;
  }
}
