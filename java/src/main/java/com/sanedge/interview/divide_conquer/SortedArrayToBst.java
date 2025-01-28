package com.sanedge.interview.divide_conquer;

import com.sanedge.interview.utils.TreeNode;

public class SortedArrayToBst {

    public TreeNode sortedArrayToBst(int[] nums) {
        return buildBST(nums, 0, nums.length - 1);
    }

    private TreeNode buildBST(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }

        int mid = start + (end - start) / 2;

        TreeNode root = new TreeNode(nums[mid]);

        root.left = buildBST(nums, start, mid - 1);
        root.right = buildBST(nums, mid + 1, end);

        return root;
    }

    public void preorderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }

        System.out.print(root.val + " ");

        preorderTraversal(root.left);
        preorderTraversal(root.right);
    }
}
