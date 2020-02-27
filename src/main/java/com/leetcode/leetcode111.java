package com.leetcode;

/**
 * 给定一个二叉树，找出其最小深度。
 *
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例:
 *
 * 给定二叉树 [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回它的最小深度  2.
 */
public class leetcode111 {


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private int minDepth=Integer.MAX_VALUE;
    public int minDepth(TreeNode root) {
        if (root==null) return 0;
        minDp(root,1);
        return minDepth;
    }

    /**
     * 求得是叶子节点的最小深度
     * @param root
     * @param depth
     */
    private void minDp(TreeNode root,int depth){
        if (root.left==null&&root.right==null){
            if (depth<minDepth){
                minDepth=depth;
            }
            return;
        }
        if (root.left!=null){
            minDp(root.left,depth+1);
        }
        if (root.right!=null){
            minDp(root.right,depth+1);
        }
    }
}
