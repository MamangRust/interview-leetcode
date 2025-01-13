package com.sanedge.interview.binary_tree_dfs;

import com.sanedge.interview.utils.TreeNode;
import java.util.ArrayList;
import java.util.List;

public class LongestZigzagBinaryTree {

    public void getLeafSequence(TreeNode root, List<Integer> leaves) {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            leaves.add(root.val);
        }

        getLeafSequence(root.left, leaves);
        getLeafSequence(root.right, leaves);
    }

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leaves1 = new ArrayList<>();
        List<Integer> leaves2 = new ArrayList<>();

        getLeafSequence(root1, leaves1);
        getLeafSequence(root2, leaves2);

        if (leaves1.size() != leaves2.size()) {
            return false;
        }

        for (int i = 0; i < leaves1.size(); i++) {
            if (!leaves1.get(i).equals(leaves2.get(i))) {
                return false;
            }
        }

        return true;
    }
}
