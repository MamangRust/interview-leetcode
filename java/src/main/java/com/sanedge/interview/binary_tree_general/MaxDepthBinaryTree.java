package com.sanedge.interview.binary_tree_general;

import com.sanedge.interview.utils.TreeNode;

public class MaxDepthBinaryTree {

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);

        if (leftDepth > rightDepth) {
            return 1 + leftDepth;
        }

        return 1 + rightDepth;
    }
}
