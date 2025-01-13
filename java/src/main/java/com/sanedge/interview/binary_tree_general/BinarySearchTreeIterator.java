package com.sanedge.interview.binary_tree_general;

import com.sanedge.interview.utils.TreeNode;
import java.util.Stack;

class BinarySearchTreeIterator {

    private Stack<TreeNode> stack;

    public BinarySearchTreeIterator(TreeNode root) {
        stack = new Stack<>();
        leftmostInorder(root);
    }

    private void leftmostInorder(TreeNode node) {
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
    }

    public int next() {
        TreeNode topNode = stack.pop();

        if (topNode.right != null) {
            leftmostInorder(topNode.right);
        }

        return topNode.val;
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }
}
