from typing import List



class Node:
    def __init__(self, val: bool, isLeaf: bool, topLeft='Node', topRight='Node', bottomLeft='Node', bottomRight='Node'):
        self.val = val
        self.isLeaf = isLeaf
        self.topLeft = topLeft
        self.topRight = topRight
        self.bottomLeft = bottomLeft
        self.bottomRight = bottomRight


class Solution:
    def construct(self, grid):
        return self.build(grid, 0, 0, len(grid))


    def build(self, grid: List[List[int]], x: int, y: int, size: int)-> Node:
        if size == 1:
            return Node(val=grid[x][y] == 1, isLeaf=True)

        all_same= True

        val = grid[x][y]

        for i in range(x, x + size):
            for j in range(x, y + size):
                if grid[i][j] != val:
                    all_same = False
                    break

            if not all_same:
                break

        if all_same:
            return Node(val=val == 1, isLeaf=True)

        mid = size // 2

        topLeft = self.build(grid, x, y, mid)
        topRight = self.build(grid, x, y +mid , mid)
        bottomLeft = self.build(grid, x + mid, y, mid)
        bottomRight = self.build(grid, x + mid, y + mid, mid)

        return Node(
                val=True,
                isLeaf=False,
                topLeft=topLeft,
                topRight=topRight,
                bottomLeft=bottomLeft,
                bottomRight=bottomRight,
        )

    def print_quad_tree(self,node: Node):
        if node is None:
            return

        if node.isLeaf:
            print(f"Leaf: {node.val}")

            return

        print("Non-Leaf:")

        self.print_quad_tree(node.topLeft)
        self.print_quad_tree(node.topRight)
        self.print_quad_tree(node.bottomLeft)
        self.print_quad_tree(node.bottomRight)
