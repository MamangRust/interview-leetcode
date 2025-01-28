package com.sanedge.interview.binary_search_tree;

import com.sanedge.interview.utils.TreeNode;

public class MinAbsoluteDiffBst {

    private int minDiff = Integer.MAX_VALUE;
    private Integer prev = null;

    public int getMinimumDifference(TreeNode root) {
        inorder(root);

        return minDiff;
    }

    private void inorder(TreeNode node) {
        if (node == null) {
            return;
        }

        inorder(node.left);

        if (prev != null) {
            minDiff = Math.min(minDiff, node.val - prev);
        }

        prev = node.val;

        inorder(node.right);
    }
}
