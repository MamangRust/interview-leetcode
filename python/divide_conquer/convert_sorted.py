from typing import List


class TreeNode:
    def __init__(self, val: int = 0, left: 'TreeNode' = None, right: 'TreeNode' = None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def sortedArrayToBST(self, nums: List[int]) -> TreeNode | None:
        if len(nums) == 0:
            return None

        mid = len(nums) // 2

        root = TreeNode(
            val=nums[mid]
        )

        root.left = self.sortedArrayToBST(nums=nums[:mid])
        root.right = self.sortedArrayToBST(nums[mid+1:])

        return root


    def preorderTraversal(self,root: TreeNode):
        if root == None:
            return

        print(root.val, " ")

        self.preorderTraversal(root.left)
        self.preorderTraversal(root.right)
