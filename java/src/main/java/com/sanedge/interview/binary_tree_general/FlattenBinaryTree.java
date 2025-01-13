package com.sanedge.interview.binary_tree_general;

import com.sanedge.interview.utils.TreeNode;

public class FlattenBinaryTree {

    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        TreeNode current = root;

        while (current != null) {
            if (current.left != null) {
                TreeNode right_most = current.left;

                while (right_most.right != null) {
                    right_most = right_most.right;
                }

                right_most.right = current.right;

                current.right = current.left;

                current.left = null;
            }

            current = current.right;
        }
    }
}
