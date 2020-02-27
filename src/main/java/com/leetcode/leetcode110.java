package com.leetcode;

/**
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 * <p>
 * 本题中，一棵高度平衡二叉树定义为：
 * <p>
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
 * <p>
 * 示例 1:
 * <p>
 * 给定二叉树 [3,9,20,null,null,15,7]
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回 true 。
 * <p>
 * 示例 2:
 * <p>
 * 给定二叉树 [1,2,2,3,3,null,null,4,4]
 * <p>
 * 1
 * / \
 * 2   2
 * / \
 * 3   3
 * / \
 * 4   4
 * 返回 false 。
 */
public class leetcode110 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private boolean flag = true;
    //自顶向下
    public boolean isBalanced1(TreeNode root) {
        if (root==null) return flag;
        isBalanced(root,0);
        return flag;
    }

    private int isBalanced(TreeNode root,int depth){
        if (!flag) return -1;
        if (root==null){
            return depth;
        }
        int leftdepth = isBalanced(root.left,depth+1);
        int rightdepth = isBalanced(root.right,depth+1);
        if (Math.abs(leftdepth-rightdepth)>1){
            flag=false;
            return -1;
        }else {
            return Math.max(leftdepth,rightdepth);
        }
    }

    //自顶向上
    public boolean isBalanced(TreeNode root) {
        return isBLC(root)!=-1;
    }
    private int isBLC(TreeNode root){
        if (root==null) return 0;
        int left = isBLC(root.left);
        if (left==-1) return -1;
        int right = isBLC(root.right);
        if (right==-1) return -1;

        return Math.abs(left-right)<2?Math.max(left,right)+1:-1;
    }
}
