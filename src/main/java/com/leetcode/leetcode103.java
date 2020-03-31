package com.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 *
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回锯齿形层次遍历如下：
 *
 * [
 *   [3],
 *   [20,9],
 *   [15,7]
 * ]
 */
public class leetcode103 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> ans = new ArrayList<>();
        if (root==null) return ans;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean flag = true;

        while (!queue.isEmpty()){
            int count = queue.size();
            ArrayList<Integer> list = new ArrayList<>();
            while (count>0){
                if (flag){
                    TreeNode poll = queue.pollLast();
                    list.add(poll.val);
                    if (poll.left!=null){
                        queue.offerFirst(poll.left);
                    }
                    if (poll.right!=null){
                        queue.offerFirst(poll.right);
                    }
                }else {
                    TreeNode poll = queue.pollFirst();
                    list.add(poll.val);
                    if (poll.right!=null){
                        queue.offerLast(poll.right);
                    }
                    if (poll.left!=null){
                        queue.offerLast(poll.left);
                    }
                }
                count--;
            }
            ans.add(list);
            flag=!flag;
        }
        return ans;
    }
}
