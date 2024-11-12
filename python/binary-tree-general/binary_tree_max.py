from typing import Optional

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def __init__(self) -> None:
        self.max_sum = float('-inf')

    def maxPathSum(self, root:  Optional[TreeNode]) -> int:
        self.calculateMaxPath(root)

        return self.max_sum

    def calculateMaxPath(self, node: Optional[TreeNode]) -> int:
        if not node:
            return 0

        left_gain = max(self.calculateMaxPath(node.left), 0)
        right_gain = max(self.calculateMaxPath(node.right), 0)

        current_path_sum = node.val + left_gain + right_gain

        self.max_sum = max(self.max_sum, current_path_sum)

        return node.val + max(left_gain, right_gain)
