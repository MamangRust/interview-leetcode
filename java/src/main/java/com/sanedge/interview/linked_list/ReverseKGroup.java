package com.sanedge.interview.linked_list;

public class ReverseKGroup {
  public ListNode reverseKGroup(ListNode head, int k) {
    int count = 0;
    ListNode ptr = head;

    while (count < k && ptr != null) {
      ptr = ptr.next;
      count++;
    }

    if (count == k) {
      ListNode reversedHead = reverseLinkedList(head, k);

      head.next = reverseKGroup(ptr, k);

      return reversedHead;
    }

    return head;
  }

  public ListNode reverseLinkedList(ListNode head, int k) {
    ListNode newHead = null;

    ListNode ptr = head;

    while (k > 0) {
      ListNode nextNode = ptr.next;
      ptr.next = newHead;

      newHead = ptr;
      ptr = nextNode;
      k--;
    }

    return newHead;
  }

}
