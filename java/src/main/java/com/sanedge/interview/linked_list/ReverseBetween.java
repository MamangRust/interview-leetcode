package com.sanedge.interview.linked_list;

public class ReverseBetween {
  public ListNode reverseBetween(ListNode head, int left, int right) {
    if (head == null || left == right) {
      return head;
    }

    ListNode dummy = new ListNode(0);

    dummy.next = head;

    ListNode prev = dummy;

    for (int i = 0; i < left - 1; i++) {
      prev = prev.next;
    }

    ListNode reverseStart = prev.next;
    ListNode then = reverseStart.next;

    for (int i = 0; i < right - left; i++) {
      reverseStart.next = then.next;

      then.next = prev.next;
      prev.next = then;
      then = reverseStart.next;
    }

    return dummy.next;
  }

}
