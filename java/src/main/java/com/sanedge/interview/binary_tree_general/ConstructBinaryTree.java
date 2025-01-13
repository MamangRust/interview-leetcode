package com.sanedge.interview.binary_tree_general;

import com.sanedge.interview.utils.TreeNode;
import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTree {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inorderMap = new HashMap<>();

        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }

        return build(
            preorder,
            0,
            preorder.length - 1,
            0,
            inorder.length - 1,
            inorderMap
        );
    }

    private TreeNode build(
        int[] preorder,
        int preStart,
        int preEnd,
        int inStart,
        int inEnd,
        Map<Integer, Integer> inorderMap
    ) {
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }

        int rootVal = preorder[preStart];
        TreeNode root = new TreeNode(rootVal);

        int rootIndex = inorderMap.get(rootVal);

        int leftTreeSize = rootIndex - inStart;

        root.left = build(
            preorder,
            preStart + 1,
            preStart + leftTreeSize,
            inStart,
            rootIndex - 1,
            inorderMap
        );

        root.right = build(
            preorder,
            preStart + leftTreeSize + 1,
            preEnd,
            rootIndex + 1,
            inEnd,
            inorderMap
        );

        return root;
    }
}
