package com.sanedge.interview.binary_tree_general;

import com.sanedge.interview.utils.TreeNode;
import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreePostOrder {

    private int postIndex;
    private Map<Integer, Integer> inorderMap;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        postIndex = postorder.length - 1;

        inorderMap = new HashMap<>();

        inorderMap = new HashMap<>();

        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }

        return helper(0, inorder.length - 1, postorder);
    }

    private TreeNode helper(int inLeft, int inRight, int[] postOrder) {
        if (inLeft > inRight) {
            return null;
        }

        int rootVal = postOrder[postIndex];

        TreeNode root = new TreeNode(rootVal);

        postIndex--;

        int index = inorderMap.get(rootVal);

        root.right = helper(index + 1, inRight, postOrder);

        root.left = helper(inLeft, index - 1, postOrder);

        return root;
    }
}
