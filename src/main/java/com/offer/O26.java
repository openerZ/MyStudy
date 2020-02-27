package com.offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

/**
 * 题目描述
 * 输入一棵二叉搜索树，
 * 将该二叉搜索树转换成一个排序的双向链表。
 * 要求不能创建任何新的结点，只能调整树中结点指针的指向。
 */
public class O26 {

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    //存放中序遍历
    private ArrayList<TreeNode> list = new ArrayList<>();

    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null) return null;
        inOrder(pRootOfTree);
        //将中序遍历中节点变成双向链表
        for (int i = 1; i < list.size(); i++) {
            list.get(i - 1).right = list.get(i);
            list.get(i).left = list.get(i - 1);
        }

        return list.get(0);
    }

    /**
     * 中序遍历
     *
     * @param node
     * @return
     */
    private void inOrder(TreeNode node) {
        if (node == null) return;
        inOrder(node.left);
        list.add(node);
        inOrder(node.right);
    }

    private TreeNode pre = null; //存放当前节点的上一个节点
    private TreeNode head = null; //头结点也是最小的节点

    public TreeNode Convert1(TreeNode pRootOfTree) {
        if (pRootOfTree == null) return null;
        inOrder(pRootOfTree);
        return head;
    }

    private void inOrder1(TreeNode node) {
        if (node == null) return;
        inOrder(node.left);
        if (pre != null) {
            pre.right = node; //
        }
        node.left = pre;
        pre = node;
        if (head == null) {  //遍历到最小节点时赋值，只赋值一次
            head = node;
        }
        inOrder(node.right);
    }


    /**
     * 非递归
     *
     * @param pRootOfTree
     * @return
     */
    public TreeNode Convert3(TreeNode pRootOfTree) {
        if (pRootOfTree == null) {
            return null;
        }
        TreeNode head = null;
        boolean isFirst = true;
        Stack<TreeNode> s = new Stack<>();
        TreeNode pre = null;
        while (!s.isEmpty() || pRootOfTree != null) {
            if (pRootOfTree != null) { //先遍历到最左边的点也是最小的点
                s.push(pRootOfTree);
                pRootOfTree = pRootOfTree.left;

            } else {
                TreeNode cur = s.pop();
                if (isFirst) {
                    isFirst = false;
                    head = cur;
                    pre = cur;

                } else {
                    cur.left = pre;
                    pre.right = cur;
                    pre = cur;
                }
                pRootOfTree = cur.right;
            }
        }
        return head;
    }

    /**
     * 递归不借助空间
     *
     * @param root
     * @return
     */
    public TreeNode Convert4(TreeNode root) {
        if (root == null)
            return null;
        if (root.left == null && root.right == null)
            return root;
        // 1.将左子树构造成双链表，并返回链表头节点
        TreeNode left = Convert4(root.left);
        TreeNode p = left;
        // 2.定位至左子树双链表最后一个节点
        while (p != null && p.right != null) {
            p = p.right;
        }
        // 3.如果左子树链表不为空的话，将当前root追加到左子树链表
        if (left != null) {
            p.right = root;
            root.left = p;
        }
        // 4.将右子树构造成双链表，并返回链表头节点
        TreeNode right = Convert4(root.right);
        // 5.如果右子树链表不为空的话，将该链表追加到root节点之后
        if (right != null) {
            right.left = root;
            root.right = right;
        }
        return left != null ? left : root;
    }

    /**
     * 使用递归：
     *  中序遍历形式的递归
     *
     *
     * @param root
     * @return
     */
    public TreeNode Convert5(TreeNode root) {
        if (root == null) return null;

        //递归当前树的左子树，返回的是已经形成的双向链表的头节点
        TreeNode left = Convert5(root.left);
        //left不能动，他是连接之后的返回节点
        TreeNode p = left;
        //左链表返回的是头节点，但是要遍历到尾节点
        while (p != null && p.right != null) {
            p = p.right;
        }
        //进行左子链表与根节点的连接
        if (p != null) {
            p.right = root;
            root.left = p;
        }

        //递归右子树，返回的直接是右子链表的头节点
        TreeNode right = Convert5(root.right);
        if (right != null) {
            right.left = root;
            root.right = right;
        }

        return left != null ? left : root;

    }
}
