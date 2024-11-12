from typing import List, Optional

class ListNode:
    def __init__(self, val: int = 0, next: 'ListNode' = None):
        self.val = val
        self.next = next

    # Helper to represent the list node for easy visualization
    def __repr__(self):
        return f"{self.val} -> {self.next}" if self.next else f"{self.val}"


class Solution:
    def sort_list(self, head: Optional[ListNode]) -> Optional[ListNode]:
        if not head or not head.next:
            return head

        n = 0

        current = head

        while current:
            n += 1
            current = current.next

        dummy = ListNode(0)
        dummy.next = head
        step = 1

        while step < n:
            prev, curr = dummy, dummy.next

            while curr:
                left = curr
                right = self.split(left, step)

                curr = self.split(right, step)

                prev.next = self.merge(left, right)

                while prev.next:
                    prev = prev.next

            step *= 2

        return dummy.next

    def split(self, head: Optional[ListNode], step: int) -> Optional[ListNode]:
        for _ in range(1, step):
            if head:
                head = head.next
            else:
                return None

        next_segment = head.next

        head.next = None

        return next_segment

    def merge(self,left: Optional[ListNode], right: Optional[ListNode]) -> Optional[ListNode]:
        dummy = ListNode(0)
        current = dummy

        while left and right:
            if left.val < right.val:
                current.next = left
                left = left.next
            else:
                current.next  = right
                right = right.next

            current = current.next

        current.next = left if left else right

        return dummy.next

    def print_list(self, head: Optional[ListNode]):
        while head:
            print(head.val, end=" -> " if head.next else "\n")
            head = head.next

    def create_list(self, arr: List[int]) -> Optional[ListNode]:
        dummy = ListNode()

        current = dummy

        for val in arr:
            current.next = ListNode(val)
            current = current.next

        return dummy.next
