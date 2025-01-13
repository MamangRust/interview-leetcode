package com.sanedge.interview.binary_tree_general;

import com.sanedge.interview.utils.TreeNode;

public class CountCompleteTreeNode {

    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftDepth = getDepth(root.left);
        int rightDept = getDepth(root.right);

        if (leftDepth == rightDept) {
            return (1 << leftDepth) + countNodes(root.right);
        } else {
            return (1 << rightDept) + countNodes(root.left);
        }
    }

    private int getDepth(TreeNode node) {
        int depth = 0;

        while (node != null) {
            depth++;
            node = node.left;
        }

        return depth;
    }
}
