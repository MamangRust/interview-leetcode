package com.sanedge.interview.binary_tree_general;

import com.sanedge.interview.utils.TreeNode;

public class LowestCommont {

    public TreeNode lowestCommontAncestor(
        TreeNode root,
        TreeNode p,
        TreeNode q
    ) {
        if (root == null || root == p || root == q) {
            return root;
        }

        TreeNode left = lowestCommontAncestor(root.left, p, q);
        TreeNode right = lowestCommontAncestor(root.right, p, q);

        if (left != null && right != null) {
            return root;
        }

        if (left != null) {
            return left;
        }

        return right;
    }
}
