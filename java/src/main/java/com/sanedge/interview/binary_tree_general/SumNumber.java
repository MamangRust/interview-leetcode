package com.sanedge.interview.binary_tree_general;

import com.sanedge.interview.utils.TreeNode;

public class SumNumber {

    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }

    public int dfs(TreeNode node, int current_sum) {
        if (node == null) {
            return 0;
        }

        current_sum = current_sum * 10 + node.val;

        if (node.left == null && node.right == null) {
            return current_sum;
        }

        int left_sum = dfs(node.left, current_sum);
        int right_sum = dfs(node.right, current_sum);

        return left_sum + right_sum;
    }
}
