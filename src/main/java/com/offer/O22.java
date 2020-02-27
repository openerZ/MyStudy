package com.offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

/**
 * 题目描述
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 */
public class O22 {

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }

    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null) return list;

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode treeNode = queue.removeFirst();
            list.add(treeNode.val);
            if (treeNode.left != null) {
                queue.add(treeNode.left);
            }
            if (treeNode.right != null) {
                queue.add(treeNode.right);
            }
        }


        return list;
    }

    /**
     * 层序遍历打印换行的二叉树
     *
     * @param root
     */
    ArrayList<ArrayList<Integer> > Print(TreeNode root) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        if (root == null) return list;

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int p1 = 1;//当前行剩余要打印的
        int p2 = 0; //下一行要打印的
        ArrayList<Integer> row = new ArrayList<>();
        while (!queue.isEmpty()) {
            if (p1 > 0) {
                TreeNode treeNode = queue.removeFirst();
                row.add(treeNode.val);
                p1--;
                if (treeNode.left != null) {
                    queue.add(treeNode.left);
                    p2++;
                }
                if (treeNode.right != null) {
                    queue.add(treeNode.right);
                    p2++;
                }
            }
            if (p1==0){
                list.add(row);
                row = new ArrayList<>();
                p1 = p2;
                p2 = 0;
            }
        }
        return list;
    }


    /**
     * 使用递归打印换行二叉树
     * @param pRoot
     * @return
     */
    ArrayList<ArrayList<Integer> > Print1(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        depth(pRoot, 1, list);
        return list;
    }

    private void depth(TreeNode root, int depth, ArrayList<ArrayList<Integer>> list) {
        if(root == null) return;
        if(depth > list.size())
            list.add(new ArrayList<Integer>());
        list.get(depth -1).add(root.val);

        depth(root.left, depth + 1, list);
        depth(root.right, depth + 1, list);
    }

    /**
     * 之字形打印二叉树
     *借助一个栈
     * @param root
     */
    public ArrayList<ArrayList<Integer> > Print2(TreeNode root) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        if (root == null) return list;

        LinkedList<TreeNode> queue = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        queue.add(root);
        boolean flag = true;
        int p1 = 1;//当前行剩余要打印的
        int p2 = 0; //下一行要打印的
        ArrayList<Integer> row = new ArrayList<>();
        while (!queue.isEmpty()) {
            if (p1 > 0) {
                TreeNode treeNode = queue.removeFirst();
                row.add(treeNode.val);
                p1--;
                if (flag) {
                    if (treeNode.left != null) {
                        stack.push(treeNode.left);
                        p2++;
                    }
                    if (treeNode.right != null) {
                        stack.push(treeNode.right);
                        p2++;
                    }
                } else {
                    if (treeNode.right != null) {
                        stack.push(treeNode.right);
                        p2++;
                    }
                    if (treeNode.left != null) {
                        stack.push(treeNode.left);
                        p2++;
                    }
                }

            }
            if (p1==0){
                list.add(row);
                row = new ArrayList<>();
                p1 = p2;
                p2 = 0;
                flag = !flag;
                while (!stack.isEmpty()){
                    queue.add(stack.pop());
                }
            }
        }
        return list;
    }
}
