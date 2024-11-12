from typing import List, Optional

class Node:
    def __init__(self, val: int = 0, neighbors: Optional[List['Node']] = None):
        self.val = val
        self.neighbors = neighbors if neighbors is not None else []

class Solution:
    def cloneGraph(self,node: 'Node') -> 'Node':
        if not node:
            return None

        cloned = {}


        def dfs(n: 'Node') -> 'Node':
            if n in cloned:
                return cloned[n]

            copy = Node(n.val)

            cloned[n] = copy

            for neighbor in n.neighbors:
                copy.neighbors.append(dfs(neighbor))


            return copy

        return dfs(node)
