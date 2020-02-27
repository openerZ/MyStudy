package com.offer;

import java.util.HashMap;

/**
 * 题目描述
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 */
public class O5 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    /**
     * 前序遍历的第一个值为根节点的值，使用这个值将中序遍历结果分成两部分，
     * 左部分为树的左子树中序遍历结果，
     * 右部分为树的右子树中序遍历的结果
     * 。然后分别对左右子树递归地求解。
     */
    //记录中序遍历的索引
    private HashMap<Integer,Integer> indexForIn = new HashMap<>();

    public  TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        int length = in.length;
        for (int i=0;i<length;i++){
            indexForIn.put(in[i],i);
        }

        return reConstructBinaryTree(pre,0,pre.length-1,0);
    }
    /**
     * 递归调用
     * @param pre 前序数组
     * @param preL 前序的起始位置
     * @param preR 前序的结束位置
     * @param inL 中序的起始位置
     * @return
     */
    private TreeNode reConstructBinaryTree(int[] pre, int preL, int preR, int inL) {
        if (preL>preR){
            return null;
        }
        int val = pre[preL]; //当前树的根节点的值
        Integer indexIn = indexForIn.get(val);  //根节点在中序数组的位置
        TreeNode root = new TreeNode(val);  //当前树的根节点
        //左子树的个数
        int leftSize = indexIn - inL;

        root.left = reConstructBinaryTree(pre,preL+1,preL+leftSize,inL);
        root.right = reConstructBinaryTree(pre,preL+leftSize+1,preR,inL+leftSize+1);

        return root;
    }


    public TreeNode reConstructBinaryTree2(int [] pre,int [] in) {
        TreeNode root=reConstructBinaryTree(pre,0,pre.length-1,in,0,in.length-1);
        return root;
    }
    //前序遍历{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}
    private TreeNode reConstructBinaryTree(int [] pre,int startPre,int endPre,int [] in,int startIn,int endIn) {

        if(startPre>endPre||startIn>endIn)
            return null;
        TreeNode root=new TreeNode(pre[startPre]);

        for(int i=startIn;i<=endIn;i++)
            if(in[i]==pre[startPre]){
                root.left=reConstructBinaryTree(pre,startPre+1,startPre+i-startIn,in,startIn,i-1);
                root.right=reConstructBinaryTree(pre,i-startIn+startPre+1,endPre,in,i+1,endIn);
                break;
            }

        return root;
    }
}
