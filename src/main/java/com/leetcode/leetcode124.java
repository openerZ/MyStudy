package com.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class leetcode124 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        inOrder(root);
        return max;
    }

    private int inOrder(TreeNode root) {
        if (root == null) return 0;
        int left = inOrder(root.left);
        int right = inOrder(root.right);
        max = Math.max(max,(left > 0 ? left : 0) + (right > 0 ? right : 0) + root.val);
        return Math.max(left > 0 ? left : 0, right > 0 ? right : 0) + root.val;
    }
}
