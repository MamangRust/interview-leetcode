package com.sanedge.interview.binary_tree_bfs;

import com.sanedge.interview.utils.TreeNode;
import java.util.LinkedList;
import java.util.Queue;

public class MaxLevelSumBinaryTree {

    public int maxLevelSum(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int level = 1;
        int maxLevel = 1;
        int maxSum = root.val;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSum = 0;
            int levelSize = queue.size();

            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();

                levelSum += node.val;

                if (node.left != null) {
                    queue.offer(node.left);
                }

                if (node.right != null) {
                    queue.offer(node.right);
                }
            }

            if (levelSum > maxSum) {
                maxSum = levelSum;
                maxLevel = level;
            }

            level++;
        }

        return maxLevel;
    }
}
