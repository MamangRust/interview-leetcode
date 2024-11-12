from typing import Optional


class TreeNode:
    def __init__(self, val: int = 0, left: None = None, right: None = None) -> None:
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def flatten(self, root: Optional[TreeNode]) -> None:
        if not root:
            return None

        current = root

        while current:
            if current.left:
                right_most = current.left

                while right_most.right:
                    right_most = right_most.right

                right_most.right = current.right

                current.right =  current.left

                current.left = None

            current = current.right
