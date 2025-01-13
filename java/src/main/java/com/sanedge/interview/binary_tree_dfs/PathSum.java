package com.sanedge.interview.binary_tree_dfs;

import com.sanedge.interview.utils.TreeNode;
import java.util.HashMap;
import java.util.Map;

public class PathSum {

    public int pathSum(TreeNode root, int targetSum) {
        Map<Integer, Integer> prefixSum = new HashMap<>();

        prefixSum.put(0, 1);

        return dfs(root, 0, targetSum, prefixSum);
    }

    private int dfs(
        TreeNode node,
        int currSum,
        int targetSum,
        Map<Integer, Integer> prefixSum
    ) {
        if (node == null) {
            return 0;
        }

        currSum += node.val;

        int numPaths = prefixSum.getOrDefault(currSum - targetSum, 0);

        prefixSum.put(currSum, prefixSum.getOrDefault(currSum, 0) + 1);

        numPaths += dfs(node.left, currSum, targetSum, prefixSum);
        numPaths += dfs(node.right, currSum, targetSum, prefixSum);

        prefixSum.put(currSum, prefixSum.get(currSum) - 1);

        return numPaths;
    }
}
