package com.sanedge.interview.binary_tree_bfs;

import com.sanedge.interview.utils.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AvgOfLevelBinaryTree {

    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> averages = new ArrayList<>();

        if (root == null) {
            return averages;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            double levelSum = 0;

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

            averages.add(levelSum / levelSize);
        }

        return averages;
    }
}
