package com.sanedge.interview.binary_tree_dfs;

import com.sanedge.interview.utils.TreeNode;

public class LeafSimiliarTree {

    public int longestZigZag(TreeNode root) {
        int maxLen = 0;

        dfs(root, -1, 0, maxLen);

        return maxLen;
    }

    public void dfs(TreeNode node, int isLeft, int length, int maxLen) {
        if (node == null) {
            return;
        }

        if (length > maxLen) {
            maxLen = length;
        }

        if (isLeft != 1) {
            dfs(node.left, 1, length + 1, maxLen);
        } else {
            dfs(node.left, 1, 1, maxLen);
        }

        if (isLeft != 0) {
            dfs(node.right, 0, length + 1, maxLen);
        } else {
            dfs(node.right, 0, length + 1, maxLen);
        }
    }
}
