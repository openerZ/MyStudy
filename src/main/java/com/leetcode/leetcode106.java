package com.leetcode;

/**
 *根据一棵树的中序遍历与后序遍历构造二叉树。
 *
 * 注意:
 * 你可以假设树中没有重复的元素。
 *
 * 例如，给出
 *
 * 中序遍历 inorder = [9,3,15,20,7]
 * 后序遍历 postorder = [9,15,7,20,3]
 * 返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 */
public class leetcode106 {


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (postorder.length==0 || inorder.length==0||postorder.length!=inorder.length) return null;
        return buildTree(inorder,0,inorder.length-1,postorder,0,postorder.length-1);
    }

    private TreeNode buildTree(int[] inorder,int il,int ir, int[] postorder,int pl,int pr){
        if (pl>pr ||pl>=postorder.length ||il>ir) return null;
        TreeNode root = new TreeNode(postorder[pr]);
        int num=0;//左子树个数
        int k=0;
        for (int i = il; i <=ir ; i++) {
            if (postorder[pr]==inorder[i]){
                num=i-il;
                k=i;
                break;
            }
        }
        root.left = buildTree(inorder,il,k-1,postorder,pl,pl+num-1);
        root.right = buildTree(inorder,k+1,ir,postorder,pl+num,pr-1);
        return root;
    }
}
