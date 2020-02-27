package com.leetcode;

import java.util.LinkedHashMap;
import java.util.LinkedList;

/**
 * 给定一个二叉树，检查它是否是镜像对称的。
 *
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 *
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 *
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 * 说明:
 *
 * 如果你可以运用递归和迭代两种方法解决这个问题，会很加分。
 *
 */
public class leetcode101 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 递归
     * @param root
     * @return
     */
    public boolean isSymmetric1(TreeNode root) {
        if (root==null) return true;
        return preOrder(root.left,root.right);
    }

    private boolean preOrder(TreeNode p,TreeNode q){
        if (p==null && q==null) return true;
        if (p==null ||q==null) return false;
        if (p.val==q.val){
            return preOrder(p.left,q.right) && preOrder(p.right,q.left);
        }else {
            return false;
        }
    }

    /**
     *
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        if (root==null) return true;
        LinkedList<TreeNode> queue = new LinkedList<>();
        if (root.left!=null){
            queue.offer(root.left);
        }
        if (root.right!=null){
            queue.offer(root.right);
        }
        while (!queue.isEmpty()){
            int size = queue.size();
            if ((size&1)!=0){
                return false;
            }

            StringBuilder s = new StringBuilder();
            while (size>0){
                TreeNode poll = queue.poll();
                if (poll.left!=null){
                    queue.offer(poll.left);
                }
                if (poll.right!=null){
                    queue.offer(poll.right);
                }
                size--;
                s.append(poll.val);
            }
            //判断s是否是回文字符
            if (!isDC(s)){
                return false;
            }
        }
        return true;
    }


    private boolean isDC(StringBuilder s){
        int len = s.length();
        for (int i = 0; i < len /2; i++) {
            if (s.charAt(i)!=s.charAt(len-i-1)){
                return false;
            }
        }
        return true;
    }

}
