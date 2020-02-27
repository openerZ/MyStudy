package com.offer;

import sun.reflect.generics.tree.Tree;

/**
 * 题目描述
 * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 *
 */
public class O39 {

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    /**
     * 判断左子树与右子树的高度差绝对值不超过1
     *
     * @param root
     * @return
     */


    private boolean isBalanced=true;
    public boolean IsBalanced_Solution(TreeNode root) {
        AbsLength(root);
        return isBalanced;
    }

    private int AbsLength(TreeNode node){
        if (node ==null || !isBalanced){
            return 0;
        }
        int left = AbsLength(node.left);
        int right = AbsLength(node.right);
        //比较当前树的左子树和右子树的高度差
        if (Math.abs(left-right)>1){
            isBalanced = false;
        }
        return 1+Math.max(left,right);
    }
}
