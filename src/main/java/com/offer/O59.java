package com.offer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 题目描述
 * 请实现两个函数，分别用来序列化和反序列化二叉树
 * 二叉树的序列化是指：把一棵二叉树按照某种遍历方式的结果以某种格式保存为字符串，
 * 从而使得内存中建立起来的二叉树可以持久保存。
 * 序列化可以基于先序、中序、后序、层序的二叉树遍历方式来进行修改，序列化的结果是一个字符串，
 * 序列化时通过 某种符号表示空节点（#），以 ！ 表示一个结点值的结束（value!）。
 * 二叉树的反序列化是指：根据某种遍历顺序得到的序列化字符串结果str，重构二叉树。
 */
public class O59 {


    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    /**
     * 前序序列化
     * @param root
     * @return
     */
    String Serialize(TreeNode root) {
        StringBuilder str = new StringBuilder();
        if (root == null) return str.append("#,").toString();
        str.append(root.val+",");
        str.append(Serialize(root.left));
        str.append(Serialize(root.right));
        return str.toString();
    }



    //前序反序列化
    int index=-1;
    TreeNode Deserialize(String str) {
        index++;
        int len = str.length();
        if(index >= len){
            return null;
         }
        String[] strr = str.split(",");
        TreeNode node = null;
        if(!strr[index].equals("#")){
            node = new TreeNode(Integer.valueOf(strr[index]));
            node.left = Deserialize(str);
            node.right = Deserialize(str);
        }
        return node;
    }

}
