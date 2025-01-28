package com.sanedge.interview.binary_search_tree;

import com.sanedge.interview.utils.TreeNode;

public class SearchBinaryTree {

    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null || root.val == val) {
            return root;
        }

        if (val < root.val) {
            return searchBST(root.left, val);
        }

        return searchBST(root.right, val);
    }
}
