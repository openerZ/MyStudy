package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例:
 * 给定如下二叉树，以及目标和 sum = 22，
 *
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \    / \
 *         7    2  5   1
 * 返回:
 *
 * [
 *    [5,4,11,2],
 *    [5,8,4,5]
 * ]
 *
 */
public class leetcode113 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root==null) return res;
        pathSum(root,sum,new ArrayList<>());
        return res;
    }


    private void pathSum(TreeNode root,int sum,List<Integer> list){
        list.add(root.val);
        if (root.left==root.right){
            if (sum==root.val){
                //只有在符合要求时才copy list
                res.add(new ArrayList<>(list));
            }
        }
        if (root.left!=null){
            pathSum(root.left,sum-root.val,list);
        }
        if (root.right!=null){
            pathSum(root.right,sum-root.val,list);
        }
        //回到上一个节点时要把当前节点的值在列表中删除
        list.remove(list.size()-1);
    }

    public List<List<Integer>> pathSum1(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        HS(root,0,sum,res,new ArrayList<Integer>());
        return res;
    }

    private void HS(TreeNode root,int k,int sum,List<List<Integer>> res,List<Integer> list){
        if (root==null) return;
        k+=root.val;
        list.add(root.val);
        if (k==sum&&root.left==root.right){
            res.add(new ArrayList<>(list));
        }else {
            HS(root.left,k,sum,res,list);
            HS(root.right,k,sum,res,list);
        }
        //回溯
        list.remove(list.size()-1);
    }
}
