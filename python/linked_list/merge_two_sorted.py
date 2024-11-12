class ListNode:
    def __init__(self, val: int = 0, next: None = None) -> None:
        self.val = val
        self.next = next

class Solution:
    def mergeTwoLists(self, l1: ListNode, l2: ListNode) -> ListNode:
        dummy = ListNode()
        current = dummy


        while l1 and l2:
            if l1.val  < l2.val:
                current.next = l1
                l1 = l1.next
            else:
                current.next = l2
                l2 = l2.next

            current = current.next

        if l1:
            current.next = l1
        elif l2:
            current.next = l2


        return dummy.next
