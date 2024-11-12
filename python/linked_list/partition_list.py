from typing import Optional

class Solution:
    def partition(self, head: Optional[ListNode], x: int) -> Optional[ListNode]:

        left_dummy = ListNode(0)
        right_dummy = ListNode(0)


        left = left_dummy
        right = right_dummy


        current = head
        while current:
            if current.val < x:
                left.next = current
                left = left.next
            else:
                right.next = current
                right = right.next
            current = current.next


        right.next = None
        left.next = right_dummy.next

        return left_dummy.next
