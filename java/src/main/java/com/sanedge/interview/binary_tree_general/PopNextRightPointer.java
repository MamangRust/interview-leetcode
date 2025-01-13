package com.sanedge.interview.binary_tree_general;

import com.sanedge.interview.utils.Node;
import java.util.LinkedList;
import java.util.Queue;

public class PopNextRightPointer {

    public Node connect(Node root) {
        if (root == null) {
            return null;
        }

        Queue<Node> queue = new LinkedList<>();

        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();

            Node prev = null;

            for (int i = 0; i < levelSize; i++) {
                Node node = queue.poll();

                if (prev != null) {
                    prev.next = node;
                }

                prev = node;

                if (node.left != null) {
                    queue.offer(node.left);
                }

                if (node.right != null) {
                    queue.offer(node.right);
                }
            }

            if (prev != null) {
                prev.next = null;
            }
        }

        return root;
    }
}
