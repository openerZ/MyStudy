package com.mynote;

import java.util.Stack;

/**
 * 给定一个后缀表达式数组将其转换成二叉树
 *
 * 后缀表达式其实是表达式树的后序表示
 * 表达式树：树叶是操作数，其他节点为操作符
 *
 *
 */
public class LastToTree {

    public class TreeNode {
        char val;
        TreeNode left;
        TreeNode right;

        public TreeNode(char val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        public TreeNode(char val) {
            this.val = val;
        }
    }

    public TreeNode transforTree(char[] arr){
        if (arr==null ||arr.length==0) return null;
        //借助栈
        Stack<TreeNode> stack = new Stack<>();
        int length = arr.length;
        TreeNode right;
        TreeNode left;
        for (int i=0;i<length;i++){
            char c = arr[i];
            if (c==1){  //如果是操作符 将栈中的两个元素弹出
                right = stack.pop();
                left = stack.pop();
                TreeNode op = new TreeNode(c, left, right);
                stack.push(op);
            }else {
                stack.push(new TreeNode(c));
            }

        }

        return stack.pop();

    }
}
