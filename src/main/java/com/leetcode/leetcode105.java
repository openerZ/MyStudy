package com.leetcode;

/**
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 * <p>
 * 注意:
 * 你可以假设树中没有重复的元素。
 * <p>
 * 例如，给出
 * <p>
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 */
public class leetcode105 {


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length==0 || inorder.length==0||preorder.length!=inorder.length) return null;
        return buildTree(preorder,inorder,0,preorder.length-1,0,inorder.length-1);
    }

    private TreeNode buildTree(int[] preorder, int[] inorder,int pl,int pr,int il,int ir){
        if (pl>pr ||pl>=preorder.length ||il>ir) return null;
        TreeNode root = new TreeNode(preorder[pl]);
        int num=0;
        int k=0;
        for (int i = il; i <=ir ; i++) {
            if (preorder[pl]==inorder[i]){
                num=i-il;
                k=i;
                break;
            }
        }
        //左子树个数
        root.left = buildTree(preorder,inorder,pl+1,pl+num,il,k-1);
        root.right = buildTree(preorder,inorder,pl+num+1,pr,k+1,ir);
        return root;
    }
}
