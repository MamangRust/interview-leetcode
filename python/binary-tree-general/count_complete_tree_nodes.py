from typing import Optional


class TreeNode:
    def __init__(self, val: int = 0, left: Optional['TreeNode'], right: Optional['TreeNode']):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def countNodes(self, root: TreeNode) -> int:
        if not root:
            return 0

        left_depth = self.getDepth(root.left)
        right_depth = self.getDepth(root.right)

        if left_depth == right_depth:
            return (1 << left_depth)+ self.countNodes(root.right)
        else:
            return (1 << right_depth) + self.countNodes(root.left)



    def getDepth(self, node: Optional[TreeNode])  -> int:
        depth = 0

        while node:
            depth += 1

            node = node.left

        return depth
