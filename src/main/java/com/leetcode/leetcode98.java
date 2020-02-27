package com.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 * <p>
 * 假设一个二叉搜索树具有如下特征：
 * <p>
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * 示例 1:
 * <p>
 * 输入:
 * 2
 * / \
 * 1   3
 * 输出: true
 * 示例 2:
 * <p>
 * 输入:
 * 5
 * / \
 * 1   4
 *      / \
 *     3   6
 * 输出: false
 * 解释: 输入为: [5,1,4,null,null,3,6]。
 *      根节点的值为 5 ，但是其右子节点值为 4 。
 */
public class leetcode98 {


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 使用了中序遍历
     */
    List<Integer> list = new ArrayList<>();
    public boolean isValidBST(TreeNode root) {
        if (root==null) return true;
        inOrder(root);
        if (list.size()<2) return true;
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i-1)>=list.get(i)){
                return false;
            }
        }
        return true;
    }
    private void inOrder(TreeNode root){
        if (root==null) return;
        inOrder(root.left);
        list.add(root.val);
        inOrder(root.right);
    }

    /**
     * 非递归实现树的中序遍历
     * @param root
     * @return
     */
    public boolean isValidBST1(TreeNode root) {
        if (root==null) return true;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre=null;
        TreeNode cur=root;

        while (cur!=null ||!stack.isEmpty()){
            while (cur!=null){
                stack.push(cur);
                cur=cur.left;
            }
            TreeNode pop = stack.pop();
            if (pre==null){
                pre=pop;
            }else {
                if (pre.val<pop.val){
                    pre.val=pop.val;
                }else {
                    return false;
                }
            }
            cur=pop.right;
        }

        return true;
    }
}
