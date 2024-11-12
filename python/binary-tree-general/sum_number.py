from typing import Optional


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        return self.dfs(root, 0)

    def dfs(self, node: Optional[TreeNode], current_sum: int) -> int:
        if not node:
            return 0

        current_sum = current_sum * 10 + node.val

        if not node.left and not node.right:
            return current_sum

        left_sum = self.dfs(node.left, current_sum)
        right_sum = self.dfs(node.right, current_sum)

        return left_sum + right_sum
