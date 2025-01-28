package com.sanedge.interview.divide_conquer;

import java.util.Comparator;
import java.util.PriorityQueue;

class ListNode {

    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

class MinHeap implements Comparator<ListNode> {

    public int compare(ListNode a, ListNode b) {
        return a.val - b.val;
    }
}

public class MergeKLists {

    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(new MinHeap());

        for (ListNode list : lists) {
            if (list != null) {
                minHeap.offer(list);
            }
        }

        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        while (!minHeap.isEmpty()) {
            ListNode node = minHeap.poll();
            current.next = node;
            current = current.next;

            if (node.next != null) {
                minHeap.offer(node.next);
            }
        }

        return dummy.next;
    }

    public void printList(ListNode heap) {
        while (heap != null) {
            System.out.print(heap.val + " ");
            heap = heap.next;
        }
        System.out.println();
    }

    public ListNode createList(int[] arr) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        for (int val : arr) {
            current.next = new ListNode(val);
            current = current.next;
        }

        return dummy.next;
    }
}
