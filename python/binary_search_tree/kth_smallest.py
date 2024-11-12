from typing_extensions import Optional


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def kthSmallest(self,root: Optional[TreeNode], k: int) -> int:
        count = 0
        result = -1


        def inorder(node: TreeNode):
            nonlocal count, result
            if node is None or count >= k:
                return


            inorder(node.left)


            count += 1
            if count == k:
                result = node.val
                return


            inorder(node.right)


        inorder(root)
        return result
