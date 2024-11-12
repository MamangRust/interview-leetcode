from typing import Optional


class TreeNode:
    def __init__(self, val:int = 0, left = None, right = None) -> None:
        self.val = val
        self.left = left
        self.right = right


class BSTIterator:
    def __init__(self, root: Optional[TreeNode]) -> None:
        self.stack = []
        self._left_most_inorder(root)

    def _left_most_inorder(self, node):
        while node:
            self.stack.append(node)

            node = node.left

    def next(self) -> int:
        top_node = self.stack.pop()

        if top_node.right:
            self._left_most_inorder(top_node.right)

        return top_node.val

    def hasNext(self) -> bool:
        return len(self.stack) > 0
