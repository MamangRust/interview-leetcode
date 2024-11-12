from typing import List, Optional

class TreeNode:
    def __init__(self, val: int = 0, left: None= None, right: None = None) -> None:
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) ->  Optional[TreeNode]:
        inorder_map = {
            val: idx for idx, val in enumerate(inorder)
        }


        def helper(in_left: int, in_right: int) -> Optional[TreeNode]:
            if in_left > in_right:
                return None


            root_val = postorder.pop()
            root = TreeNode(root_val)

            index = inorder_map[root_val]

            root.right = helper(index + 1, in_right)
            root.left = helper(in_left, index - 1)

            return root

        return helper(0, len(inorder) - 1)
