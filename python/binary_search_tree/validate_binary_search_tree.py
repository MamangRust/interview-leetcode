import math

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def isValidBST(self, root: TreeNode) -> bool:
        return self.validate(root, -math.inf, math.inf)

    def validate(self,node: TreeNode, min_val: float, max_val: float) -> bool:
        if node is None:
            return True

        if node.val <= min_val or node.val >= max_val:
            return False

        return self.validate(node.left, min_val, node.val) and self.validate(node.right, node.val, max_val)
