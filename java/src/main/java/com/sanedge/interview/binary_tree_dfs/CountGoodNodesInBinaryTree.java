package com.sanedge.interview.binary_tree_dfs;

import com.sanedge.interview.utils.TreeNode;

public class CountGoodNodesInBinaryTree {

    public int countGoodNodes(TreeNode node, int maxVal) {
        if (node == null) {
            return 0;
        }

        int count = 0;

        if (node.val >= maxVal) {
            count = 1;
        }

        int newMax = Math.max(maxVal, node.val);

        count += countGoodNodes(node.left, newMax);
        count += countGoodNodes(node.right, newMax);

        return count;
    }

    public int goodNodes(TreeNode root) {
        return countGoodNodes(root, root.val);
    }
}
