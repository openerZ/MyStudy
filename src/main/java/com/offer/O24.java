package com.offer;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * 题目描述
 * 输入一颗二叉树的跟节点和一个整数，
 * 打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 * (注意: 在返回值的list中，数组长度大的数组靠前)
 */
public class O24 {

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }
    //存储每个叶节点的路径数组
    ArrayList<ArrayList<Integer>> conform = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if (root ==null) return conform;
        TT(root,new ArrayList<>(),target,0);

        return conform;
    }

    public void TT(TreeNode node,ArrayList<Integer> list,int target,int sum){
        if (node==null ) {
            return;
        }
        ArrayList<Integer> arr = new ArrayList<>(list);
        sum+=node.val;
        arr.add(node.val);
        if (node.left==null && node.right==null && sum==target){
            conform.add(arr);
            return;
        }
       TT(node.left,arr,target,sum);
       TT(node.right,arr,target,sum);

    }
}
