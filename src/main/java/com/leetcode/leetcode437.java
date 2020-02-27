package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉树，它的每个结点都存放着一个整数值。
 *
 * 找出路径和等于给定数值的路径总数。
 *
 * 路径不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
 *
 * 二叉树不超过1000个节点，且节点数值范围是 [-1000000,1000000] 的整数。
 *
 * 示例：
 *
 * root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
 *
 *       10
 *      /  \
 *     5   -3
 *    / \    \
 *   3   2   11
 *  / \   \
 * 3  -2   1
 *
 * 返回 3。和等于 8 的路径有:
 *
 * 1.  5 -> 3
 * 2.  5 -> 2 -> 1
 * 3.  -3 -> 11
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/path-sum-iii
 */
public class leetcode437 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    private int count=0;
    //双重递归
    public int pathSum1(TreeNode root, int sum) {
        if (root==null) return 0;
        dfs1(root,sum,0);
        pathSum(root.left,sum);
        pathSum(root.right,sum);
        return count;
    }

    private void dfs1(TreeNode root,int sum,int k){
        if (root==null) return;
        k +=root.val;
        if (k==sum){
            count++;
        }
        dfs1(root.left,sum,k);
        dfs1(root.right,sum,k);
    }

    private List<Integer> list = new ArrayList<>();
    public int pathSum(TreeNode root, int sum) {
        dfs(root,sum);
        return count;
    }
    //回溯
    private void dfs(TreeNode root,int sum){
        if (root==null) return;
        int val = root.val;
        list.add(val);
        int k=0;
        for (int i = list.size()-1; i >=0 ; i--) {
            k+=list.get(i);
            if (k==sum){
                count++;
            }
        }
        dfs(root.left,sum);
        dfs(root.right,sum);
        list.remove(list.size()-1);
    }
}
