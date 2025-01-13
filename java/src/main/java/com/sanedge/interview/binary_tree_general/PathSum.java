package com.sanedge.interview.binary_tree_general;

import com.sanedge.interview.utils.TreeNode;

public class PathSum {

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }

        if (root.left == null && root.right == null) {
            return targetSum == root.val;
        }

        targetSum -= root.val;

        return (
            hasPathSum(root.left, targetSum) ||
            hasPathSum(root.right, targetSum)
        );
    }
}
