package com.leetcode;

/**
 * 给定一个二叉树，原地将它展开为链表。
 * <p>
 * 例如，给定二叉树
 * <p>
 * 1
 * / \
 * 2   5
 * / \   \
 * 3   4   6
 * 将其展开为：
 * <p>
 * 1
 * \
 * 2
 * \
 * 3
 * \
 * 4
 * \
 * 5
 * \
 * 6
 */
public class leetcode114 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 前序遍历：遍历成链表的顺序就是前序遍历的顺序
     */
    TreeNode pre = null;
    public void flatten(TreeNode root) {
        if (root == null) return;
        //保存节点的右子树
        TreeNode right = root.right;
        if (pre == null){
            pre = root;
        }else {
            //上一个节点的右节点为当前节点
            pre.right=root;
            pre=root;
        }
        flatten(root.left);
        flatten(right);
        //因为已把当前节点的左子树原地变成右节点，所以左节点置为空
        root.left=null;
    }
}
