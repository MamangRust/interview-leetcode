from collections import deque
from typing import Optional

class Node:
    def __init__(self, val: int = 0, left: Optional['Node'] = None, right: Optional['Node'] = None, next: Optional['Node'] = None):
        self.val = val
        self.left = left
        self.right = right
        self.next = next

class Solution:
    def connect(self, root: Optional[Node]) -> Optional[Node]:
        if not root:
            return None

        queue = deque([root])

        while queue:
            prev = None

            level_size = len(queue)

            for _ in range(level_size):
                node = queue.popleft()

                if prev:
                    prev.next = node

                prev = node


                if node.left:
                    queue.append(node.left)

                if node.right:
                    queue.append(node.right)


            prev.next = None

        return root
