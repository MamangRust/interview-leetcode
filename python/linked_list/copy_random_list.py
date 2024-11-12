from typing import Optional

class Node:
    def __init__(self, val: int, next: 'Node' = None, random: 'Node' = None):
        self.val = val
        self.next = next
        self.random = random


class Solution:
    def copyRandomList(self, head: Optional[Node]) -> Optional[Node]:
        if not head:
            return None

        current = head

        while current:
            new_node = Node(current.val, current.next, None)

            current.next = new_node

            current = new_node.next


        current = head

        while current:
            if current.random:
                current.next.random = current.random.next

            current = current.next.next

        original = head
        copy_head = head.next
        copy = copy_head

        while original:
            original.next = original.next.next

            if copy.next:
                copy.next = copy.next.next

            original = original.next

            copy = copy.next

        return copy_head
