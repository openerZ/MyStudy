package com.leetcode;


public class leetcode543 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    int max=0;
    public int diameterOfBinaryTree(TreeNode root) {
        if (root==null) return max;
        order(root);
        return max;
    }

    public int order(TreeNode node){
        if (node==null) return 0;
        int left =order(node.left);
        int right =order(node.right);

        max = Math.max(max,left+right);
        return Math.max(left,right)+1;

    }
}
