import math


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def getMinimumDifference(self,root: TreeNode) -> int:
        min_diff = math.inf
        prev = None

        def inorder(node: TreeNode):
            nonlocal min_diff, prev

            if node is None:
                return

            inorder(node.left)

            if prev is not None:
                min_diff = min(min_diff, node.val - prev)
            prev = node.val

                    # Traversal ke kanan
            inorder(node.right)


        inorder(root)

        return min_diff
