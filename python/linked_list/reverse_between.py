class ListNode:
    def __init__(self, val: int = 0, next: None = None) -> None:
        self.val = val
        self.next = next

class Solution:
    def reverseBetween(self, head: ListNode, left: int,  right: int) -> ListNode:
        if not head or left == right:
            return head

        dummy = ListNode(0)
        dummy.next = head
        prev = dummy

        for _ in range(left - 1):
            prev = prev.next


        reverse_start = prev.next
        then = reverse_start.next

        for _ in range(right - left):
            reverse_start.next = then.next
            then.next = prev.next
            prev.next = then
            then = reverse_start.next

        return dummy.next
