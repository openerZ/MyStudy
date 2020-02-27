package com.offer;

import sun.reflect.generics.tree.Tree;

/**
 * 题目描述
 * 输入一棵二叉树，求该树的深度。
 * 从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
 */
public class O38 {

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    int deepth = 0;

    public int TreeDepth(TreeNode root) {
        if (root == null) return deepth;
        maxdeepTh(root, 0);
        return deepth;
    }

    private void maxdeepTh(TreeNode node, int dp) {
        if (node == null){
            if (deepth < dp) {
                deepth = dp;
            }
            return;
        }
        dp++;
        maxdeepTh(node.left, dp);
        maxdeepTh(node.right, dp);
    }

    public int TreeDepth1(TreeNode root) {

        return root==null? 0: 1+Math.max(TreeDepth1(root.left),TreeDepth1(root.right));
    }

    /**
     * 树的最大深度和最大高度、最大层数都是相等的
     *
     * @param root
     * @return
     */
    public int TreeDepth2(TreeNode root) {
        if (root==null){
            return 0;
        }
        int leftdp = TreeDepth2(root.left);
        int rightdp = TreeDepth2(root.left);

        return 1+Math.max(leftdp,rightdp);


    }



}
