package com.sanedge.interview.binary_tree_general;

import com.sanedge.interview.utils.TreeNode;

public class BinaryTreeMax {

    private int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        calculateMaxPath(root);

        return maxSum;
    }

    private int calculateMaxPath(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int leftGain = Math.max(calculateMaxPath(node.left), 0);
        int rightGain = Math.max(calculateMaxPath(node.right), 0);

        int currentPathSum = node.val + leftGain + rightGain;

        maxSum = Math.max(maxSum, currentPathSum);

        return node.val + Math.max(leftGain, rightGain);
    }
}
