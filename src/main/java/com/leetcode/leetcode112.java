package com.leetcode;

/**
 * 示例: 
 * 给定如下二叉树，以及目标和 sum = 22，
 *
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \      \
 *         7    2      1
 * 返回 true, 因为存在目标和为 22 的根节点到叶子节点的路径 5->4->11->2。
 *
 */
public class leetcode112 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root==null) return false;
        return hashPathSum1(root,sum);
    }

    private boolean hashPathSum1(TreeNode root, int sum){
        //叶子节点
        if (root.left==null && root.right==null){
            return sum==root.val;
        }
        boolean left=false;
        if (root.left!=null){
            left = hashPathSum1(root.left,sum-root.val);
        }
        boolean right = false;
        if (root.right!=null){
            right = hashPathSum1(root.right,sum-root.val);
        }
        return left||right;
    }

    public boolean hasPathSum2(TreeNode root, int sum) {
        if(root == null) return false;
        if(root.left==root.right) return sum == root.val;
        return hasPathSum(root.left,sum-root.val)||hasPathSum(root.right,sum-root.val);
    }
}
