from typing import Optional


class TreeNode:
    def __init__(self, val: int = 0, left = None, right = None)->None:
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        if not root:
            return True


        return self.isMirror(root.left, root.right)

    def isMirror(self, left: Optional[TreeNode],right: Optional[TreeNode]) -> bool:
        if not left and not right:
            return True

        if not left or not right or left.val != right.val:
            return False

        return self.isMirror(left.left, right.right) and self.isMirror(left.right, right.left)
