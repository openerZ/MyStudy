package com.offer;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 题目描述
 * 给定一棵二叉搜索树，请找出其中的第k小的结点。
 * 例如， （5，3，7，2，4，6，8）    中，按结点数值大小顺序第三小结点的值为4。
 */
public class O51 {

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    /**
     * 使用了二叉树的中序遍历，因为遍历后的到的数组是排序的
     * 直接找第k个
     *
     * @param pRoot
     * @param k
     * @return
     */
    TreeNode KthNode(TreeNode pRoot, int k) {
        if (pRoot == null || k <= 0) return null;
        ArrayList<TreeNode> list = new ArrayList<>();
        inOrder(pRoot, list);
        if (list.size() >= k) {
            return list.get(k - 1);
        }

        return null;
    }

    private void inOrder(TreeNode node, ArrayList<TreeNode> list) {
        if (node == null) return;
        inOrder(node.left, list);
        list.add(node);
        inOrder(node.right, list);
    }

    /**
     * 借助栈使用非递归
     * @param pRoot
     * @param k
     * @return
     */
    TreeNode KthNode1(TreeNode pRoot, int k) {
        if (pRoot == null || k <= 0) return null;

        int index = 0;
        TreeNode cur = pRoot;
        Stack<TreeNode> stack = new Stack<>();
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            index++;
            if (index == k) return cur;
            cur = cur.right;
        }
        return null;
    }

    /**
     * 不借助额外空间
     * @param pRoot
     * @param k
     * @return
     */
    private int index= 0;
    TreeNode KthNode2(TreeNode pRoot, int k) {
        if (pRoot == null || k <= 0) return null;

        TreeNode node = KthNode2(pRoot.left, k);
        //只有符合要求时返回的才不是null
        if (node!=null){
            return node;
        }
        index++;
        if (index==k){ //符合要求返回
            return pRoot;
        }
        node = KthNode2(pRoot.right, k);
        if (node!=null){
            return node;
        }
        return null;
    }

}
