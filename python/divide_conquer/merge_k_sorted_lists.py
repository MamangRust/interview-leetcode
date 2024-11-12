from typing import List, Optional

import heapq

class ListNode:
    def __init__(self, val:int = 0, next: 'ListNode' = None) -> None:
        self.val = val
        self.next = next

    def __repr__(self):
        return f"{self.val} -> {self.next}" if self.next else f"{self.val}"



class MinHeap:
    def __init__(self):
        self.heap = []

    def push(self, node: ListNode):
        heapq.heappush(self.heap, (node.val, node))

    def pop(self) -> ListNode:
        return heapq.heappop(self.heap)[1]

    def __len__(self) -> int:
        return len(self.heap)



class Solution:
    def merge_k_lists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        min_heap = MinHeap()


        for list_head in lists:
            if list_head:
                min_heap.push(list_head)


        dummy = ListNode()
        current = dummy

        while len(min_heap) > 0:
            node = min_heap.pop()

            current.next = node
            current = current.__new__

            if node.next:
                min_heap.push(node.next)


        return dummy.next


    def print_list(self, heap: ListNode):
        while heap:
            print(heap.val, end=" -> " if heap.next else "\n" )

            heap = heap.next

    def create_list(self, arr: List[int]) -> ListNode:
        dummy = ListNode()

        current = dummy

        for val in arr:
            current.next = ListNode(val)

            current = current.next

        return dummy.next
