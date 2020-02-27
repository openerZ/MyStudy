package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉搜索树（Binary Search Tree），把它转换成为累加树（Greater Tree)，使得每个节点的值是原来的节点值加上所有大于它的节点值之和。
 * <p>
 * 例如：
 * <p>
 * 输入: 二叉搜索树:
 * 5
 * /   \
 * 2     13
 * <p>
 * 输出: 转换为累加树:
 * 18
 * /   \
 * 20     13
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/convert-bst-to-greater-tree
 */
public class leetcode538 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode convertBST(TreeNode root) {
        inOrder(root);
        return root;
    }
    int pre=0;
    private void inOrder(TreeNode root) {
        if (root==null) return;
        inOrder(root.right);
        root.val +=pre;
        pre = root.val;
        inOrder(root.left);
    }
}