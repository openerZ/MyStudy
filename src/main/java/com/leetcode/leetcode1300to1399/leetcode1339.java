package com.leetcode.leetcode1300to1399;

public class leetcode1339 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private int sum = 0;
    private long maxRes=0;
    public int maxProduct(TreeNode root) {
        if (root==null) return 0;
        sum = HX(root);
        HX(root);
        return (int) (maxRes % (1e9 + 7));
    }

    public int HX(TreeNode root){
        if (root==null) return 0;
        int val = root.val;

        val+=HX(root.left);
        val+=HX(root.right);

        if (sum!=0){
            maxRes=Math.max(maxRes,(long)val*(sum-val));
        }
        return val;
    }

    public static void main(String[] args) {


    }


}
